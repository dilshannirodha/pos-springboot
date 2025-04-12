package com.pos.project.point_of_sale.respository;


import com.pos.project.point_of_sale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    boolean existsByNic(String nic);
}
