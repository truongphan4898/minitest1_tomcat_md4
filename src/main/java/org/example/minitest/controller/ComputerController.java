package org.example.minitest.controller;

import org.example.minitest.dto.ComputerDTO;
import org.example.minitest.model.Computer;
import org.example.minitest.model.TypeComputer;
import org.example.minitest.service.IComputerService;
import org.example.minitest.service.ITypeComputerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ComputerController {
    @Autowired
    IComputerService computerService;
    @Autowired
    ITypeComputerService typeComputerService;
    @GetMapping("/")
    public String homeProduct(Model model, @RequestParam(required = false, defaultValue = "") String search,
                              @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Computer> computers = computerService.search(search, pageable);
        model.addAttribute("search", search);
        model.addAttribute("computers", computers);
        return "/home";
    }
    @GetMapping("/xoa")
    public String deleteProduct(@RequestParam("id") int id, RedirectAttributes redirectAttributes, Model model) {
        computerService.deleteComputer(id);
        redirectAttributes.addFlashAttribute("msg", 3);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String showFormAddProduct(Model model) {
        ComputerDTO computerDTO = new ComputerDTO();
        List<TypeComputer> typeComputer = typeComputerService.listTypeComputer();
        model.addAttribute("computerDTO", computerDTO);
        model.addAttribute("typeComputer", typeComputer);
        return "/add";
    }
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("computerDTO") ComputerDTO computerDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            List<TypeComputer> typeComputer = typeComputerService.listTypeComputer();
            model.addAttribute("typeComputer", typeComputer);
            return "/add";
        } else {
            Computer computer = new Computer();
            BeanUtils.copyProperties(computerDTO, computer);
            computerService.addComputer(computer);
            redirectAttributes.addFlashAttribute("msg", 1);
            return "redirect:/";
        }

    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable int id) {
        Computer computer = new Computer();
        ComputerDTO computerDTO = new ComputerDTO();
        computer = computerService.info(id);
        BeanUtils.copyProperties(computer, computerDTO);
        List<TypeComputer> typeComputers = typeComputerService.listTypeComputer();
        model.addAttribute("computerDTO", computerDTO);
        model.addAttribute("typeComputers", typeComputers);
        return "/edit";
    }
    @PostMapping("edit")
    public String editProduct(@Valid @ModelAttribute("computerDTO") ComputerDTO computerDTO,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            List<TypeComputer> typeComputers = typeComputerService.listTypeComputer();
            model.addAttribute("typeComputers", typeComputers);
            return "/edit";
        } else {
            Computer computer = new Computer();
            BeanUtils.copyProperties(computerDTO, computer);
            computerService.addComputer(computer);
            redirectAttributes.addFlashAttribute("msg", 2);
            return "redirect:/";
        }
    }
}
