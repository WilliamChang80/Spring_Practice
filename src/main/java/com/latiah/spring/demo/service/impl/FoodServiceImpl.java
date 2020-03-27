package com.latiah.spring.demo.service.impl;

import com.latiah.spring.demo.domain.Food;
import com.latiah.spring.demo.repository.FoodRepository;
import com.latiah.spring.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;


    @Override
    public List<Food> getAllFoods() {
        List<Food> foodList = foodRepository.findAll();
        return foodList;
    }

    @Override
    public void createFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void updateFood(Food food, Long foodID) {
        Food updatedFood = foodRepository.findById(foodID).orElse(null);
        updatedFood.setFoodName(food.getFoodName())
                .setFoodPrice(food.getFoodPrice())
                .setRating(food.getRating());
        foodRepository.save(updatedFood);
    }

    @Override
    public void deleteFood(Long foodID) {
        Food deletedFood = foodRepository.findById(foodID).orElseThrow(null);
        foodRepository.delete(deletedFood);
    }

    @Override
    public Food getFoodByID(Long foodID) {
        Food food = foodRepository.findById(foodID).orElse(null);
        return food;
    }
}
