package com.customer.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import com.customer.api.models.Customer;
import com.customer.api.repository.CustomerRepository;

@Slf4j
@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        final String id = UUID.randomUUID().toString();
        customer.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.save(customer));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> createCustomer(@PathVariable String customerId){
        final Customer customer = customerRepository.findCustomerById(customerId);
        if(Objects.nonNull(customer)){
            return ResponseEntity.ok(customer);
        } else {
            log.error("Customer not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
        final Customer dbCustomer = customerRepository.findCustomerById(customerId);
        
        if(Objects.nonNull(dbCustomer)){
            customerRepository.delete(dbCustomer);
            return ResponseEntity.ok("Successfully deleted a customer");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("A customer with id %s was not found.", customerId));
        }      
    }

    @GetMapping("/customer")
    public ResponseEntity<Page<Customer>> createCustomer(@RequestParam String query, @RequestParam int page, @RequestParam int limit){
        final PageRequest pageRequest = PageRequest.of(page, limit);
        return ResponseEntity.ok(customerRepository.findCustomerByQuery(query, pageRequest));
    }
}

