package com.pos.project.point_of_sale.repository;

import com.pos.project.point_of_sale.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
