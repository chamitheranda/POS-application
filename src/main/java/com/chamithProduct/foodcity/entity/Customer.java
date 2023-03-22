package com.chamithProduct.foodcity.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {
    @Id
    @Column(name = "customer_id",length = 40)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int customerId;


    @Column(name = "customer_name",length = 56)
    private String customerName;

    @Column(name = "customer_salary",length= 10 , nullable = false)
    private double customerSalarry;

    @Type(type = "json" )
    @Column(name = "contact_number",columnDefinition = "json" ,unique = true)
    private ArrayList contactNumber;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

    public Customer() {
    }

    public Customer(String customerName, double customerSalarry, ArrayList contactNumber, boolean activeState) {
        this.customerName = customerName;
        this.customerSalarry = customerSalarry;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }

    public Customer(int customerId, String customerName, double customerSalarry, ArrayList contactNumber, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSalarry = customerSalarry;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }

    public Customer(int customerId, String customerName, double customerSalarry) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSalarry = customerSalarry;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerSalarry() {
        return customerSalarry;
    }

    public void setCustomerSalarry(double customerSalarry) {
        this.customerSalarry = customerSalarry;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSalarry=" + customerSalarry +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }
}
