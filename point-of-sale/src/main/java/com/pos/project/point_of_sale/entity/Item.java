package com.pos.project.point_of_sale.entity;

import com.pos.project.point_of_sale.entity.enums.MeasuringUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name= "measuring_unit", length = 100, nullable = false)
    private MeasuringUnit measuringUnit;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name= "supplier_price", length = 100, nullable = false)
    private double supplierPrice;

    @Column(name= "selling_price", length = 100, nullable = false)
    private double sellingPrice;


    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;


}
