package com.ngviet291.nguyentranquocviet_23660721_bai04.servlet;

import com.ngviet291.nguyentranquocviet_23660721_bai04.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class CustomerList {
    private  List<Customer> customers= new ArrayList<>(List.of(
            new Customer("1","Viet","viet@gmail.com","TPHCM"),
            new Customer("2","Nam","nam@gmail.com","Hà Nội")
    ));
    public List<Customer> list(){
        return  customers;
    }
    public boolean addCustomer(Customer customer){
        return customers.add(customer);
    }
}
