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

/**
 * 
 * @author Xiangn Rodriguez<xiangnrodriguez@gmail.com>
 */

@Entity
@Table(name = "products")
public class Products implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    
    private String name;
    
    private String desc;
    
    private Double cost;
    
    private Double price;
    
    private Integer stock;
    
    private Integer descuento;
    
    private Boolean status;

    
    private static final long serialVersionUID = 1L;
}
