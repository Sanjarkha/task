package uz.sankha.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.sankha.task.models.Form;
import uz.sankha.task.repositorys.TableRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

@Controller
public class TableOneController {
    @Autowired
    private TableRepository tableRepository;

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");



@GetMapping("/tableone")
public String tableone(Model model) {

    Date datein=new Date();
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, -1);
    Date dateto = cal.getTime();

    Iterable<Form> forms = tableRepository.findByRegdateBetweenAndCorrespondentAndDeliveryform(dateto,datein,1,2);
    model.addAttribute("forms", forms);
    return "tableone";
}
}