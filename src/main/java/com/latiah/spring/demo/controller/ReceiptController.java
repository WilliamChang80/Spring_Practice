package com.latiah.spring.demo.controller;

import com.latiah.spring.demo.domain.Food;
import com.latiah.spring.demo.domain.Receipt;
import com.latiah.spring.demo.domain.Store;
import com.latiah.spring.demo.domain.User;
import com.latiah.spring.demo.domain.base.BaseDto;
import com.latiah.spring.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<BaseDto> getAllReceipt() {
        List<Receipt> receiptList = receiptService.getAllReceipts();
        return ResponseEntity.ok(new BaseDto(receiptList, true, 200));
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<BaseDto> createReceipt(@RequestBody Receipt receipt) {
        receiptService.createReceipt(receipt);
        return ResponseEntity.ok(new BaseDto(receipt, true, 200));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{receiptID}")
    ResponseEntity<BaseDto> updateReceipt(@RequestBody Receipt receipt, @PathVariable Long receiptID) {
        receiptService.updateReceipt(receipt, receiptID);
        return ResponseEntity.ok(new BaseDto(receipt, true, 200));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{receiptID}")
    ResponseEntity<BaseDto> deleteReceipt(@PathVariable Long receiptID) {
        receiptService.deleteReceipt(receiptID);
        return ResponseEntity.ok(new BaseDto("Receipt has been deleted", true, 200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{receiptID}")
    ResponseEntity<BaseDto> getReceiptByID(@PathVariable Long receiptID) {
        Receipt receipt = receiptService.getReceiptByID(receiptID);
        return ResponseEntity.ok(new BaseDto(receipt, true, 200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{receiptID}/user")
    ResponseEntity<BaseDto> getUserInReceipt(@PathVariable Long receiptID) {
        Receipt receipt = receiptService.getReceiptByID(receiptID);
        User userInReceipt = receiptService.getUserInReceipt(receipt);
        return ResponseEntity.ok(new BaseDto(userInReceipt,true,200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{receiptID}/food")
    ResponseEntity<BaseDto> getAllFoodInReceipt(@PathVariable Long receiptID) {
        Receipt receipt = receiptService.getReceiptByID(receiptID);
        List<Food> foodList = receiptService.getAllFoodInReceipt(receipt);
        return ResponseEntity.ok(new BaseDto(foodList, true, 200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{receiptID}/store")
    ResponseEntity<BaseDto> getStoreInReceipt(@PathVariable Long receiptID) {
        Receipt receipt = receiptService.getReceiptByID(receiptID);
        Store storeInReceipt = receiptService.getStoreInReceipt(receipt);
        return ResponseEntity.ok(new BaseDto(storeInReceipt,true,200));
    }

}
