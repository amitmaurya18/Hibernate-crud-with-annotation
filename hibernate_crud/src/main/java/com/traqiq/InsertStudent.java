package com.traqiq;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args){
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student609.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;
        String choice ="no";
        Scanner scan= new Scanner((System.in));

        do{
            tx=session.beginTransaction();
            Student609 student=new Student609();
            System.out.println("Enter Student Id:");
            student.setId(scan.nextInt());
            System.out.println("Enter Student Name:");
            student.setStudentName(scan.next());
            System.out.println("Enter Student Rollno:");
            student.setRollNumber(scan.nextInt());
            System.out.println("Enter Course Name:");
            student.setCourse(scan.next());
            session.save(student);
            tx.commit();
            System.out.println("One record inserted successfully");
            System.out.println("Do you want insert new Student record y/n");
            choice=scan.next();
        }
        while(choice.equalsIgnoreCase("y") | choice.equalsIgnoreCase("yes"));
        session.close();
        sessionFactory.close();
    }
}
