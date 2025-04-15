package com.pos.project.point_of_sale.service;

import com.pos.project.point_of_sale.dto.CustomerDTO;
import com.pos.project.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {
     String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

     String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

     CustomerDTO getCustomerById(int id);

     List<CustomerDTO> getAllCustomers();

     String deleteCustomerById(int id) throws ChangeSetPersister.NotFoundException;

     List<CustomerDTO> getByName(String customerName) throws ChangeSetPersister.NotFoundException;

     List<CustomerDTO> getAllCustomersByActiveState() throws ChangeSetPersister.NotFoundException;

     List<CustomerDTO> getAllCustomerNamesByActiveState();
}
