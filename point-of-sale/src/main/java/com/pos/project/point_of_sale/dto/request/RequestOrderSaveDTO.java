package com.pos.project.point_of_sale.dto.request;

import com.pos.project.point_of_sale.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetails> orderDetails;

}
