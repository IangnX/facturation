/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fioxin.springboot.facturation.app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Xiangn Rodriguez<xiangnrodriguez@gmail.com>
 */

@Data
@Entity
@Table(name = "sales")
public class Sale implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name_seller")
    private String nameSeller;
    
    private String description;
    
    private String observation;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;
    
    @Column(name = "type_pay")
    private String typePay;
    
    @Column(name = "dni_client")
    private String dniClient;
    
    @Column(name = "method_pay")
    private String methodPay;
    
    @ManyToOne(fetch =FetchType.LAZY)
    private Client client;
    
    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL) //cascade al eliminar una factura se eliminan sus detalles. Lo mismo que al guardarla
    @JoinColumn(name = "sale_id" ) // al no tener el mapeo inverso.Se creara el campo sale_id en la tabla detail_sale
    private List<DetailSale> detailSale;

    public Sale() {
        detailSale = new ArrayList<>();
        
    }
   
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDate.now();
    }
    
    
    
    private static final long serialVersionUID = 1L;
}
