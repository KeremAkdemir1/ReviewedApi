package com.example.mysqllesson.controller;

import com.example.mysqllesson.dto.CustomerDto;
import com.example.mysqllesson.entities.Customer;
import com.example.mysqllesson.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){

        return ResponseEntity.ok().body(customerService.getAllCustomer());

    }
    @GetMapping("/all/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable long id){

        return ResponseEntity.ok().body(customerService.getCustomerById(id));

    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customer){
        return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
    }


    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteCustomer(@PathVariable long id){

        this.customerService.deleteCustomer(id);
        return HttpStatus.OK;
    }
}
