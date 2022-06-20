package com.example.mysqllesson.services;

import com.example.mysqllesson.Exceptions.ResourceNotFoundException;
import com.example.mysqllesson.dto.CustomerDto;
import com.example.mysqllesson.entities.Customer;
import com.example.mysqllesson.mapper.CustomerMapper;
import com.example.mysqllesson.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer createCustomer(CustomerDto customer) {
        return customerRepository.save(customerMapper.dtoToModel(customer));
    }



    @Override
    public List<CustomerDto> getAllCustomer() {
        return this.customerMapper.modelstoDtos(customerRepository.findAll());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Optional<Customer> customerDb = this.customerRepository.findById(id);
        if(customerDb.isPresent())
        {

            return customerMapper.modeltoDto(customerDb.get());

        }else {
            throw new ResourceNotFoundException("Verilen Id Ile Ilgili Kayit Bulunamadi : " + id);
        }
    }

    @Override
    public void deleteCustomer(long id) {

    }
}
