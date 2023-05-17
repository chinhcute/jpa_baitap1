package repository;

import entity.Customer_entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface Customer_repository extends CrudRepository<Customer_entity,Integer> {

}
