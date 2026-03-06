package com.example.demo.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String id, Customer updatedcustomer){
        Customer customer = getCustomerById(id);
        customer.setName(updatedcustomer.getName());
        customer.setAddress(updatedcustomer.getAddress());
        customer.setGender(updatedcustomer.getGender());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not Found"));
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

}
