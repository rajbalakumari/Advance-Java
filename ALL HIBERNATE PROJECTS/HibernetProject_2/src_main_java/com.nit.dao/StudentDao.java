package com.nit.dao;

import com.nit.dto.Student;

import jakarta.persistence.*;

public class StudentDao {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("subh");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // ================= INSERT =================
//        Student s = new Student();
//        s.setName("Rajendr");
//        s.setCourse(".Python");
//        s.setMob_num(8569836895L);
//
//        et.begin();
//        em.persist(s);
//        et.commit();
//        System.out.println("Data Inserted Successfully...");

//        // ================= FETCH ALL ===HQL(HIBERNET QUERY LANGUAGE)==============
        System.out.println("\n--- All Students ---");
        for (Student st : em.createQuery("from Student", Student.class).getResultList()) {
            System.out.println(st);
        }
//
//        // ================= UPDATE =================
//        Student stu = em.find(Student.class, 1);
//        stu.setName("Rahul");
//        stu.setCourse("Spring Boot");
//
//        et.begin();
//        em.merge(stu);
//        et.commit();
//        System.out.println("Data Updated Successfully...");
//
//        // ================= DELETE =================
//        Student st = em.find(Student.class, 1);
//
//        et.begin();
//        em.remove(st);
//        et.commit();
//        System.out.println("Data Deleted Successfully...");
//
//        // ================= CLOSE =================
//        em.close();
//        emf.close();
    }
}
