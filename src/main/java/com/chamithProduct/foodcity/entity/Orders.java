package com.chamithProduct.foodcity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Orders")
public class Orders {
    @Id
    @Column(name = "orders_id",length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ordersId;

    @Column(name = "total",length = 20 , nullable = false)
    private double total ;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date ;


    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> orderDetails;

    public Orders(double total, Date date, Customer customer) {
        this.total = total;
        this.date = date;
        this.customer = customer;
    }
}
