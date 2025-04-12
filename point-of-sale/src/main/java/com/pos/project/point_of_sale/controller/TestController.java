package com.pos.project.point_of_sale.controller;

import com.pos.project.point_of_sale.dto.CustomerDTO;
import com.pos.project.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.project.point_of_sale.service.CustomerService;
import com.pos.project.point_of_sale.service.impl.CustomerServiceIMPL;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {
    private final CustomerService customerService;

    public TestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
        String id = customerService.addCustomer(customerSaveRequestDTO);

        return id;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
       String updated = customerService.updateCustomer(customerUpdateRequestDTO);
        return updated;
    }

    @GetMapping(
            path = {"/get-all-customer"},
            params = {"id"})
    public CustomerDTO getAllCustomers(@RequestParam(value = "id") String id){
    CustomerDTO customerDTO = customerService.getCustomerById(id);
    return  customerDTO;
    }

}
