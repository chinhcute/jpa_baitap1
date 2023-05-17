package repository;

import entity.Customer_entity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Customer_repository extends CrudRepository<Customer_entity,Integer> {
    List<Customer_entity> findByName (String name);
    List<Customer_entity> findByPhoneOrEmail(int phone, String Email);
      List<Customer_entity> findByBirthdateBetween(LocalDate start, LocalDate end);
}
