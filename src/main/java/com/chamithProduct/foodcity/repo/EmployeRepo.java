package com.chamithProduct.foodcity.repo;
import com.chamithProduct.foodcity.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface EmployeRepo extends JpaRepository<Employe,Integer> {
}
