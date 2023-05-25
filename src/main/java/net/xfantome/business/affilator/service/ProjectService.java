package net.xfantome.business.affilator.service;


import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.ClientReq;
import net.xfantome.business.affilator.POJO.ProjectReq;
import net.xfantome.business.affilator.entity.Client;
import net.xfantome.business.affilator.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ProjectService {

     Set<Project> getAllProjects();
    List  getProjectsByClientId( String clientId);
     ApiResponse CreateProject(ProjectReq req);
     void UpdateProject(String id, ProjectReq req) ;
    void  DeleteProject(String id);

}
