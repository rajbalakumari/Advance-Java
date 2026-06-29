package com.nit.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdhCard {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String ch_name;
    private String c_num;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	
	@Override
	public String toString() {
		return "PanCard [pid=" + pid + ", ch_name=" + ch_name + ", c_num=" + c_num + "]";
	}
    
    
}
