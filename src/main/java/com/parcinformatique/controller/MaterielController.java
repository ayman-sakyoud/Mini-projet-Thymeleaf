package com.parcinformatique.controller;

import com.parcinformatique.entity.EtatMateriel;
import com.parcinformatique.entity.Materiel;
import com.parcinformatique.service.MaterielService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materiels")
public class MaterielController {
    private final MaterielService materielService;

    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String type,
                       @RequestParam(required = false) EtatMateriel etat,
                       Model model) {
        model.addAttribute("materiels", materielService.search(type, etat));
        model.addAttribute("etats", EtatMateriel.values());
        model.addAttribute("selectedType", type);
        model.addAttribute("selectedEtat", etat);
        model.addAttribute("currentRoute", "materiels");
        return "materiels/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("materiel", new Materiel());
        model.addAttribute("etats", EtatMateriel.values());
        model.addAttribute("currentRoute", "materiels");
        return "materiels/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Materiel materiel) {
        materielService.save(materiel);
        return "redirect:/materiels";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("materiel", materielService.findById(id));
        model.addAttribute("etats", EtatMateriel.values());
        model.addAttribute("currentRoute", "materiels");
        return "materiels/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Materiel materiel) {
        materielService.save(materiel);
        return "redirect:/materiels";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        materielService.delete(id);
        return "redirect:/materiels";
    }
}
