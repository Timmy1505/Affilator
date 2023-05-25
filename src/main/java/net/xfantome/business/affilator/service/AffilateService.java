package net.xfantome.business.affilator.service;
import net.xfantome.business.affilator.POJO.AffilateReq;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.entity.Affilate;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface AffilateService   {

     Set<Affilate> getAllAffilates();
     Affilate getAffilateById(String id) ;
     ApiResponse CreateAffilate(AffilateReq req);
     void UpdateAffilate(String id, AffilateReq req) ;
      void  DeleteAffilate(String id);

}
