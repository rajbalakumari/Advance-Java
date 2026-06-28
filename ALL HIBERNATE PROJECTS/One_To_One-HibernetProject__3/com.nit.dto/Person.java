package com.nit.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private long mob_num;
     private String adress;
    
             @OneToOne
     private PanCard card;
     
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public long getMob_num() {
		 return mob_num;
	 }
	 public void setMob_num(long mob_num) {
		 this.mob_num = mob_num;
	 }
	 public String getAdress() {
		 return adress;
	 }
	 public void setAdress(String adress) {
		 this.adress = adress;
	 }
	 
	 public PanCard getCard() {
		return card;
	}
	 public void setCard(PanCard card) {
		 this.card = card;
	 }
	 
	 @Override
	 public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mob_num=" + mob_num + ", adress=" + adress + "]";
	 }
     
     
     
     
}
