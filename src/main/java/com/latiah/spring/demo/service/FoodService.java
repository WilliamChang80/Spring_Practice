package com.latiah.spring.demo.service;

import com.latiah.spring.demo.domain.Food;

import java.util.List;

public interface FoodService {
    public List<Food> getAllFoods();
    public void createFood(Food food);
    public void updateFood(Food food, Long foodID);
    public void deleteFood(Long foodID);
    public Food getFoodByID(Long foodID);
}
