package com.pos.project.point_of_sale.service;

import com.pos.project.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.CustomerUpdateRequestDTO;

public interface CustomerService {
     String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

     String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);
}
