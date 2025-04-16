package com.pos.project.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetails {
    private String itemName;
    private double qty;
    private Double amount;
    private int order;
    private int items;


}
