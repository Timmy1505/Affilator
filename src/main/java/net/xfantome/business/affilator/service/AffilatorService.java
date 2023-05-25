package net.xfantome.business.affilator.service;

import net.xfantome.business.affilator.POJO.Affilatorreq;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.entity.Affilator;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface AffilatorService {

    Set<Affilator> getAllAffilators();
    Affilator getAffilatorById(String id) ;
    ApiResponse CreateAffilator(Affilatorreq req);
    void UpdateAffilator(String id, Affilatorreq req) ;
    void  DeleteAffilator(String id);
   // String login(String email, String password);
    void setPassword(String userId, String password);
    boolean verifyEmail(String verificationToken);
    String getPasswordSetupUrl(String userId);
}
