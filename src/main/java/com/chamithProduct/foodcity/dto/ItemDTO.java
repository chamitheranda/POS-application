package com.chamithProduct.foodcity.dto;

import com.chamithProduct.foodcity.entity.enums.MeasuringUnitPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int id ;
    private String itemName ;
    private MeasuringUnitPrice measuringUnit ;
    private double balanceQty;
    private double supplierPrice ;
    private double sellingPrice ;
    private boolean activeState;

}
