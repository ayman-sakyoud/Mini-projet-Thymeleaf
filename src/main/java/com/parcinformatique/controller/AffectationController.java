package com.parcinformatique.controller;

import com.parcinformatique.entity.Affectation;
import com.parcinformatique.entity.Employe;
import com.parcinformatique.entity.Materiel;
import com.parcinformatique.entity.StatutAffectation;
import com.parcinformatique.service.AffectationService;
import com.parcinformatique.service.EmployeService;
import com.parcinformatique.service.MaterielService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/affectations")
public class AffectationController {
    private final AffectationService affectationService;
    private final MaterielService materielService;
    private final EmployeService employeService;

    public AffectationController(AffectationService affectationService, MaterielService materielService, EmployeService employeService) {
        this.affectationService = affectationService;
        this.materielService = materielService;
        this.employeService = employeService;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String service,
                       @RequestParam(required = false) StatutAffectation statut,
                       Model model) {
        model.addAttribute("affectations", affectationService.search(service, statut));
        model.addAttribute("statuts", StatutAffectation.values());
        model.addAttribute("selectedService", service);
        model.addAttribute("selectedStatut", statut);
        model.addAttribute("currentRoute", "affectations");
        return "affectations/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Affectation affectation = new Affectation();
        affectation.setEmploye(new Employe());
        affectation.setMateriel(new Materiel());
        model.addAttribute("affectation", affectation);
        model.addAttribute("materiels", materielService.findAll());
        model.addAttribute("employes", employeService.findAll());
        model.addAttribute("statuts", StatutAffectation.values());
        model.addAttribute("currentRoute", "affectations");
        return "affectations/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Affectation affectation) {
        affectationService.save(affectation);
        return "redirect:/affectations";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("affectation", affectationService.findById(id));
        model.addAttribute("materiels", materielService.findAll());
        model.addAttribute("employes", employeService.findAll());
        model.addAttribute("statuts", StatutAffectation.values());
        model.addAttribute("currentRoute", "affectations");
        return "affectations/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Affectation affectation) {
        affectationService.save(affectation);
        return "redirect:/affectations";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        affectationService.delete(id);
        return "redirect:/affectations";
    }
}
