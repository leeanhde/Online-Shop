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
public class Product {
    private int product_id;
    private String product_name;
    private String status;
    private int price_in;
    private int price_out;
    private Date guarantee;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice_in() {
        return price_in;
    }

    public void setPrice_in(int price_in) {
        this.price_in = price_in;
    }

    public int getPrice_out() {
        return price_out;
    }

    public void setPrice_out(int price_out) {
        this.price_out = price_out;
    }

    public Date getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Date guarantee) {
        this.guarantee = guarantee;
    }
    
}
