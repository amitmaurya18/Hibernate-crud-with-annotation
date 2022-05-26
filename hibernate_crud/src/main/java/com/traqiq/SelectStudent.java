package com.traqiq;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SelectStudent {
    public static void main(String [] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student609.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Student Id:");
        Student609 student =(Student609) session.load(Student609.class,scan.nextInt());

        System.out.println("Student Id is:" + student.getId());
        System.out.println("Student Name is:" + student.getStudentName());
        System.out.println("Student Rollno is:" + student.getRollNumber());
        System.out.println("Student Course is:" + student.getCourse());
    }
}
