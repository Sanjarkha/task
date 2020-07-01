package uz.sankha.task.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sankha.task.models.Form;

import java.util.Date;

public interface TableTwoRepository extends JpaRepository<Form,Long> {

//    Iterable<Form>findByRegdateBetween
    Iterable<Form>findByRegdateBetweenAndCorrespondentNotLikeOrDeliveryformNotLike(Date date1, Date date2 , Integer correspondent,Integer delivry);
}
