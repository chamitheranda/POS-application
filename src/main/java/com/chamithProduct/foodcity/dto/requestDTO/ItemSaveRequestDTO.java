package com.chamithProduct.foodcity.dto.requestDTO;

import com.chamithProduct.foodcity.entity.enums.MeasuringUnitPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemSaveRequestDTO {
    private String itemName ;
    private String measuringUnit ;
    private double balanceQty;
    private double supplierPrice ;
    private double sellingPrice ;
}
