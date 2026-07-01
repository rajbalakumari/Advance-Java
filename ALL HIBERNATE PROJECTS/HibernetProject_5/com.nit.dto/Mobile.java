package com.nit.dto;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_id;

    private String m_name;
    private Double m_price;
    private String m_color;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SimCard> card;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public Double getM_price() {
        return m_price;
    }

    public void setM_price(Double m_price) {
        this.m_price = m_price;
    }

    public String getM_color() {
        return m_color;
    }

    public void setM_color(String m_color) {
        this.m_color = m_color;
    }

    public List<SimCard> getCard() {
        return card;
    }

    public void setCard(List<SimCard> card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Mobile [m_id=" + m_id + ", m_name=" + m_name + ", m_price=" + m_price + ", m_color=" + m_color
                + ", card=" + card + "]";
    }
}
