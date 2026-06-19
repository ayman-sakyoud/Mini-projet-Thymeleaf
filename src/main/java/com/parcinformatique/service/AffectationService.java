package com.parcinformatique.service;

import com.parcinformatique.entity.Affectation;
import com.parcinformatique.entity.StatutAffectation;
import com.parcinformatique.repository.AffectationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationService {
    private final AffectationRepository affectationRepository;

    public AffectationService(AffectationRepository affectationRepository) {
        this.affectationRepository = affectationRepository;
    }

    public List<Affectation> findAll() {
        return affectationRepository.findAll();
    }

    public Affectation findById(Long id) {
        return affectationRepository.findById(id).orElse(null);
    }

    public void save(Affectation affectation) {
        affectationRepository.save(affectation);
    }

    public void delete(Long id) {
        affectationRepository.deleteById(id);
    }

    public List<Affectation> search(String service, StatutAffectation statut) {
        if (service != null && !service.isEmpty() && statut != null) {
            return affectationRepository.findByEmployeServiceAndStatut(service, statut);
        } else if (service != null && !service.isEmpty()) {
            return affectationRepository.findByEmployeService(service);
        } else if (statut != null) {
            return affectationRepository.findByStatut(statut);
        } else {
            return affectationRepository.findAll();
        }
    }

    public long countActive() {
        return affectationRepository.countByStatut(StatutAffectation.ACTIVE);
    }

    public double calculateUtilizationRate(long totalMateriel) {
        if (totalMateriel == 0) return 0;
        long affectedMateriel = affectationRepository.countByStatut(StatutAffectation.ACTIVE);
        return (double) affectedMateriel / totalMateriel * 100;
    }
}
