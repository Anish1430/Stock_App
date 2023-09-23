package com.Anish.Stock_App.service;

import com.Anish.Stock_App.model.Stock;
import com.Anish.Stock_App.repo.IStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockRepo iStockRepo;

    public String addStocks(List<Stock> newStock) {
        iStockRepo.saveAll(newStock);
        return "Added in Stock";
    }


    public List<Stock> getAllStock() {
        return (List<Stock>) iStockRepo.findAll();
    }

    public String getDeleteById(Long id) {
        iStockRepo.deleteById(id);
        return "Remove";
    }


    public String updateStockById(Long id, double price) {
        Stock presentStock=iStockRepo.findById(id).orElse(null);
        if(presentStock != null){
            presentStock.setStockPrice(price);
            iStockRepo.save(presentStock);
            return "Stock is Updated";
        }else {
            return "Stock is not updated";
        }
    }
}
