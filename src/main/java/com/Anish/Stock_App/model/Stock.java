package com.Anish.Stock_App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  //For Table Creation
public class Stock {

    //jaha pr @Id lgaye ho waha ka DataType ko likhna hai StockRepo ke ander (CrudRepository<Stock,Long>)

    @Id  //for Primary Key creation
    private Long stockId;

    private String stockName;

    private double stockPrice;

    private int stockOwnerCount;

    @Enumerated(EnumType.STRING)
    private Type stockType;

    private LocalDateTime stockCreationTimeStamp;

}
