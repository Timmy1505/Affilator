package net.xfantome.business.affilator.service.ServiceImpl;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.ProjectReq;
import net.xfantome.business.affilator.entity.Project;
import net.xfantome.business.affilator.entity.Client;
import net.xfantome.business.affilator.entity.Transaction;
import net.xfantome.business.affilator.repository.ProjectRepository;
import net.xfantome.business.affilator.repository.ClientRepository;
import net.xfantome.business.affilator.repository.TransactionRepository;
import net.xfantome.business.affilator.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ProjectImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public ProjectImpl(ProjectRepository projectRepository, ClientRepository clientRepository, TransactionRepository transactionRepository) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
        this.transactionRepository = transactionRepository;
    }

    public Set<Project> getAllProjects() {
        return projectRepository.all();
    }

    public List<Project> getProjectsByClientId(String clientId) {
        return projectRepository.findByClientId(clientId);
    }

    public ApiResponse CreateProject(ProjectReq req) {
        Project p = new Project();
        p.setSummary(req.getSummary());
        p.setPrice(req.getPrice());
        p.setDate(req.getDate());
        p.setStartDate(req.getStartDate());
        p.setEndDate(req.getEndDate());
        p.setStatus(req.getStatus());
        String clientId = req.getClientId();
        Client client = clientRepository.findById(clientId).orElse(null);
        p.setClient(client);

        String transactionId = req.getTransactionId();
        Transaction transaction= transactionRepository.findById(transactionId).orElse(null);
        p.setTransaction(transaction);

        projectRepository.save(p);
        return ApiResponse.builder().id(p.getId()).build();
    }

    public void UpdateProject(String id, ProjectReq req) {
        projectRepository.findById(id).ifPresent((e) -> {
            e.setSummary(req.getSummary());
            projectRepository.save(e);
        });
    }

    public void DeleteProject(String id) {
        projectRepository.findById(id).ifPresent((e) -> {
            e.setDeleted(true);
            projectRepository.save(e);
        });
    }
}
