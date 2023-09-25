package com.Anish.Stock_App.repo;

import com.Anish.Stock_App.model.Stock;
import com.Anish.Stock_App.model.Type;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface IStockRepo extends CrudRepository<Stock,Long> {

    List<Stock> findByStockTypeAndStockPriceLessThanEqual(Type type, double price);


    List<Stock> findByStockPriceLessThanAndStockCreationTimeStamp(double price, LocalDateTime year);
}
