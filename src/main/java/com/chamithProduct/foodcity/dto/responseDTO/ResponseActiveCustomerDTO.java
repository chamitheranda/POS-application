package com.chamithProduct.foodcity.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseActiveCustomerDTO {
    private int customerId;
    private String customerName;
}
