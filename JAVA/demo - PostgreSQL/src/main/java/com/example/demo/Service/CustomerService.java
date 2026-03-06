package com.example.demo.Service;

import com.example.demo.Entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer updateCustomer(Integer id, Customer customer);
    Customer getCustomerById(Integer id);
    void deleteCustomer(Integer id);
}
