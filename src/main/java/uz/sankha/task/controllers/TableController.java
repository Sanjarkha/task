package uz.sankha.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.sankha.task.models.Form;
import uz.sankha.task.repositorys.FormRepository;

@Controller
public class TableController {
    @Autowired
    private FormRepository formRepository;

    @GetMapping("/table")
    public String findAll(Model model) {
        Iterable<Form> forms = formRepository.findAll();
        model.addAttribute("forms", forms);
        return "table";
    }
}
