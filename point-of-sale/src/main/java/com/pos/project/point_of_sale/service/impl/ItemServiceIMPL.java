package com.pos.project.point_of_sale.service.impl;

import com.pos.project.point_of_sale.config.ItemMapper;
import com.pos.project.point_of_sale.dto.ItemDTO;
import com.pos.project.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.project.point_of_sale.entity.Item;
import com.pos.project.point_of_sale.repository.ItemRepository;
import com.pos.project.point_of_sale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL  implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> getItems = itemRepository.findAll();
        List<ItemDTO> itemDTOs = modelMapper.map(getItems, new TypeToken<List<ItemDTO>>(){}.getType());
        return itemDTOs;
    }

    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = itemMapper.RequestDtoToEntity(itemSaveRequestDTO);
        item.setActiveState(true);
        if(itemRepository.existsByItemName(item.getItemName())){
            return item.getItemName() + "Item already exists";

        }else{
            itemRepository.save(item);
            return item.getItemName() + " saved!";
        }

    }

    @Override
    public List<ItemDTO> getAllByState(boolean status) {
        List<Item> getItems = itemRepository.findAllByActiveStateEquals(status);
        List<ItemDTO> itemDTOs = modelMapper.map(getItems, new TypeToken<List<ItemDTO>>(){}.getType());
        return itemDTOs;
    }




}
