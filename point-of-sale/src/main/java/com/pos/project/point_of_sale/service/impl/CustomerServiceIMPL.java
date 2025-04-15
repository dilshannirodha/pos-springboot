package com.pos.project.point_of_sale.service.impl;

import com.pos.project.point_of_sale.config.CustomerMapper;
import com.pos.project.point_of_sale.dto.CustomerDTO;
import com.pos.project.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.project.point_of_sale.entity.Customer;
import com.pos.project.point_of_sale.respository.CustomerRepo;
import com.pos.project.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerMapper customerMapper;


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
        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
            customer.setContactNumbers(customerUpdateRequestDTO.getContactNumbers());
            customer.setActiveState(customer.isActiveState());

            customerRepo.save(customer);

        } else {
            System.out.println("this customer not in database");
        }
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getContactNumbers(),
                    customer.get().getNic(),
                    customer.get().isActiveState()
            );
            return customerDTO;

        } else {
            return null;
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer c : getCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    c.getCustomerId(),
                    c.getCustomerName(),
                    c.getCustomerAddress(),
                    c.getCustomerSalary(),
                    c.getContactNumbers(),
                    c.getNic(),
                    c.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }

        //List<CustomerDTO> customerDTOs = modelMapper.map(getCustomers, new TypeToken<List<CustomerDTO>>(){}.getType());
        //return customerDTOs

        return customerDTOList;
    }

    @Override
    public String deleteCustomerById(int id) throws ChangeSetPersister.NotFoundException {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            String customerName = customer.get().getCustomerName();
            customerRepo.deleteById(id);
            return customerName + "deleted";
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }

    }

    @Override
    public List<CustomerDTO> getByName(String customerName) throws ChangeSetPersister.NotFoundException {
        List<Customer> customers = customerRepo.findAllByCustomerNameEquals(customerName);
       if(customers.size() !=0 ){
           List<CustomerDTO> customerDTOs = new ArrayList<>();
           for (Customer c : customers) {
               CustomerDTO customerDTO = new CustomerDTO(
                       c.getCustomerId(),
                       c.getCustomerName(),
                       c.getCustomerAddress(),
                       c.getCustomerSalary(),
                       c.getContactNumbers(),
                       c.getNic(),
                       c.isActiveState()
               );
               customerDTOs.add(customerDTO);
           }
           return customerDTOs;
       }else {
           throw  new ChangeSetPersister.NotFoundException();
       }


    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState() throws ChangeSetPersister.NotFoundException {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
        if(customers.size() !=0){

            List<CustomerDTO> customerDTOs = customerMapper.entityListToDtoList(customers);
            return customerDTOs;
        }
        else{
            throw new ChangeSetPersister.NotFoundException();
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomerNamesByActiveState() {
        return null;
    }


}
