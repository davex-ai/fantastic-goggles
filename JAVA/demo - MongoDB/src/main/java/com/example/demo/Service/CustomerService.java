package com.example.demo.Service;

import com.example.demo.Entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer updateCustomer(String id, Customer customer);
    Customer getCustomerById(String id);
    void deleteCustomer(String id);
}
