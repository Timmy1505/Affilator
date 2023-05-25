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
}

