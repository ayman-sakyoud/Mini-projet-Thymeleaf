package com.parcinformatique.repository;

import com.parcinformatique.entity.EtatMateriel;
import com.parcinformatique.entity.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {
    List<Materiel> findByTypeContainingIgnoreCase(String type);
    List<Materiel> findByEtat(EtatMateriel etat);
    List<Materiel> findByTypeContainingIgnoreCaseAndEtat(String type, EtatMateriel etat);

    long countByEtat(EtatMateriel etat);

    @Query("SELECT m.type as type, SUM(CASE WHEN m.etat = :etat THEN 1 ELSE 0 END) as count FROM Materiel m GROUP BY m.type")
    List<Object[]> countPannesByType(@Param("etat") EtatMateriel etat);
}
