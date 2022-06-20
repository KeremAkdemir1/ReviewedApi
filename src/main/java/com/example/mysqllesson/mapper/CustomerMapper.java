package com.example.mysqllesson.mapper;

import com.example.mysqllesson.dto.CustomerDto;
import com.example.mysqllesson.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface CustomerMapper {

    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    CustomerDto modeltoDto(Customer customer);
    List<CustomerDto> modelstoDtos(List<Customer> customer);
    Customer  dtoToModel(CustomerDto customerDto);
}
