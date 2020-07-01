package uz.sankha.task.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.sankha.task.services.FormService;

@RestController
@RequestMapping("/api")
public class RegidController {
    @Autowired
    private final FormService formService;

    public RegidController(FormService formService) {
        this.formService = formService;
    }/*
    @RequestMapping(value = "/{regid}",method = RequestMethod.GET)
    public boolean getregid(@PathVariable String regid){
    System.out.println(regid);
    return formService.checkregid(regid);
}

*/
    @RequestMapping(value = "/{regid}",method = RequestMethod.GET)
    public boolean getregid(@PathVariable String regid){
        System.out.println(regid);
        return formService.checkregid(regid);
    }
}
