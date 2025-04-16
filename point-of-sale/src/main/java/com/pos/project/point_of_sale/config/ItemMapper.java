package com.pos.project.point_of_sale.config;

import com.pos.project.point_of_sale.dto.ItemDTO;
import com.pos.project.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.project.point_of_sale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item RequestDtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemDTO>  pageToList(Page<Item> page);

}
