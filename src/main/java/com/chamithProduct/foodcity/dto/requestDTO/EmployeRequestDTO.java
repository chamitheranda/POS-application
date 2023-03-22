package com.chamithProduct.foodcity.dto.requestDTO;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

public class EmployeRequestDTO {

    private int employeAge;
    private String addrss;
    private ArrayList contactNumber;
    private boolean activeState;

    public EmployeRequestDTO() {
    }

    public EmployeRequestDTO(int employeAge, String addrss, ArrayList contactNumber, boolean activeState) {
        this.employeAge = employeAge;
        this.addrss = addrss;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
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
        return "EmployeRequestDTO{" +
                "employeAge=" + employeAge +
                ", addrss='" + addrss + '\'' +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }
}
