package com.nit;

import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nit.entity.*;

public class App {

    public static void main(String[] args) {

        // Step 1: Create Configuration object
        Configuration cnfig = new Configuration();

        // Step 2: Read Hibernate configuration file
        cnfig.configure("hibernate-cnf.xml");

        // Step 3: Create SessionFactory
        SessionFactory factory = cnfig.buildSessionFactory();

        System.out.println("SessionFactory Created Successfully");
        System.out.println(factory);

        // Reading employee details from console
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the employee Id:");
        int id = sc.nextInt();

        System.out.println("Enter the employee name:");
        String name = sc.next();

        System.out.println("Enter the employee address:");
        String address = sc.next();

        System.out.println("Enter the employee company name:");
        String companyName = sc.next();

        // Create Employee object
        Employee emp = new Employee();

        emp.setId(id);
        emp.setName(name);
        emp.setAddress(address);
        emp.setCompanyName(companyName);

        // Step 4: Open Session
        Session session = factory.openSession();

        // Step 5: Start Transaction
        Transaction transaction = session.beginTransaction();

        // Step 6: Save Employee object
        session.persist(emp);

        // Step 7: Commit Transaction
        transaction.commit();

        // Step 8: Close Session
        session.close();

        // Step 9: Close SessionFactory
        factory.close();

        sc.close();

        System.out.println("Employee data saved successfully!");
    }
}
