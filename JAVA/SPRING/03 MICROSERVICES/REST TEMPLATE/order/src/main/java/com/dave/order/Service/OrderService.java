package com.dave.order.Service;

import com.dave.order.Entity.Order;
import com.dave.order.Repository.OrderRepository;
import com.dave.order.dto.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;
    private RestTemplate restTemplate;
    private  final String CUSTOMER_URL = "http://localhost:8080/customers";

    public Customer createCustomer(Customer customer){ return restTemplate.postForObject(CUSTOMER_URL, customer, Customer.class);}
    public void updateCustomer(Long id, Customer customer){ restTemplate.put(CUSTOMER_URL + "/" + id, customer);}
    public void deleteCustomer(Long id){ restTemplate.delete(CUSTOMER_URL + "/" + id);}

    public Order getOrderById(Long id){return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Fouund"));}

    public Map<String, Object> createOrder(Order order){
        String url = "http://localhost:8080/customers/" + order.getCustomerId();
        Order savedOrder = orderRepository.save(order);
        Customer customer = restTemplate.getForObject(url, Customer.class);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        Map<String, Object> response = new HashMap<>();
        response.put("order", savedOrder);
        response.put("customer", customer);


        return response;
    }
}
