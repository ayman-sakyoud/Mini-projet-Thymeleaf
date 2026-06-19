package com.parcinformatique.controller;

import com.parcinformatique.service.AffectationService;
import com.parcinformatique.service.EmployeService;
import com.parcinformatique.service.MaterielService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final MaterielService materielService;
    private final EmployeService employeService;
    private final AffectationService affectationService;

    public DashboardController(MaterielService materielService, EmployeService employeService, AffectationService affectationService) {
        this.materielService = materielService;
        this.employeService = employeService;
        this.affectationService = affectationService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long totalMateriels = materielService.countTotal();
        model.addAttribute("totalMateriels", totalMateriels);
        model.addAttribute("totalEmployes", employeService.countTotal());
        model.addAttribute("activeAffectations", 1); // Temporarily hardcoded for debugging
        model.addAttribute("materielsEnPanne", materielService.countEnPanne());
        model.addAttribute("tauxUtilisation", affectationService.calculateUtilizationRate(totalMateriels));
        model.addAttribute("pannesByType", materielService.countPannesByType());
        model.addAttribute("currentRoute", "dashboard");
        return "dashboard";
    }
}
