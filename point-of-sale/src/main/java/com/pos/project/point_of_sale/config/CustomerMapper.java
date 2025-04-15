package com.pos.project.point_of_sale.config;

import com.pos.project.point_of_sale.dto.CustomerDTO;
import com.pos.project.point_of_sale.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDto(Customer customer);
    List<CustomerDTO> entityListToDtoList(List<Customer> customer);


}
