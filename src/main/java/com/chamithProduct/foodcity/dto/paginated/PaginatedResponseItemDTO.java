package com.chamithProduct.foodcity.dto.paginated;

import com.chamithProduct.foodcity.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private List<ItemDTO> items;
    private long totalItemCount ;
}
