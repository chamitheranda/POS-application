package com.chamithProduct.foodcity.service.impl;

import com.chamithProduct.foodcity.dto.CustomerDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerRequestDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerUpdateQueryDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerUpdateRequestDTO;
import com.chamithProduct.foodcity.dto.requestDTO.CustomerViewByActiveState;
import com.chamithProduct.foodcity.dto.responseDTO.ResponseActiveCustomerDTO;
import com.chamithProduct.foodcity.entity.Customer;
import com.chamithProduct.foodcity.repo.CustomerRepo;
import com.chamithProduct.foodcity.service.CustomerService;
import com.chamithProduct.foodcity.util.mappers.CustomerMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String addMember(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer(

                customerRequestDTO.getCustomerName(),
                customerRequestDTO.getCustomerSalarry(),
                customerRequestDTO.getContactNumber(),
                false

        );

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName() + " Saved ";


        } else {
            System.out.println("customer id is exists ");
            return customer.getCustomerId() + "  this id is exists";
        }


    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {


        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {

            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());
            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerSalarry(customerUpdateRequestDTO.getCustomerSalarry());
            customer.setContactNumber(customerUpdateRequestDTO.getContactNumber());
            customer.setActiveState(customerUpdateRequestDTO.isActiveState());
            customerRepo.save(customer);

            System.out.println("Data is updated ..." + customerUpdateRequestDTO.getCustomerName());
            String text = "Data is updated ..." + customerUpdateRequestDTO.getCustomerName();
            return text;


        } else {
            System.out.println("This customer is not exist ..." + customerUpdateRequestDTO.getCustomerName());
            String text = " this customer is not exist ..." + customerUpdateRequestDTO.getCustomerName();
            return text;
        }

    }

    @Override
    public CustomerDTO getCustomerDetail(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
      /* CustomerDTO customerDTO = new CustomerDTO(
               customer.get().getCustomerId(),
               customer.get().getCustomerName(),
               customer.get().getCustomerSalarry(),
               customer.get().getContactNumber(),
               customer.get().isActiveState()
       ); */
        //CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);
        // use mapstruct to convert entity to DTO
        CustomerDTO customerDTO = customerMapper.entitytoDTO(customer.get());
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();
       /* for (Customer c : allCustomers) {
            CustomerDTO allMembers = new CustomerDTO(
                    c.getCustomerId(),
                    c.getCustomerName(),
                    c.getCustomerSalarry(),
                    c.getContactNumber(),
                    c.isActiveState()
            ) ;
            customerDTO.add(allMembers);
        }
        return customerDTO;


    }

        */
        List<CustomerDTO> customerDTO = new ArrayList<>();
        List<CustomerDTO> allCustomer = modelMapper.map(allCustomers, new TypeToken<List<CustomerDTO>>() {
        }.getType());
        return allCustomer;
    }

    @Override
    public boolean deleteCustomer(int id) throws NotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new NotFoundException("id is not exist ");
        }
        return false;
    }

    @Override
    public List<CustomerDTO> getByName(String name) throws NotFoundException {
        List<Customer> customer = customerRepo.getAllByCustomerNameEquals(name);

        if (customer.size()!=0){
           // List<CustomerDTO> customerDTOList = modelMapper.map(customer, new TypeToken<List<CustomerDTO>>() {
           // }.getType());
            // mapstruct using entity list convert to DTO list
            List<CustomerDTO> customerDTOList = customerMapper.entityListToDTOList(customer);
            return customerDTOList;
        }else{
            throw new NotFoundException("no customer for same that name ..") ;
        }


    }

    @Override
    public List<CustomerDTO> getByActiveStates() throws NotFoundException {
        List<Customer> customer = customerRepo.getAllByActiveStateTrue();
        if(customer.size()!=0){
            List<CustomerDTO> customerDTOList = customerMapper.entityListToDTOList(customer);
            return customerDTOList;
        }else{
            throw new NotFoundException(" N0 Active state true customers ");
        }
    }

    @Override
    public List<ResponseActiveCustomerDTO> getCustomerNameActiveState() throws NotFoundException {
        List<Customer> customers = customerRepo.getAllByActiveStateTrue();
        if(customers.size()!=0){
            List<ResponseActiveCustomerDTO> responseActiveCustomerDTOS = customerMapper.entityListToResposeActiveCustomerDTO(customers);
            return responseActiveCustomerDTOS ;
        }else {
            throw new NotFoundException("No Active state true customers ");
        }
    }

    @Override
    public String updateNameQueryById(CustomerUpdateQueryDTO customerUpdateQueryDTO, int id) {
        if(customerRepo.existsById(id)){
            customerRepo.updateCustomerByQuery(customerUpdateQueryDTO.getCustomerName() , customerUpdateQueryDTO.getContactNumber(),id);
            String text = "Data is updated ..." + customerUpdateQueryDTO.getCustomerName();
            return text;
        } else {
            System.out.println("This customer is not exist ..." + customerUpdateQueryDTO.getCustomerName());
            String text = " this customer is not exist ..." + customerUpdateQueryDTO.getCustomerName();
            return text;
        }
    }

    @Override
    public CustomerDTO getActiveStateByIdIfTrue(int id)   {
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.getById(id);
            if(customer.isActiveState()){
                System.out.println("This customer is Active Customer .. ");
                CustomerDTO customerDTO = customerMapper.entitytoDTO(customer);
                return customerDTO ;
            }else{
                throw new com.chamithProduct.foodcity.exception.NotFoundException("This customer is inactive customer ");
            }
        }else{
            throw  new com.chamithProduct.foodcity.exception.NotFoundException("This customer is not in the database .. ");
        }
    }

    @Override
    public CustomerDTO getByIDActiveState(CustomerViewByActiveState customerViewByActiveState) {
        if(customerRepo.existsById(customerViewByActiveState.getCustomerId())){
            Customer customer  = customerRepo.getById(customerViewByActiveState.getCustomerId());

            if(Objects.equals(customerViewByActiveState.getState(), "Active")) {
                if(customer.isActiveState()){
                    CustomerDTO customer1 = customerMapper.entitytoDTO(customer);
                    return  customer1 ;
                }else{
                    throw new com.chamithProduct.foodcity.exception.NotFoundException("This customer is inactive customer ");
                }

            }else if(Objects.equals(customerViewByActiveState.getState(), "InActive")){
                if(!customer.isActiveState()){
                    CustomerDTO customer1 = customerMapper.entitytoDTO(customer);
                    return  customer1 ;
                }else{
                    throw new com.chamithProduct.foodcity.exception.NotFoundException("This customer is active customer ");
                }
            }else {
                CustomerDTO customer1 = customerMapper.entitytoDTO(customer);
                return  customer1 ;
            }

        }else{
            throw new com.chamithProduct.foodcity.exception.NotFoundException("not in data base ");
        }
    }

    @Override
    public List<CustomerDTO> getAllByState(boolean status) {
        List<Customer> customers = customerRepo.getAllByActiveStateEquals(status);
        List<CustomerDTO> customersDTO = customerMapper.entityListToDTOList(customers);
        return customersDTO ;

    }


}
