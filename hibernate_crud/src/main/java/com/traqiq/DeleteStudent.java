package com.traqiq;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteStudent {
    public static void main(String[] args){
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student609.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter student number to delete a record:");
        Student609 student =(Student609) session.get(Student609.class,scan.nextInt());

        if(student!=null){
            session.delete(student);
            session.flush();
            tx.commit();
            System.out.println("One record deleted successfully");
        }
        else{
            System.out.println("Record not found please enter correct Student Id");
        }
        session.close();
        sessionFactory.close();
    }
}
