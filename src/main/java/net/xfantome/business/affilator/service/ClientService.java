package net.xfantome.business.affilator.service;

import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.ClientAndProjectReq;
import net.xfantome.business.affilator.POJO.ClientReq;
import net.xfantome.business.affilator.POJO.ProjectReq;
import net.xfantome.business.affilator.entity.Client;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface ClientService {

     Set<Client> getAllClients();
     Client getClientById(String id) ;
     ApiResponse  CreateClient(ClientReq req, ProjectReq projectReq);
    void UpdateClient(String id, ClientReq req) ;
    void  DeleteClient(String id);

}
