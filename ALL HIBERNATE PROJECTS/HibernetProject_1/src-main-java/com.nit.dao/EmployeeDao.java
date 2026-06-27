package com.nit.dao;

import java.util.List;

import com.nit.dto.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDao {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subh");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        
//        Employee e=new Employee();
//        e.setName("Manoj");
//        e.setDept(".NET");
//        e.setSalary(7500);
//        e.setMob_num(8956036895l);
        
        //fetch by id
//       Employee emp= em.find(Employee.class, 3);
//       System.out.println(emp.getId());
//       System.out.println(emp.getName());
//       System.out.println(emp.getMob_num());
//       System.out.println(emp.getSalary());
//       System.out.println(emp.getDept());
       
//        et.begin();
//        em.persist(e);
//        et.commit();
//        System.out.println("Data Has Been Inserted Sucessfully...");
        
        //Updated Operation        
//        Employee emp= em.find(Employee.class, 3);
//        emp.setName("Ranjit");
//        emp.setSalary(14000);
//        emp.setDept("FullStack");
//        emp.setMob_num(9856857589l);
//        
//        et.begin();
//        em.merge(emp);
//        et.commit();
//        System.out.println("Data Has Been Updated Succesfully...");
        
        
        
//        Employee e=em.find(Employee.class, 3);
//        et.begin();
//        em.remove(e);
//        et.commit();
//        System.out.println("Data has been deleted Succesfully...");
          List<Employee>e=em.createQuery("Select e FROM Employee e",Employee.class).getResultList();
          for(Employee name:e)
          {
        	  System.out.println(name);
          }
        
	}

}
