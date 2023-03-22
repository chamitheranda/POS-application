package com.chamithProduct.foodcity.repo;
import com.chamithProduct.foodcity.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item> getAllByActiveStateTrue();



    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable of);

    long countAllByActiveStateTrue();
    long countAllByActiveStateEquals(boolean activeState);


}
