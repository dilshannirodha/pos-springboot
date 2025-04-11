package com.pos.project.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateRequestDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private int contactNumbers;
    private String nic;

    private boolean activeState;


}
