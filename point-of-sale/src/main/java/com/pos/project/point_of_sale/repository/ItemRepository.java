package com.pos.project.point_of_sale.repository;

import com.pos.project.point_of_sale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item, Integer> {


    boolean existsByItemName(String itemName);

    List<Item> findAllByActiveStateEquals(boolean status);
}
