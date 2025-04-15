package com.pos.project.point_of_sale.controller;

import com.pos.project.point_of_sale.dto.CustomerDTO;
import com.pos.project.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.project.point_of_sale.dto.response.ResponseActiveStateCustomerDTO;
import com.pos.project.point_of_sale.service.CustomerService;
import com.pos.project.point_of_sale.service.impl.CustomerServiceIMPL;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(path = "/save-customer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        String id = customerService.addCustomer(customerSaveRequestDTO);

        return id;
    }

    @PutMapping(path = "/update-customer")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
        String updated = customerService.updateCustomer(customerUpdateRequestDTO);
        return updated;
    }

    @GetMapping(
            path = {"/get-customer"},
            params = {"id"})
    public CustomerDTO getCustomer(@RequestParam(value = "id") int id){
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return  customerDTO;
    }

    @GetMapping(path = {"/get-all-customers"})
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping(path = {"/delete-customer"},
            params = {"id"})
    public String deleteCustomer(@RequestParam(value = "id") int id) throws ChangeSetPersister.NotFoundException {
        String deleted = customerService.deleteCustomerById(id);
        return deleted;
    }

    @GetMapping(path = {"/get-by-name"}, params = {"name"})
    public List<CustomerDTO> getCustomerBYName(@RequestParam (value = "name") String customerName) throws ChangeSetPersister.NotFoundException {
        List<CustomerDTO> getCustomer = customerService.getByName(customerName);
        return getCustomer;
    }

    @GetMapping(path = { "/get-by-active-state"})
    public List<CustomerDTO> getCustomersByActiveState() throws ChangeSetPersister.NotFoundException {
        List<CustomerDTO> getCustomer = customerService.getAllCustomersByActiveState();
        return getCustomer;
    }

    @GetMapping(path = { "/get-name-by-active-state"})
    public List<ResponseActiveStateCustomerDTO> getNamesOfCustomersByActiveState() throws ChangeSetPersister.NotFoundException {
        List<ResponseActiveStateCustomerDTO> getCustomer = customerService.getAllCustomerNamesByActiveState();
        return getCustomer;
    }

}
