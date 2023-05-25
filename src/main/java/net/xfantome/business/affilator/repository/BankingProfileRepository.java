package net.xfantome.business.affilator.repository;

import net.xfantome.business.affilator.entity.Affilator;
import net.xfantome.business.affilator.entity.BankingProfile;
import net.xfantome.business.affilator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;


@Repository
public interface BankingProfileRepository extends JpaRepository<BankingProfile, String> {

    @Query("SELECT CASE WHEN COUNT(bp) > 0 THEN true ELSE false END FROM BankingProfile bp WHERE bp.rib = :rib")
    boolean existsByRib(@Param("rib") String rib);


    @Query("select b from BankingProfile as b where b.deleted=  false ")
    Set<BankingProfile> all();
    Optional<BankingProfile> findById(String bankingProfileId);


}

