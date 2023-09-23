package com.Anish.Stock_App.controller;

import com.Anish.Stock_App.model.Stock;
import com.Anish.Stock_App.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

        @PostMapping("stocks")
     public String addStocks(@RequestBody List<Stock> newStock){
           return stockService.addStocks(newStock);
        }

        @GetMapping("stocks")
    public List<Stock> getAllStock(){
            return stockService.getAllStock();
        }

        @DeleteMapping("stocks/id/{id}")
     public String getDeleteById(@PathVariable Long id){
           return stockService.getDeleteById(id);
        }

        //UpdateById

     @PutMapping("stock/price/id")
     public String updateStockById(@RequestParam Long id, @RequestParam double price) {
            return stockService.updateStockById(id,price);
     }
}
