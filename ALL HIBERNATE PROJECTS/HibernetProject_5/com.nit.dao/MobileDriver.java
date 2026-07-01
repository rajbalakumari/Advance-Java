package com.nit.dao;

import java.util.Arrays;

import com.nit.dto.Mobile;
import com.nit.dto.SimCard;

import jakarta.persistence.*;

public class MobileDriver {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("subh");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Create Mobile
        Mobile m = new Mobile();
        m.setM_name("Vivo");
        m.setM_color("Blue");
        m.setM_price(18000.0);

        // Create SimCards
        SimCard s1 = new SimCard();
        s1.setS_name("Airtel");
        s1.setS_num(9876543210L);
        s1.setPrice(500);

        SimCard s2 = new SimCard();
        s2.setS_name("Jio");
        s2.setS_num(9123456789L);
        s2.setPrice(300);

        // Set list
        m.setCard(Arrays.asList(s1, s2));

        // Save
        et.begin();
        em.persist(m);
        et.commit();

        System.out.println("Data Saved Successfully ✅");
    }
}
