/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anhde
 */
public class Order_Detail {

    private int od_id;
    private int o_id;
    private int product_id;
    private int quantyti;

    public Order_Detail() {
    }

    public Order_Detail(int od_id, int o_id, int product_id, int quantyti, int price) {
        this.od_id = od_id;
        this.o_id = o_id;
        this.product_id = product_id;
        this.quantyti = quantyti;
    }

    public Order_Detail(int orderId, int productId, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Order_Detail(int od_id, int o_id, int productId, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getOd_id() {
        return od_id;
    }

    public void setOd_id(int od_id) {
        this.od_id = od_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantyti() {
        return quantyti;
    }

    public void setQuantyti(int quantyti) {
        this.quantyti = quantyti;
    }

}
