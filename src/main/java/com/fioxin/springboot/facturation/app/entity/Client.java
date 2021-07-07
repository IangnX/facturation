/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fioxin.springboot.facturation.app.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Xiangn Rodriguez<xiangnrodriguez@gmail.com>
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
   @NotEmpty(message = " no puede estar vacio")
   @Size(min = 4, message= " debe tener al menos 4 caracteres")
   @Column(nullable = false)
    private String dni;
    
    @NotEmpty(message = " no puede estar vacio")
    @Size(min = 2, message= " debe tener al menos 2 caracteres")
    @Column(nullable = false)
    private String name;
    
    @NotEmpty(message = " no puede estar vacio")
    @Size(min = 8, message= " debe tener al menos 8 caracteres")
    @Column(nullable = false)
    private String phone;
    
    @NotEmpty(message = " no puede estar vacio")
    @Size(min = 8, message= " debe tener al menos 8 caracteres")
    @Column(nullable = false)
    private String address;
    
    @Column(name = "modificated_by")
    private String modicatedBy;
    
    
    private Boolean status;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy= "client")
   private  List<Sale> sale;
    
 private static final long serialVersionUID = 1L;
}
