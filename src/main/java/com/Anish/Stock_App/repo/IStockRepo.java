package com.Anish.Stock_App.repo;

import com.Anish.Stock_App.model.Stock;
import org.springframework.data.repository.CrudRepository;


public interface IStockRepo extends CrudRepository<Stock,Long> {

}
