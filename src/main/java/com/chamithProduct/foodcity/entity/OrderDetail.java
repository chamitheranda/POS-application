package com.chamithProduct.foodcity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @Column(name = "order_detail_id",length = 40)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int orderDetailId;

    @Column(name = "item_name",length = 40 ,nullable = false)
    private String itemName ;

    @Column(name = "qty" , length = 100 ,nullable = false)
    private int qty;

    @Column(name = "amount" , length = 20)
    private double amount ;

    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Item items ;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders ;

    }

