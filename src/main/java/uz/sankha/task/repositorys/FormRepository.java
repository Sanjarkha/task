package uz.sankha.task.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.sankha.task.models.Form;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<Form,Long> {

    Optional<Form> findByRegId(String regid);
    /*
    List<Form> findByRegId(String regid);*/
}
