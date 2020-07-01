package uz.sankha.task.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sankha.task.models.Form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//SELECT * FROM test WHERE indate BETWEEN '2020-05-29 03:38:11' and '2020-06-29 03:39:07'
public interface TableRepository extends JpaRepository<Form,Long> {
    Iterable<Form> findByRegdateBetweenAndCorrespondentAndDeliveryform(Date date1, Date date2 ,Integer correspondent,Integer delivry);


}
