package net.xfantome.business.affilator.repository;
import net.xfantome.business.affilator.entity.Project;
import net.xfantome.business.affilator.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select t from Transaction as t where  t.deleted = false  ")
       Set<Transaction> all();
    Optional<Transaction> findById(String transactionId);

}
