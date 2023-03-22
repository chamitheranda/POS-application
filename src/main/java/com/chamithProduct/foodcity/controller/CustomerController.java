package com.chamithProduct.foodcity.controller;

import com.chamithProduct.foodcity.dto.CustomerDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerRequestDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerUpdateQueryDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerUpdateRequestDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerViewByActiveState;
import com.chamithProduct.foodcity.dto.responseDTO.ResponseActiveCustomerDTO;
import com.chamithProduct.foodcity.service.CustomerService;
import com.chamithProduct.foodcity.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService ;
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveDetail(@RequestBody CustomerRequestDTO customerRequestDTO){
        System.out.println("name" +" "+ customerRequestDTO.getCustomerName());
        String text = customerService.addMember(customerRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse
                        (
                                201,
                                "Saved successfully !!",
                                text
                        ),HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> customerUpdate(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
        System.out.println("update success " + customerUpdateRequestDTO.getCustomerId());
        String text =customerService.updateCustomer(customerUpdateRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse
                        (
                                201,
                                "Update successfully !!",
                                text
                        ),HttpStatus.CREATED
        );

    }

    @GetMapping(path = {"/search"}, params = {"id"})
    public ResponseEntity<StandardResponse> getById (@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerDetail(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "This is the customer id = " + id,
                        customerDTO
                ),HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<StandardResponse> getAllMembers(){
        List<CustomerDTO> allMembers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "All members are showing ",
                        allMembers
                ),HttpStatus.OK
        );
    }

    @DeleteMapping(
            path="/Delete-customer /{id}"
    )
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value="id")int id) throws NotFoundException {
        boolean deleteCustomer = customerService.deleteCustomer(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Delete customer where id = "+ id ,
                        deleteCustomer
                ),HttpStatus.OK
        );
    }
    @GetMapping(
            path={"/get-by-name-customer"} ,
            params = {"name"}
    )
    public ResponseEntity getByCustomerName (@RequestParam(value="name") String name) throws NotFoundException {
        List<CustomerDTO> getCustomer = customerService.getByName(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "This is the customer name = " + name,
                        getCustomer
                ),HttpStatus.OK
        );
    }
    @GetMapping(path = {"/get-customer-byActivestate"})
    public ResponseEntity getByCustomerActivestate() throws NotFoundException {
        List<CustomerDTO> customerDTOList = customerService.getByActiveStates();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "This is the customers  ",
                        customerDTOList
                ),HttpStatus.OK
        );
    }
    @GetMapping(path = "get-customername-byActiveState")
    public ResponseEntity  getNameByActiveState() throws NotFoundException {
        List<ResponseActiveCustomerDTO> responseActiveCustomerDTOS = customerService.getCustomerNameActiveState();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "This is the customers name = ",
                        responseActiveCustomerDTOS
                ),HttpStatus.OK
        );
    }
    @PutMapping(path = "/update-query-customer/{id}")
    public ResponseEntity updateCustomerNameById(@RequestBody CustomerUpdateQueryDTO customerUpdateQueryDTO, @PathVariable(value="id")int id) {
        String customers = customerService.updateNameQueryById(customerUpdateQueryDTO , id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Update the customer name  id = " + id,
                        customers
                ),HttpStatus.CREATED
        );
    }
    @GetMapping(path = "/get-ActiveStatesByID/{id}")
    public ResponseEntity<StandardResponse> getActiveStateIfTrue(@PathVariable(value = "id")int id)   {
        CustomerDTO customerDTO= customerService.getActiveStateByIdIfTrue(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "",
                        customerDTO
                ),HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-customer-By-ID & ActiveState")
    public ResponseEntity<StandardResponse> getCustomerUsingByIDActiveState(@RequestBody CustomerViewByActiveState customerViewByActiveState){
        CustomerDTO customer = customerService.getByIDActiveState(customerViewByActiveState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse
                (
                        200,
                        "This is the customer suitable for id and Active status you provide",
                         customer
                ), HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-by-state/{state}")
    public ResponseEntity<StandardResponse> getByState(@PathVariable(value = "state") String state){
        if(state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")){
            boolean status = state.equalsIgnoreCase("active")? true:false;
           List<CustomerDTO> customerDTOs = customerService.getAllByState( status);
           return  new ResponseEntity<StandardResponse>(
                   new StandardResponse
                           (
                                   200,
                                   " This is the Customers you given state. ",
                                   customerDTOs
                           ), HttpStatus.OK
           );
        }
        else{
            List<CustomerDTO> customerDTOs = customerService.getAllCustomers();
            return  new ResponseEntity<StandardResponse>(
                    new StandardResponse
                            (
                                    200,
                                    " This is the Customers you given state. ",
                                    customerDTOs
                            ), HttpStatus.OK
            );
        }



    }

}

