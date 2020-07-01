package uz.sankha.task.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sankha.task.models.Form;

public interface TableTwoRepository extends JpaRepository<Form,Long> {

//    Iterable<Form>findByRegdateBetween
//    Iterable<Form>queryFormsBy
}
