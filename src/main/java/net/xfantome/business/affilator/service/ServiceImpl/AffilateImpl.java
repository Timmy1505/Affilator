package net.xfantome.business.affilator.service.ServiceImpl;
import net.xfantome.business.affilator.POJO.AffilateReq;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.entity.Affilate;
import net.xfantome.business.affilator.repository.AffilateRepository;
import net.xfantome.business.affilator.service.AffilateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class AffilateImpl implements AffilateService {

    @Autowired
    private AffilateRepository  affilateRepository;

    public Set<Affilate> getAllAffilates() {
        return  affilateRepository.all();
    }

    public Affilate getAffilateById(String id) {
       return  affilateRepository.findById(id).orElse(null);
    }

    public ApiResponse CreateAffilate(AffilateReq req) {
        Affilate a = new Affilate();
        a.setFullName(req.getFullName());
        a.setEmail(req.getEmail());
        a.setPhone(req.getPhone());
        a.setAddress(req.getAddress());
        affilateRepository.save(a);
        return ApiResponse.builder().id(a.getId()).build();
    }

    public void UpdateAffilate(String id, AffilateReq req) {
        affilateRepository.findById(id).ifPresent((e)-> {
            e.setFullName(req.getFullName());
            e.setEmail(req.getEmail());
            e.setPhone(req.getPhone());
            e.setAddress(req.getAddress());
            affilateRepository.save(e);
        });
    }

    public void DeleteAffilate(String id) {
        affilateRepository.findById(id).ifPresent((e)-> {
            e.setDeleted(true);
           affilateRepository.save(e);
        });
    }
}
