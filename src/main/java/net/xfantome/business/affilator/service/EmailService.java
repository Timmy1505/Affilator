package net.xfantome.business.affilator.service;


import org.springframework.stereotype.Service;



@Service
public interface EmailService {
    void sendVerificationEmail(String recipientEmail, String verificationUrl, String passwordSetupUrl);
    void sendPasswordSetupEmail(String email, String passwordSetupUrl);
}