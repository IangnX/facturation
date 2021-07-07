/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fioxin.springboot.facturation.app.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Xiangn Rodriguez<xiangnrodriguez@gmail.com>
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "datail_sale")
public class DetailSale implements Serializable{

  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer quantity;
    
    private Sale sale;

    
    public Double calculateTotalPrice(){
        return quantity.doubleValue();
    }
    
   
    private static final long serialVersionUID = 1L;

}
