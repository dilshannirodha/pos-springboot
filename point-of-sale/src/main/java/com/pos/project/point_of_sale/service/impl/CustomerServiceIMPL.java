package com.pos.project.point_of_sale.service.impl;

import com.pos.project.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.project.point_of_sale.entity.Customer;
import com.pos.project.point_of_sale.respository.CustomerRepo;
import com.pos.project.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {
        Customer customer = new Customer(

                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomerSalary(),
                customerSaveRequestDTO.getContactNumbers(),
                customerSaveRequestDTO.getNic()

        );

        customer.setActiveState(true);
        if (customerRepo.existsByNic(customer.getNic())) {
            return "NIC already exists!";
        }

        customerRepo.save(customer);
        return customer.getCustomerName() + " saved";


    }
    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if(customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
            customer.setContactNumbers(customerUpdateRequestDTO.getContactNumbers());
            customer.setActiveState(customer.isActiveState());

            customerRepo.save(customer);

        }else{
            System.out.println("this customer not in database");
        }
        return null;
    }
}
