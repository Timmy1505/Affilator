package net.xfantome.business.affilator.service.ServiceImpl;
import net.xfantome.business.affilator.JWT.JwtUtil;
import net.xfantome.business.affilator.POJO.Affilatorreq;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.entity.Affilator;
import net.xfantome.business.affilator.entity.BankingProfile;
import net.xfantome.business.affilator.repository.AffilatorRepository;
import net.xfantome.business.affilator.repository.BankingProfileRepository;
import net.xfantome.business.affilator.service.AffilatorService;
import net.xfantome.business.affilator.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.Set;


@Component
public class AffilatorImpl implements AffilatorService {
    @Autowired
    private AffilatorRepository affilatorRepository;
    @Autowired
    private BankingProfileRepository bankingProfileRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private EmailService emailService;
    @Autowired
    private TokenService tokenService;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public Set<Affilator> getAllAffilators() {
        return affilatorRepository.all();
    }

    public Affilator getAffilatorById(String id) {
        return affilatorRepository.findById(id).orElse(null);
    }

    public ApiResponse CreateAffilator(Affilatorreq req) {
        Affilator a = new Affilator();
        String verificationToken = tokenService.generateVerificationToken(a.getId());
        // Construct the verification URL
        String verificationUrl = "http://localhost:8097/api/verify?token=" + verificationToken;
        // Generate a unique token for password setup
        String passwordSetupToken = tokenService.generatePasswordSetupToken(a.getId());
        // Construct the password setup URL
        String passwordSetupUrl = "http://localhost:8097/api/password-setup?token=" + passwordSetupToken;
        // Send the verification email with the verification and password setup URLs
        new Thread(() ->{
            emailService.sendVerificationEmail(req.getEmail(), verificationUrl, passwordSetupUrl);
        }).start();
        a.setFirstName(req.getFirstName());
        a.setLastName(req.getLastName());
        a.setEmail(req.getEmail());
        a.setPhone(req.getPhone());
        a.setAddress(req.getAddress());
        a.setAffiliate_code(req.getAffiliate_code());
        a.setCountry(req.getCountry());
        a.setCity(req.getCity());
        String bankingProfileId = req.getBankingProfileId();
        BankingProfile bankingProfile = bankingProfileRepository.findById(bankingProfileId).orElse(null);
        a.setBankingProfile(bankingProfile); // Set the banking profile in the Affilator
        affilatorRepository.save(a);
        String userId = a.getId(); // Assuming 'id' is the unique identifier of the user
        String token = jwtUtil.generateToken(userId);
        a.setVerificationToken(verificationToken);
        return ApiResponse.builder().id(a.getId()).token(token).build();
    }

    public void UpdateAffilator(String id, Affilatorreq req) {
        affilatorRepository.findById(id).ifPresent((e) -> {
            e.setFirstName(req.getFirstName());
            e.setLastName(req.getLastName());
            e.setEmail(req.getEmail());
            e.setPhone(req.getPhone());
            e.setAddress(req.getAddress());
            e.setAffiliate_code(req.getAffiliate_code());
            e.setCountry(req.getCountry());
            e.setCity(req.getCity());
            affilatorRepository.save(e);
        });
    }

    public void DeleteAffilator(String id) {
        affilatorRepository.findById(id).ifPresent((e) -> {
            e.setDeleted(true);
            affilatorRepository.save(e);
        });
    }


//    public String login(String email, String password) {
//        Optional<Affilator> affilator = affilatorRepository.findByEmail(email);
//        if (affilator.isPresent() && passwordEncoder.matches(password, affilator.get().getPassword()) && affilator.get().isEmailVerified()) {
//            // Generate and return a token for successful login
//            String userId = affilator.get().getId();
//            return jwtUtil.generateToken(userId);
//        }
//        return null; // Invalid credentials or email not verified
//    }




    public boolean verifyEmail(String verificationToken) {
        Optional<Affilator> affilator = affilatorRepository.findByVerificationToken(verificationToken);
        if (affilator.isPresent()) {
            affilatorRepository.deleteByVerificationToken(verificationToken);
            return true;
        }
        return false;
    }

    public String getPasswordSetupUrl(String userId) {
        // Generate a unique token for password setup
        String passwordSetupToken = tokenService.generatePasswordSetupToken(userId);
        // Construct the password setup URL
        String passwordSetupUrl = "http://localhost:8097/api/password-setup?token=" + passwordSetupToken;
        return passwordSetupUrl;
    }

    public void setPassword(String userId, String password) {
        Optional<Affilator> affilator = affilatorRepository.findById(userId);
        if (affilator.isPresent()) {
            // Encrypt the password
            String hashedPassword = passwordEncoder.encode(password);
            Affilator user = affilator.get();
            user.setPassword(hashedPassword);
            affilatorRepository.save(user);
        }
    }








}
