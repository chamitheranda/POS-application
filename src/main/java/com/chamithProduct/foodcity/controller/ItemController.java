package com.chamithProduct.foodcity.controller;

import com.chamithProduct.foodcity.dto.ItemDTO;
import com.chamithProduct.foodcity.dto.paginated.PaginatedResponseItemDTO;
import com.chamithProduct.foodcity.dto.requestDTO.ItemSaveRequestDTO;
import com.chamithProduct.foodcity.entity.Item;
import com.chamithProduct.foodcity.service.ItemService;
import com.chamithProduct.foodcity.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/item")

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO ){
        String text = itemService.addItem(itemSaveRequestDTO) ;
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        text + " item was successfully saved ",
                        text), HttpStatus.CREATED
        );
    }
    @GetMapping(path = "/get-by-id/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable(value = "id") int id ){
        ItemDTO itemDTO = itemService.getByID(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        " This is the entity you want ",
                        itemDTO ),HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-activeState-true")
    public ResponseEntity<StandardResponse > getAllItemByState(){
        List<ItemDTO> item = itemService.getAll();
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        " This is all items. " ,
                        item),HttpStatus.OK
        );
    }
    @DeleteMapping(path = "/delete-by-id/{id}")
    public ResponseEntity<StandardResponse > deleteById(@PathVariable(value = "id") int id ){
        String text  = itemService.deleteByID(id);
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        " Below item is deleted  " ,
                        text),HttpStatus.OK
        );
    }
    @GetMapping(path = "count-active-state")
    public ResponseEntity<StandardResponse> getCountByActiveState(){
        long count1 = itemService.getCountByActiveSateteTrue();
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        " All Item Count is represent below " ,
                        count1),HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-by-paginate",
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> getAlByPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(25) int size
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsByPaginated(page,size);
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        " Suitable Items for your searching " ,
                        paginatedResponseItemDTO),HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-active-by-paginate",
            params = {"page", "size" ,"activeState"}
    )
    public ResponseEntity<StandardResponse> getAllItemsActivestateByPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(25) int size,
            @RequestParam(value = "activeState")  boolean activeState
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllActiveItemsByPaginated(activeState,page,size);
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        " Suitable Items for your searching " ,
                        paginatedResponseItemDTO),HttpStatus.OK
        );
    }
}



