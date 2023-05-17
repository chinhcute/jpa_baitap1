package org.example;



import config.Config;
import entity.Customer_entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.Customer_repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static Customer_repository customerRepository =  (Customer_repository) context.getBean("customer_repository");


    public static void main(String[] args) {
//      save();
//        listAll();
//        tim_theo_id(1);
//        tim_theo_name("nam");
//        phoneOrEmail(123, "chinh");
//        startDataBetween();
        tim_theo_tuoi(20,17);

    }
    public static void save(){
        Customer_entity customerEntity = new Customer_entity();
        customerEntity.setName("chinh");
        customerEntity.setBirthdate(LocalDate.parse("2009-04-04"));
        customerEntity.setSex("nam");
        customerEntity.setEmail("chinhdepzai@gmail.com");
        customerEntity.setPhone(123);
        customerEntity.setAddress("đẹp zai");
        Customer_entity customer_entity = customerRepository.save(customerEntity);


    }
    public static void listAll(){
//        List<Customer_entity> customerEntities = new ArrayList<>();
//        customerEntities = (List<Customer_entity>) customerRepository.findAll();
        List<Customer_entity> customerEntities = (List<Customer_entity>) customerRepository.findAll();
       for (Customer_entity customerEntity : customerEntities){
           System.out.println(customerEntities.toString());
       }

    }
    public static void tim_theo_id(int id){
        Customer_entity customerEntity = customerRepository.findById(id).get();
        System.out.println(customerEntity.toString());
    }
    public static void tim_theo_name(String name){
        List<Customer_entity> customerEntities = customerRepository.findByName(name);
        for (Customer_entity customerEntity : customerEntities){
            System.out.println(customerEntities.toString());
        }
    }
    public static void phoneOrEmail(int phone, String email){
        List<Customer_entity> customerEntities = customerRepository.findByPhoneOrEmail(phone,email);
        for (Customer_entity customerEntity: customerEntities
             ) {
            System.out.println(customerEntities.toString());

        }
    }
    public static void startDataBetween(){
        LocalDate startDate = LocalDate.parse(("2004-01-01"));
        LocalDate endDate = LocalDate.parse("2010-01-01");
        List<Customer_entity> customerEntities = customerRepository.findByBirthdateBetween(startDate, endDate);
        for (Customer_entity customerEntity : customerEntities){
            System.out.println(customerEntities.toString());
        }
    }
    public static void tim_theo_tuoi(int start, int end){
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusYears(start);
        LocalDate endDate = now.minusYears(end);
        List<Customer_entity> customerEntities = customerRepository.findByBirthdateBetween(startDate, endDate);
        for (Customer_entity customerEntity : customerEntities){
            System.out.println(customerEntities.toString());
        }
    }
}