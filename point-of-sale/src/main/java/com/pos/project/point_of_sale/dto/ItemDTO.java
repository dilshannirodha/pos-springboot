package com.pos.project.point_of_sale.dto;

import com.pos.project.point_of_sale.entity.enums.MeasuringUnit;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

    private int itemId;
    private String itemName;
    private MeasuringUnit measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;


}
