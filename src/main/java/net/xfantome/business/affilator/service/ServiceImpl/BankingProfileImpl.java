package net.xfantome.business.affilator.service.ServiceImpl;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.BankingProfileReq;
import net.xfantome.business.affilator.entity.BankingProfile;
import net.xfantome.business.affilator.repository.BankingProfileRepository;
import net.xfantome.business.affilator.service.BankingProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class BankingProfileImpl implements BankingProfileService {
    private final BankingProfileRepository bankingProfileRepository;

    @Autowired
    public BankingProfileImpl(BankingProfileRepository bankingProfileRepository) {
        this.bankingProfileRepository = bankingProfileRepository;
    }

    public Set<BankingProfile> getAllBankProfiles() {
        return bankingProfileRepository.all();
    }

    public BankingProfile getBankProfileById(String id) {
        return null;
    }

    public ApiResponse CreateBankProfile(BankingProfileReq req) {
//        List<String> errorMessages = new ArrayList<>();
//        // Check if the rib already exists
//        if (bankingProfileRepository.existsByRib(req.getRib())) {
//            errorMessages.add("Banking profile with this rib already exists");
//        }
//        // Check if the list of error messages is not empty
//        if (!errorMessages.isEmpty()) {
//            // Throw the exception with the list of error messages
//            throw new DataIntegrityViolationException(errorMessages.toString());
//        }
        BankingProfile bp = new BankingProfile();
        bp.setCity(req.getCity());
        bp.setCountry(req.getCountry());
        bp.setBankName(req.getBankName());
        bp.setRib(req.getRib());
        bankingProfileRepository.save(bp);
        return ApiResponse.builder().id(bp.getId()).build();
    }



    public void UpdateBankProfile(String id, BankingProfileReq req) {
        bankingProfileRepository.findById(id).ifPresent((e) -> {
            e.setCity(req.getCity());
            e.setCountry(req.getCountry());
            e.setBankName(req.getBankName());
            e.setRib(req.getRib());
            bankingProfileRepository.save(e);
        });
    }

    public void DeleteBankProfile(String id) {
        bankingProfileRepository.findById(id).ifPresent((e) -> {
            e.setDeleted(true);
            bankingProfileRepository.save(e);
        });
    }
}
