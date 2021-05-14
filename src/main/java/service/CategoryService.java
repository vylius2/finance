package service;

import entity.Category;
import entity.Record;
import entity.RecordType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public List<Category> getAll() {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        List<Category> categories = new ArrayList<>();

        try {
            //CIA VEIKIA JEIGU IR NE IDEDI GENERIC <Category>
            Query<Category> query = session.createNativeQuery("SELECT * FROM category", Category.class);
            categories = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }

    public List<Category> getIncomeCategories() {
        return getCategoriesByType(RecordType.INCOME);
    }

    public List<Category> getOutcomeCategories() {
        return getCategoriesByType(RecordType.OUTCOME);
    }

    public void save(Category category) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(category);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    private List<Category> getCategoriesByType(RecordType recordType) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        List<Category> Categories = new ArrayList<>();

        try {
            Query<Category> query = session.createQuery("FROM Category WHERE recordType = :recordType", Category.class);
            query.setParameter("recordType", recordType);
            Categories = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return Categories;
    }

}
