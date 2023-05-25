package net.xfantome.business.affilator.service;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.TransactionReq;
import net.xfantome.business.affilator.entity.Transaction;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface TransactionService {
    ApiResponse CreateTransaction( TransactionReq req);
     Set<Transaction> getAllTransactions();

}
