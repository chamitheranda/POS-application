package com.chamithProduct.foodcity.util.mappers;

import com.chamithProduct.foodcity.dto.CustomerDTO;
import com.chamithProduct.foodcity.dto.ItemDTO;
import com.chamithProduct.foodcity.dto.paginated.PaginatedResponseItemDTO;
import com.chamithProduct.foodcity.dto.requestDTO.ItemSaveRequestDTO;
import com.chamithProduct.foodcity.entity.Customer;
import com.chamithProduct.foodcity.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ItemMapper {
      Item DTOtoEntity(ItemSaveRequestDTO itemSaveRequestDTO) ;
      ItemDTO EntityToDTO (Item item);
      List<ItemDTO> EntityToDTO (List<Item> item);
      List<ItemDTO> PageItemsToItemDTO (Page<Item> item);

}
