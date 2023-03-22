package com.chamithProduct.foodcity.service.impl;

import com.chamithProduct.foodcity.dto.ItemDTO;
import com.chamithProduct.foodcity.dto.paginated.PaginatedResponseItemDTO;
import com.chamithProduct.foodcity.dto.requestDTO.ItemSaveRequestDTO;
import com.chamithProduct.foodcity.entity.Customer;
import com.chamithProduct.foodcity.entity.Item;
import com.chamithProduct.foodcity.entity.enums.MeasuringUnitPrice;
import com.chamithProduct.foodcity.exception.EntityDupplication;
import com.chamithProduct.foodcity.exception.NotFoundException;
import com.chamithProduct.foodcity.repo.ItemRepo;
import com.chamithProduct.foodcity.service.ItemService;
import com.chamithProduct.foodcity.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = itemMapper.DTOtoEntity(itemSaveRequestDTO);
        item.setActiveState(true);
        if(!itemRepo.existsById(item.getId())) {
           return itemRepo.save(item).getItemName();
        }else {
            throw new EntityDupplication("this item is already in database");
        }

    }

    @Override
    public ItemDTO getByID(int id) {
        Optional<Item> item = itemRepo.findById(id);
        if(item.isPresent()){
            ItemDTO itemDTO = itemMapper.EntityToDTO(item.get());
            return itemDTO ;
        }else{
            throw  new NotFoundException(" this item not in the database. ");
        }

    }

    @Override
    public List<ItemDTO> getAll() {
        List<Item> item = itemRepo.findAll();
        List<ItemDTO> itemDTOS = itemMapper.EntityToDTO(item);
        return itemDTOS;
    }

    @Override
    public String deleteByID(int id) {
        Item item = itemRepo.getById(id);
        itemRepo.delete(item);
        return item.getItemName() + " is successfully deleted " ;

    }

    @Override
    public long getCountByActiveSateteTrue() {
        long count = itemRepo.countAllByActiveStateTrue();
        return count;
    }


    @Override
    public PaginatedResponseItemDTO getAllItemsByPaginated(int page, int size) {
        Page<Item> item = itemRepo.findAll(PageRequest.of(page, size));

        return new PaginatedResponseItemDTO(
                itemMapper.PageItemsToItemDTO(item),// Page type convert to Item list
                itemRepo.count()
        );
    }

    @Override
    public PaginatedResponseItemDTO getAllActiveItemsByPaginated(boolean activeState ,int page, int size) {
        Page<Item> item = itemRepo.findAllByActiveStateEquals(activeState,PageRequest.of(page , size));
        return new PaginatedResponseItemDTO(
                itemMapper.PageItemsToItemDTO(item),
                itemRepo.countAllByActiveStateEquals(activeState)
        );
    }




}
