package com.latiah.spring.demo.repository;

import com.latiah.spring.demo.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository <Food,Long> {
}
