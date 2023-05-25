package net.xfantome.business.affilator.repository;

import net.xfantome.business.affilator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import net.xfantome.business.affilator.entity.Project;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectRepository  extends JpaRepository<Project, String>{

    @Query("select p from Project  as p where  p.deleted = false  ")
    public Set<Project> all();
    List<Project> findByClientId(String clientId);
    Set<Project> findAllByTransactionIsNull();


}
