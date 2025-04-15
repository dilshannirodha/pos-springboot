package com.pos.project.point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseActiveStateCustomerDTO {
    private String customerName;
    private int contactNumbers;
    private String nic;
}
