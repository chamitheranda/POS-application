package com.chamithProduct.foodcity.dto.requestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private double total ;
    private Date date ;
    private int customer;
    private List<RequestOrderSaveDetailDTO> requestOrderSaveDetailDTOS;
}
