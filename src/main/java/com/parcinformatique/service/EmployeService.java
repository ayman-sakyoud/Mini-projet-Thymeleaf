package com.parcinformatique.service;

import com.parcinformatique.entity.Employe;
import com.parcinformatique.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    public Employe findById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    public void save(Employe employe) {
        employeRepository.save(employe);
    }

    public void delete(Long id) {
        employeRepository.deleteById(id);
    }

    public long countTotal() {
        return employeRepository.count();
    }
}
