package net.xfantome.business.affilator.service.ServiceImpl;
import java.util.Set;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.ClientReq;
import net.xfantome.business.affilator.POJO.ProjectReq;
import net.xfantome.business.affilator.entity.Project;
import net.xfantome.business.affilator.entity.Transaction;
import net.xfantome.business.affilator.repository.ProjectRepository;
import net.xfantome.business.affilator.repository.TransactionRepository;
import net.xfantome.business.affilator.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.xfantome.business.affilator.entity.Client;
import net.xfantome.business.affilator.repository.ClientRepository;

@Component
public class ClientImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

     @Autowired
	 private ProjectRepository  projectRepository;

     @Autowired
	 private TransactionRepository transactionRepository;

	public Set<Client> getAllClients(){
		
		return clientRepository.all();
	}

	public Client getClientById(String id) {

		return clientRepository.findById(id).orElse(null);

	}

	public ApiResponse CreateClient(ClientReq req, ProjectReq projectReq) {
		Client client = new Client();
		client.setFirstName(req.getFirstName());
		client.setLastName(req.getLastName());
		client.setEmail(req.getEmail());
		client.setStatus(req.getStatus());
		clientRepository.save(client);
		Project project = new Project();
		project.setSummary(projectReq.getSummary());
		project.setPrice(projectReq.getPrice());
		project.setDate(projectReq.getDate());
		project.setStartDate(projectReq.getStartDate());
		project.setEndDate(projectReq.getEndDate());
		project.setStatus(projectReq.getStatus());
		project.setClient(client);
		String transactionId = projectReq.getTransactionId();
		Transaction transaction= transactionRepository.findById(transactionId).orElse(null);
		 project.setTransaction(transaction);
		projectRepository.save(project);
		return ApiResponse.builder().id(client.getId()).build();
	}


	public void UpdateClient(String id, ClientReq req) {
		clientRepository.findById(id).ifPresent((e)-> {
			e.setFirstName(req.getFirstName());
			e.setLastName(req.getLastName());
			e.setEmail(req.getEmail());
			e.setStatus(req.getStatus());
			clientRepository.save(e);
		});
	}
	
	
	public void  DeleteClient(String id ) {
		clientRepository.findById(id).ifPresent((e)-> {
			e.setDeleted(true);
			clientRepository.save(e);
		});


	}

}
