package com.chamithProduct.foodcity.dto.requestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestOrderSaveDetailDTO {
    private String itemName ;
    private int qty;
    private double amount ;
    private int items ;
    //private int orders ;  We should remove orders .
    // because of that still not save this record in the database .
    // so we doesn't have primary key for this record .
}
