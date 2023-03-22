package com.chamithProduct.foodcity.repo;

import com.chamithProduct.foodcity.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail , Integer> {
}
