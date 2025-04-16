package com.pos.project.point_of_sale.controller;

import com.pos.project.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.project.point_of_sale.dto.request.RequestOrderSaveDTO;
import com.pos.project.point_of_sale.service.OrderService;
import com.pos.project.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save-order")
    public ResponseEntity<StandardResponse> addOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Item successfully saved", id),
                HttpStatus.CREATED
        );
    }
}
