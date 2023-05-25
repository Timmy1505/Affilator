package net.xfantome.business.affilator.service.ServiceImpl;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.TransactionReq;
import net.xfantome.business.affilator.entity.Transaction;
import net.xfantome.business.affilator.repository.ProjectRepository;
import net.xfantome.business.affilator.repository.TransactionRepository;
import net.xfantome.business.affilator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;


@Component
public class TransactionImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public TransactionImpl(TransactionRepository transactionRepository, ProjectRepository projectRepository) {
        this.transactionRepository = transactionRepository;
        this.projectRepository = projectRepository;
    }


    public ApiResponse CreateTransaction(TransactionReq req) {
        Transaction  t = new Transaction();
        t.setPercentage(req.getPercentage());
        t.setStatus(req.getStatus());
        transactionRepository.save(t);
        return ApiResponse.builder().id(t.getId()).build();
    }


    public Set<Transaction> getAllTransactions() {
        return transactionRepository.all();
    }


}
