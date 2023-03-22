package com.chamithProduct.foodcity.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateQueryDTO {
    private String customerName;
    private ArrayList contactNumber;
}
