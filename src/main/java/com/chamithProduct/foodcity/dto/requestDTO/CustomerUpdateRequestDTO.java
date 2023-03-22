package com.chamithProduct.foodcity.dto.requestDTO;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerUpdateRequestDTO {
    private int customerId;
    private String customerName;
    private double customerSalarry;
    private ArrayList contactNumber;
    private boolean activeState;

}
