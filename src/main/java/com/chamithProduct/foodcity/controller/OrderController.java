package com.chamithProduct.foodcity.controller;

import com.chamithProduct.foodcity.dto.requestDTO.RequestOrderSaveDTO;
import com.chamithProduct.foodcity.service.impl.OrdersServiceIMPL;
import com.chamithProduct.foodcity.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/save_order")
public class OrderController {

    @Autowired
    private OrdersServiceIMPL ordersServiceIMPL ;
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String txt = ordersServiceIMPL.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "",
                        txt
                ), HttpStatus.OK
        );
    }
}
