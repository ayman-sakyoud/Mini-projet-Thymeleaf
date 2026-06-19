package com.parcinformatique.controller;

import com.parcinformatique.entity.Employe;
import com.parcinformatique.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employes")
public class EmployeController {
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employes", employeService.findAll());
        model.addAttribute("currentRoute", "employes");
        return "employes/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employe", new Employe());
        model.addAttribute("currentRoute", "employes");
        return "employes/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Employe employe) {
        employeService.save(employe);
        return "redirect:/employes";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employe", employeService.findById(id));
        model.addAttribute("currentRoute", "employes");
        return "employes/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Employe employe) {
        employeService.save(employe);
        return "redirect:/employes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeService.delete(id);
        return "redirect:/employes";
    }
}
