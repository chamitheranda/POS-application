package com.chamithProduct.foodcity.service.impl;

import com.chamithProduct.foodcity.dto.CustomerDTO;
import com.chamithProduct.foodcity.dto.requestDTO.RequestOrderSaveDTO;
import com.chamithProduct.foodcity.entity.OrderDetail;
import com.chamithProduct.foodcity.entity.Orders;
import com.chamithProduct.foodcity.repo.CustomerRepo;
import com.chamithProduct.foodcity.repo.ItemRepo;
import com.chamithProduct.foodcity.repo.OrderDetailRepo;
import com.chamithProduct.foodcity.repo.OrdersRepo;
import com.chamithProduct.foodcity.service.OrdersService;
import com.chamithProduct.foodcity.util.StandardResponse;
import com.chamithProduct.foodcity.util.mappers.OrdersMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class OrdersServiceIMPL implements OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrdersMapper ordersMapper ;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDetailRepo orderDetailRepo ;

    @Autowired
    private ItemRepo itemRepo;

    @Transactional
    @Override
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
       Orders orders = new Orders(
               requestOrderSaveDTO.getTotal(),
               requestOrderSaveDTO.getDate(),
               customerRepo.getById(requestOrderSaveDTO.getCustomer())
       );
       ordersRepo.save(orders);
       if(ordersRepo.existsById(orders.getOrdersId())){
           List<OrderDetail> orderDetails = modelMapper.map(requestOrderSaveDTO.getRequestOrderSaveDetailDTOS(),
                   new TypeToken<List<CustomerDTO>>() {
           }.getType());
           for (int i=0 ; i < orderDetails.size() ; i++){
               orderDetails.get(i).getOrderDetailId(); // Get the order id
               orderDetails.get(i).setItems            // Set the Item id
                       (
                       itemRepo.getById(requestOrderSaveDTO.getRequestOrderSaveDetailDTOS().get(i).getItems())
                       );
           }
           if(orderDetails.size()>0){
               orderDetailRepo.saveAll(orderDetails);
               return "Saved !!" ;
           }
       }
        return null;
    }
}
