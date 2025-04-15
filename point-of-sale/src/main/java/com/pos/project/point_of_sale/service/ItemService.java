package com.pos.project.point_of_sale.service;

import com.pos.project.point_of_sale.dto.CustomerDTO;
import com.pos.project.point_of_sale.dto.ItemDTO;
import com.pos.project.point_of_sale.dto.request.ItemSaveRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {


    List<ItemDTO> getAllItems();

    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);


    List<ItemDTO> getAllByState(boolean status);
}
