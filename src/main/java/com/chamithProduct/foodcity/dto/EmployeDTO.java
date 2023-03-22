package com.chamithProduct.foodcity.dto.serviceDTO;

import java.util.ArrayList;

public class EmployeDTO {
    private int employeID ;
    private int employeAge;
    private String addrss;
    private ArrayList contactNumber;
    private boolean activeState;

    public EmployeDTO() {
    }

    public EmployeDTO(int employeID, int employeAge, String addrss, ArrayList contactNumber, boolean activeState) {
        this.employeID = employeID;
        this.employeAge = employeAge;
        this.addrss = addrss;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }

    public int getEmployeID() {
        return employeID;
    }

    public void setEmployeID(int employeID) {
        this.employeID = employeID;
    }

    public int getEmployeAge() {
        return employeAge;
    }

    public void setEmployeAge(int employeAge) {
        this.employeAge = employeAge;
    }

    public String getAddrss() {
        return addrss;
    }

    public void setAddrss(String addrss) {
        this.addrss = addrss;
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
        return "EmployeDTO{" +
                "employeID=" + employeID +
                ", employeAge=" + employeAge +
                ", addrss='" + addrss + '\'' +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }
}
