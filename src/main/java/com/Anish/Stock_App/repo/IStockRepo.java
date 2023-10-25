package com.Anish.Stock_App.repo;

import com.Anish.Stock_App.model.Stock;
import com.Anish.Stock_App.model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface IStockRepo extends CrudRepository<Stock,Long> {

    List<Stock> findByStockTypeAndStockPriceLessThanEqual(Type type, double price);


    List<Stock> findByStockPriceLessThanAndStockCreationTimeStamp(double price, LocalDateTime year);

    @Modifying
    @Query(value = "UPDATE STOCK SET STOCK_PRICE=(STOCK_PRICE + STOCK_PRICE*(:hike)) WHERE STOCK_TYPE= :stockType", nativeQuery = true)
    void updateStockByType(float hike, String stockType);
}
