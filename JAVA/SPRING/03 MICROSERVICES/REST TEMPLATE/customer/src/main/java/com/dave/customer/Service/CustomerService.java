package com.dave.customer.Service;

import com.dave.customer.Entity.Customer;
import com.dave.customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(Long id){return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Fouund"));}
    public Customer createCustomer(Customer customer){return customerRepository.save(customer);}
    public void deleteCustomer(Long id){ customerRepository.deleteById(id);}
    public Customer updateCustomer(Long id, Customer updatedCustomer){
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());

        return customerRepository.save(existing);
    }
}


