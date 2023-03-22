package com.chamithProduct.foodcity.dto.requestDTO;

import java.util.ArrayList;

public class CustomerRequestDTO {
    private String customerName;
    private double customerSalarry;
    private ArrayList contactNumber;
    private boolean activeState;
    private boolean  active;


    public CustomerRequestDTO() {
    }

    public CustomerRequestDTO(String customerName, double customerSalarry, ArrayList contactNumber, boolean activeState, boolean active) {
        this.customerName = customerName;
        this.customerSalarry = customerSalarry;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerSalarry=" + customerSalarry +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                ", active=" + active +
                '}';
    }
}
