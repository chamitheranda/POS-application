package com.chamithProduct.foodcity.service;

import com.chamithProduct.foodcity.dto.ItemDTO;
import com.chamithProduct.foodcity.dto.paginated.PaginatedResponseItemDTO;
import com.chamithProduct.foodcity.dto.requestDTO.ItemSaveRequestDTO;
import com.chamithProduct.foodcity.entity.Item;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemDTO getByID(int id);

    List<ItemDTO> getAll();

    String deleteByID(int id);

    PaginatedResponseItemDTO getAllItemsByPaginated(int page, int size);

    PaginatedResponseItemDTO getAllActiveItemsByPaginated(boolean activeState,int page, int size);


    long getCountByActiveSateteTrue();
}
