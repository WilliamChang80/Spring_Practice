package com.latiah.spring.demo.service;

import com.latiah.spring.demo.domain.Food;
import com.latiah.spring.demo.domain.Store;

import java.util.List;

public interface StoreService {
    public List<Store> getAllStores();
    public Store getStoreByID(Long storeID);
    public List<Food> getAllFoodInStore(Store store);
    public void createStore(Store store);
    public void updateStore(Store store, Long storeID);
    public void deleteStore(Long storeID);
}
