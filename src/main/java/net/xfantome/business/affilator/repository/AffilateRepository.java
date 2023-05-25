package net.xfantome.business.affilator.repository;

import net.xfantome.business.affilator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import net.xfantome.business.affilator.entity.Affilate;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AffilateRepository extends JpaRepository<Affilate, String> {
    @Query("select af from Affilate as af where af.deleted=false ")
    public Set<Affilate> all();
}
