package net.xfantome.business.affilator.service;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.BankingProfileReq;
import net.xfantome.business.affilator.entity.BankingProfile;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface BankingProfileService  {

    Set<BankingProfile> getAllBankProfiles();
    ApiResponse CreateBankProfile(BankingProfileReq req);
    void UpdateBankProfile(String id, BankingProfileReq req) ;
    void  DeleteBankProfile(String id);

}
