package com.pos.project.point_of_sale.service;

import com.pos.project.point_of_sale.dto.request.RequestOrderSaveDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
