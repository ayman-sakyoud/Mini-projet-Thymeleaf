package com.parcinformatique.repository;

import com.parcinformatique.entity.Affectation;
import com.parcinformatique.entity.StatutAffectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    List<Affectation> findByStatut(StatutAffectation statut);
    
    @Query("SELECT a FROM Affectation a WHERE a.employe.service LIKE %:service%")
    List<Affectation> findByEmployeService(@Param("service") String service);
    
    @Query("SELECT a FROM Affectation a WHERE a.employe.service LIKE %:service% AND a.statut = :statut")
    List<Affectation> findByEmployeServiceAndStatut(@Param("service") String service, @Param("statut") StatutAffectation statut);

    long countByStatut(StatutAffectation statut);
}
