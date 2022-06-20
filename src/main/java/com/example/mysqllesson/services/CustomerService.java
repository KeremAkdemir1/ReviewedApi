package com.example.mysqllesson.services;

import com.example.mysqllesson.dto.CustomerDto;
import com.example.mysqllesson.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDto customer);
    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerById(long id);
    void deleteCustomer(long id);

}
