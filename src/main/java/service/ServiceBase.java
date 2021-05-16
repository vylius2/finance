package service;

import entity.Category;
import entity.Record;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ServiceBase {



    public static <T> void save(T t) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(Class<T> anyClass) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        List<T> list = new ArrayList<>();
        try {
            Query<T> query = session.createQuery("FROM " + anyClass.getSimpleName(), anyClass);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return list;
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
