package com.latiah.spring.demo.service.impl;

import com.latiah.spring.demo.domain.Food;
import com.latiah.spring.demo.domain.Receipt;
import com.latiah.spring.demo.domain.Store;
import com.latiah.spring.demo.domain.User;
import com.latiah.spring.demo.repository.ReceiptRepository;
import com.latiah.spring.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    ReceiptRepository receiptRepository;

    @Override
    public List<Receipt> getAllReceipts() {
        List<Receipt> receiptList = receiptRepository.findAll();
        return receiptList;
    }

    @Override
    public void createReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public void updateReceipt(Receipt receipt, Long receiptID) {
        Receipt updatedReceipt = getReceiptByID(receiptID)
                .setReceiptDate(receipt.getReceiptDate())
                .setReceiptPrice(receipt.getReceiptPrice())
                .setReceiptStatus(receipt.getReceiptStatus())
                .setFood(receipt.getFood())
                .setStore(receipt.getStore())
                .setUser(receipt.getUser());
        receiptRepository.save(updatedReceipt);
    }

    @Override
    public void deleteReceipt(Long receiptID) {
        Receipt deletedReceipt = getReceiptByID(receiptID);
        receiptRepository.delete(deletedReceipt);
    }

    @Override
    public List<Food> getAllFoodInReceipt(Receipt receipt) {
        List<Food> food = receipt.getFood();
        return food;
    }

    @Override
    public User getUserInReceipt(Receipt receipt) {
        User user = receipt.getUser();
        return user;
    }

    @Override
    public Store getStoreInReceipt(Receipt receipt) {
        Store store = receipt.getStore();
        return store;
    }

    @Override
    public Receipt getReceiptByID(Long receiptID) {
        Receipt receipt = receiptRepository.findById(receiptID).orElse(null);
        return receipt;
    }
}
