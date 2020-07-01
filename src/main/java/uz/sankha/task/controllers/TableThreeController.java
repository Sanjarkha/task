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
public class TableThreeController {
    @Autowired
    private TableRepository tableRepository;

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    @GetMapping("/tablethree")
    public String tableone(Model model) {

        Date datein=new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date dateto = cal.getTime();
        datein=cal.getTime();
        System.out.println("today:"+dateto+"- end:"+datein);

        Iterable<Form> forms = tableRepository.findByRegdateBetweenAndCorrespondent(dateto,datein,3);
        model.addAttribute("forms", forms);
        return "tablethree";
    }
}
