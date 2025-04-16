package com.pos.project.point_of_sale.service.impl;

import com.pos.project.point_of_sale.dto.request.RequestOrderSaveDTO;
import com.pos.project.point_of_sale.entity.Customer;
import com.pos.project.point_of_sale.entity.Order;
import com.pos.project.point_of_sale.entity.OrderDetails;
import com.pos.project.point_of_sale.repository.CustomerRepo;
import com.pos.project.point_of_sale.repository.ItemRepository;
import com.pos.project.point_of_sale.repository.OrderDetailsRepository;
import com.pos.project.point_of_sale.repository.OrderRepo;
import com.pos.project.point_of_sale.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class OrderServiceIMPL  implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

   @Transactional
    @Override
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );

        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId())){
            List<OrderDetails> orderDetails=  modelMapper.map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){}.getType());

            for(int i=0 ; i< orderDetails.size(); i++){
                orderDetails.get(i).setOrder(order);
                orderDetails.get(i).setItems(itemRepository.getReferenceById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailsRepository.saveAll(orderDetails);
            }
            return " Order saved";
        }else{
            return null;
        }

    }
}
