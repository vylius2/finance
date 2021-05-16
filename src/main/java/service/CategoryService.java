package service;

import entity.Category;
import entity.RecordType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public void delete(Category category){
        ServiceBase.delete(category);
    }

    public List<Category> getAll(){
        return ServiceBase.getAll(Category.class);
    }

    public List<Category> getIncomeCategories() {
        return getCategoriesByType(RecordType.INCOME);
    }

    public List<Category> getOutcomeCategories() {
        return getCategoriesByType(RecordType.OUTCOME);
    }

    public void save(Category category) {
        ServiceBase.save(category);
    }

    public Category getById(Long id){
        return ServiceBase.getById(Category.class, id);
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
