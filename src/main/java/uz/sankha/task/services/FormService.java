package uz.sankha.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.sankha.task.models.Form;
import uz.sankha.task.repositorys.FormRepository;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    private final FormRepository formRepository;


    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    Date date;


    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }


    public Form saveform(String regId, Date reg_date, String source_doc_id, String source_doc_date, String delivery_form,
                         String correspondent, String topic, String descript, String period_of_execution,
                         String acess, String control, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Form form = new Form(fileName, file.getContentType(), file.getBytes());
            form.setRegId(regId);
            form.setRegdate(reg_date);
            form.setSource_doc_id(source_doc_id);
            Date date = null;
            try {
                date = format.parse(source_doc_date);
            } catch (ParseException e) {
                System.out.println("eror:" + e);
            }
            form.setSource_doc_date(date);
            form.setDeliveryform(Integer.valueOf(delivery_form));
            form.setCorrespondent(Integer.valueOf(correspondent));
            form.setTopic(topic);
            form.setDescription(descript);
            try {
                date = format.parse(period_of_execution);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            form.setPeriodofexecution(date);
            form.setAccess(Boolean.valueOf(acess));
            form.setControl(Boolean.valueOf(control));

            return formRepository.save(form);
        } catch (IOException e) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
    public boolean checkregid(String regid){
        if(formRepository.findByRegId(regid).isPresent()){
            return false;
        }
        return true;
    }
    public Optional<Form> findbyregid(String regid){
        return formRepository.findByRegId(regid);
    }
}
