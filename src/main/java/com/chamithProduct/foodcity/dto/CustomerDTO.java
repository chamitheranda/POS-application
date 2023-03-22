package com.chamithProduct.foodcity.dto;

import java.util.ArrayList;

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private double customerSalarry;
    private ArrayList contactNumber;
    private boolean activeState;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, double customerSalarry, ArrayList contactNumber, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSalarry = customerSalarry;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
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
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSalarry=" + customerSalarry +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }
}
