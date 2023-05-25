package net.xfantome.business.affilator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.xfantome.business.affilator.entity.Client;
import java.util.Optional;
import java.util.Set;


@Repository
public interface ClientRepository  extends JpaRepository<Client, String>{

    @Query("select c from Client as c where c.deleted=  false ")
     Set<Client> all();
    Optional<Client> findById(String clientId);

}
