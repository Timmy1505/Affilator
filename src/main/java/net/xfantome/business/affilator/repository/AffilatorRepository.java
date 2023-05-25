package net.xfantome.business.affilator.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.xfantome.business.affilator.entity.Affilator;

@Repository
public interface AffilatorRepository extends JpaRepository<Affilator, String> {

	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Affilator a WHERE a.email = :email")
	boolean existsByEmail(@Param("email") String email);

	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Affilator a WHERE a.phone = :phone")
	boolean existsByPhone(@Param("phone") String phone);

	@Query("SELECT a FROM Affilator a WHERE a.deleted = false")
	Set<Affilator> all();

	Optional<Affilator> findByEmail(String email);

	Optional<Affilator> findByVerificationToken(String verificationToken);

	void deleteByVerificationToken(String verificationToken);
}
