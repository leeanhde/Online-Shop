/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author anhde
 */
public class Saler {
    private int saler_id;
    private String saler_name;
    private Date dob;
    private int phone;
    private String address;

    public int getSaler_id() {
        return saler_id;
    }

    public void setSaler_id(int saler_id) {
        this.saler_id = saler_id;
    }

    public String getSaler_name() {
        return saler_name;
    }

    public void setSaler_name(String saler_name) {
        this.saler_name = saler_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
            
}
