package com.dave.order.Controller;

import com.dave.order.Entity.Order;
import com.dave.order.Service.OrderService;
import com.dave.order.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){ return orderService.getOrderById(id);}
    
    @PostMapping public Map<String, Object> createOrder(@RequestBody Order order){ return orderService.createOrder(order);}
    @PostMapping("/customers") public Customer createCustomer(@RequestBody Customer customer){ return orderService.createCustomer(customer);}
    @PutMapping("/customers/{id}") public String updateCustomer(@PathVariable Long id, @RequestBody Customer customer){ orderService.updateCustomer(id, customer); return "Customer Updated Successfully";}
    @DeleteMapping("/customers/{id}") public String deleteCustomer(@PathVariable Long id){ orderService.deleteCustomer(id); return "Customer Deleted";}

}

