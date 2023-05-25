package net.xfantome.business.affilator.service.ServiceImpl;
import net.xfantome.business.affilator.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String recipientEmail, String verificationUrl, String passwordSetupUrl) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipientEmail);
            message.setFrom("web@xfantome.net");
            message.setSubject("Email Verification");
            message.setText("Please verify your email address by clicking the link below:\n\n"
                    + verificationUrl + "\n\n"
                    + "After verification, please click the link below to set and confirm your password:\n\n"
                    + passwordSetupUrl);
            mailSender.send(message);
        } catch (MailException e) {

            e.printStackTrace();
        }

    }

    public void sendPasswordSetupEmail(String email, String passwordSetupUrl) {
        // Email sending logic
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Setup");
        message.setText("Dear User,\n\n"
                + "You have successfully verified your email address. "
                + "Please click the link below to set up your password:\n\n"
                + passwordSetupUrl + "\n\n"
                + "Thank you.\n"
                + "Best regards,\n"
                + "Your Application");

        try {
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            // Handle email sending exception
        }
    }
}

