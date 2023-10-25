package com.Anish.Stock_App.service;

import com.Anish.Stock_App.model.Stock;
import com.Anish.Stock_App.model.Type;
import com.Anish.Stock_App.repo.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Stock> getStocksByTypeLessEqualPrice(Type type, double price) {
         return iStockRepo.findByStockTypeAndStockPriceLessThanEqual(type,price);
    }

    public List<Stock> getAllStocksLessPriceLessTime(double price, LocalDateTime year) {
       return iStockRepo.findByStockPriceLessThanAndStockCreationTimeStamp(price,year);
    }

    @Transactional
    public String updateStockByType(float hike, Type stockType) {
         iStockRepo.updateStockByType(hike,stockType.name());
         return "Updated";
    }
}