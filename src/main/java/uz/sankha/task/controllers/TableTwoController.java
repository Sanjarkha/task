package uz.sankha.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.sankha.task.models.Form;
import uz.sankha.task.repositorys.TableRepository;
import uz.sankha.task.repositorys.TableTwoRepository;

import javax.management.Query;
import java.util.Calendar;
import java.util.Date;

@Controller
public class TableTwoController {
    @Autowired
    private final TableTwoRepository tableTwoRepository;

    public TableTwoController(TableTwoRepository tableTwoRepository) {
        this.tableTwoRepository = tableTwoRepository;
    }

    @GetMapping("/tabletwo")
    public String tabletwo(Model model){
        Date datein=new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        Date dateto = cal.getTime();

        System.out.println("today:"+dateto+"- end:"+datein);
        Iterable<Form> forms = tableTwoRepository.findByRegdateBetweenAndCorrespondentNotLikeOrDeliveryformNotLike(dateto,dateto,2,1);
        model.addAttribute("forms", forms);
        return "tabletwo";

    }
}
