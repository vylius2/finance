package service;

import entity.Category;
import entity.Record;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ServiceBase {




    public static List<Object> getAll(String className) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        List<Object> categories = new ArrayList<>();//Pakeist categories i list

        try {
            Query<Object> query = session.createQuery("FROM " + className, Object.class);
            categories = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }


    public static  <T> void delete(T t){
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(t);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
