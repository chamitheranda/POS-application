package com.chamithProduct.foodcity.service;

import com.chamithProduct.foodcity.dto.CustomerDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerRequestDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerUpdateQueryDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerUpdateRequestDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerViewByActiveState;
import com.chamithProduct.foodcity.dto.responseDTO.ResponseActiveCustomerDTO;
import com.chamithProduct.foodcity.entity.Customer;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {

    String addMember(CustomerRequestDTO customerRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerDetail(int id);


    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws NotFoundException;

    List<CustomerDTO> getByName(String name) throws NotFoundException;

    List<CustomerDTO> getByActiveStates() throws NotFoundException;

    List<ResponseActiveCustomerDTO> getCustomerNameActiveState() throws NotFoundException;

    String updateNameQueryById(CustomerUpdateQueryDTO customerUpdateQueryDTO , int id);

    CustomerDTO getActiveStateByIdIfTrue(int id)  ;

    CustomerDTO getByIDActiveState(CustomerViewByActiveState customerViewByActiveState);

    List<CustomerDTO> getAllByState(boolean status);
}
