package uz.sankha.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.sankha.task.models.Form;
import uz.sankha.task.repositorys.FormRepository;
import uz.sankha.task.services.FormService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class FormController {
    @Autowired
    private FormService formServices;
    @Autowired
    private FormRepository formRepository;


    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @RequestMapping("/form")
    String form(Model model) {

        model.addAttribute("regdate", dateFormat.format(date));
        return "form";
    }

    @PostMapping("/requisites")
    private String requisites(Model model, HttpServletRequest request, @RequestParam("files") MultipartFile file, RedirectAttributes redirectAttributes) {
        Form fdate = new Form();
        Form form = formServices.saveform(request.getParameter("regId"), date, request.getParameter("source_doc_id"), request.getParameter("source_doc_date"), request.getParameter("delivery_form"),
                request.getParameter("correspondent"), request.getParameter("topic"), request.getParameter("description"), request.getParameter("period_of_execution"),
                request.getParameter("access"), request.getParameter("control"), file);
        fdate.setRegdate(date);
        System.out.println("rL:"+request.getParameter("topic"));
        return "print";
    }

    @RequestMapping("/print")
    public String print(Model model) {


      model.addAttribute("regId",formServices.findbyregid("1"));


        return "print";
    }

    @RequestMapping("/modal")
    public String modal( ) {

        return "table";
    }
}
