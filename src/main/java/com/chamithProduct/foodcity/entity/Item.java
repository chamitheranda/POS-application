package com.chamithProduct.foodcity.entity;

import com.chamithProduct.foodcity.entity.enums.MeasuringUnitPrice;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item")
@TypeDefs({
        @TypeDef(name = "jaon",typeClass = JsonType.class)
})
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id ;

    @Column(name = "item_name" , length=100 , nullable = false)
    private String itemName ;

    @Column(name = "measuring_unit" , length = 100 , nullable = false)
    private MeasuringUnitPrice measuringUnit ;

    @Column(name = "balance_qty" ,length = 100 , nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price" , length=100 , nullable = false)
    private double supplierPrice ;

    @Column(name = "selling_price" , length=100 , nullable = false)
    private double sellingPrice ;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetail> orderDetails;


}
