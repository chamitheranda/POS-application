package com.chamithProduct.foodcity.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "employee")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Employe {
    @Id
    @Column(name = "employe_id",length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeID ;


    @Column(name = "employe_age",length=3)
    private int employeAge;

    @Column(name = "address",length = 70)
    private String addrss;

    @Type(type = "json")
    @Column(name = "contact_number",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Employe() {
    }

    public Employe(int employeID, int employeAge, String addrss, ArrayList contactNumber, boolean activeState) {
        this.employeID = employeID;
        this.employeAge = employeAge;
        this.addrss = addrss;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }

    public Employe(int employeAge, String addrss, ArrayList contactNumber, boolean activeState) {
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
        return "Employe{" +
                "employeID=" + employeID +
                ", employeAge=" + employeAge +
                ", addrss='" + addrss + '\'' +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }
}
