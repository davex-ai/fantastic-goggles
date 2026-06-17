package com.example.demo.Controller;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
       return customerService.createCustomer(customer);
        }

        @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
        }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
    }
