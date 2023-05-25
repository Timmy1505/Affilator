package net.xfantome.business.affilator.contoller;
import net.xfantome.business.affilator.service.AffilatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    @Autowired
    private AffilatorService affilatorService;

    @Value("${app.password-setup-url}")
    private String passwordSetupUrl;  // Assuming the password setup URL is configured in your application properties

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String verificationToken) {
        if (affilatorService.verifyEmail(verificationToken)) {
            String setupPasswordLink = "<a href='" + passwordSetupUrl + "'>Set up your password</a>";
            String message = "Email verified successfully! " + setupPasswordLink;
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.badRequest().body("Invalid verification token. Please try again.");
        }
    }
    
    //i havent tested this code i hope it provides you with a general idea to set password 
    @GetMapping("/password-setup")
    public ResponseEntity<String> getPasswordSetupPage(@RequestParam("token") String token) {
        Optional<Affilator> affilator = affilatorRepository.findByVerificationToken(token);
        if (affilator.isPresent()) {
            return ResponseEntity.ok("Password setup page");
        }
        return ResponseEntity.badRequest().body("Invalid verification token.");
    }

    @PostMapping("/password-setup")
    public ResponseEntity<String> setPassword(@RequestParam("token") String token, @RequestParam("password") String password) {
        Optional<Affilator> affilator = affilatorRepository.findByVerificationToken(token);
        if (affilator.isPresent()) {
            Affilator user = affilator.get();
            if (user.getPassword() != null) {
                return ResponseEntity.badRequest().body("Password is already set.");
            }
            // call setPassword(String userId, String password) method
            affilatorService.setPassword(affilator,getId(), password);
            return ResponseEntity.ok("Password set successfully.");
        }
        return ResponseEntity.badRequest().body("Invalid verification token.");
    }
}

