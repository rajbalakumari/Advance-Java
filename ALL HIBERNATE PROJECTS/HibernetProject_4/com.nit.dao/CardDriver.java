package com.nit.dao;

import com.nit.dto.AdhCard;
import com.nit.dto.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CardDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("subh");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Person p=new Person();
        p.setName("Mahi");
        p.setAdress("Ranchi");
        p.setMob_num(8596857485l);
        
        AdhCard card=new AdhCard();
        card.setCh_name("Mahinda Singh");
        card.setC_num("MSD4587D");
         
        
        p.setCard(card);
        et.begin();
        em.persist(card);
        em.persist(p);
        et.commit();
        System.out.println("Data Has Been Inserted Sucessfully.....");
        
        

	}

}
