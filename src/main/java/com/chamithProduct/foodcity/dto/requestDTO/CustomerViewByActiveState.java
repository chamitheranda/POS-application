package com.chamithProduct.foodcity.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerViewByActiveState {
    private int customerId;
    private String state ;

}
