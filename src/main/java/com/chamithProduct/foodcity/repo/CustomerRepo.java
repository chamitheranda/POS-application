package com.chamithProduct.foodcity.repo;

import com.chamithProduct.foodcity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Integer>{


    List<Customer> getAllByCustomerNameEquals(String name);

    List<Customer> getAllByActiveStateTrue();
    @Modifying
    @Query(value = "update customer set customer_name = ?1 , contact_number=?2 where customer_id=?3 " ,nativeQuery=true)
    void updateCustomerByQuery(String customerName, ArrayList contactNumber, int id);
    List<Customer> getAllByActiveStateEquals(boolean status);
}

