package com.parcinformatique.service;

import com.parcinformatique.entity.EtatMateriel;
import com.parcinformatique.entity.Materiel;
import com.parcinformatique.repository.MaterielRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterielService {
    private final MaterielRepository materielRepository;

    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    public List<Materiel> findAll() {
        return materielRepository.findAll();
    }

    public Materiel findById(Long id) {
        return materielRepository.findById(id).orElse(null);
    }

    public void save(Materiel materiel) {
        materielRepository.save(materiel);
    }

    public void delete(Long id) {
        materielRepository.deleteById(id);
    }

    public List<Materiel> search(String type, EtatMateriel etat) {
        if (type != null && !type.isEmpty() && etat != null) {
            return materielRepository.findByTypeContainingIgnoreCaseAndEtat(type, etat);
        } else if (type != null && !type.isEmpty()) {
            return materielRepository.findByTypeContainingIgnoreCase(type);
        } else if (etat != null) {
            return materielRepository.findByEtat(etat);
        } else {
            return materielRepository.findAll();
        }
    }

    public long countTotal() {
        return materielRepository.count();
    }

    public long countEnPanne() {
        return materielRepository.countByEtat(EtatMateriel.EN_PANNE);
    }

    public Map<String, Long> countPannesByType() {
        List<Object[]> results = materielRepository.countPannesByType(EtatMateriel.EN_PANNE);
        Map<String, Long> pannesByType = new HashMap<>();
        for (Object[] result : results) {
            String type = (String) result[0];
            Long count = result[1] != null ? ((Number) result[1]).longValue() : 0L;
            pannesByType.put(type, count);
        }
        return pannesByType;
    }
}
