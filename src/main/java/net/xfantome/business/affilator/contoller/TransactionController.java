package net.xfantome.business.affilator.contoller;
import io.swagger.v3.oas.annotations.Operation;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.TransactionReq;
import net.xfantome.business.affilator.entity.Transaction;
import net.xfantome.business.affilator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "get all transaction")
    @GetMapping
    public ResponseEntity<Set<Transaction>> getAllTransactions() {

        return new ResponseEntity<>(
                transactionService.getAllTransactions(), HttpStatus.OK
        );
    }

    @Operation(summary = "create new transaction")
    @PostMapping
    public ResponseEntity<ApiResponse> createTransaction(@RequestBody TransactionReq req) {
       return new ResponseEntity<>(
               transactionService.CreateTransaction(req),
               HttpStatus.OK);
    }


}
