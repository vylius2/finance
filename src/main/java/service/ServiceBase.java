package service;

import entity.Record;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ServiceBase {

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
