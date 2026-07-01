package com.nit.dto;

import jakarta.persistence.*;

@Entity
public class SimCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_id;

    private String s_name;
    private long s_num;
    private double price;

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public long getS_num() {
        return s_num;
    }

    public void setS_num(long s_num) {
        this.s_num = s_num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SimCard [s_id=" + s_id + ", s_name=" + s_name + ", price=" + price + "]";
    }
}
