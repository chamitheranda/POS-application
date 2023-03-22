package com.chamithProduct.foodcity.util.mappers;

import com.chamithProduct.foodcity.dto.CustomerDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerViewByActiveState;
import com.chamithProduct.foodcity.dto.responseDTO.ResponseActiveCustomerDTO;
import com.chamithProduct.foodcity.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entitytoDTO(Customer customer) ;
    CustomerViewByActiveState entitytoViewDTO (Customer customer);
    List<CustomerDTO> entityListToDTOList (List<Customer> customers );
    List<ResponseActiveCustomerDTO> entityListToResposeActiveCustomerDTO (List<Customer> customers);
 }
