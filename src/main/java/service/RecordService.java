package service;

import entity.Record;
import entity.RecordType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.HolderInstantiator;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecordService{


    public List<Record> getIncomeRecords() {
        return getRecordsByType(RecordType.INCOME);
    }

    public List<Record> getOutcomeRecords() {
        return getRecordsByType(RecordType.OUTCOME);
    }


    public List<Record> getAll() {
        return ServiceBase.getAll(Record.class);
    }

    public Record getById(Long id){
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        Record record = null;
        try {
            record = session.get(Record.class, id);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return record;
    }

    public void save(Record record) {
        ServiceBase.save(record);
    }

    public void delete(Record record){
        ServiceBase.delete(record);
    }


    public List<Record> getTopFiveOutcomeRecords() {
        List<Record> records = getOutcomeRecords();
        sortRecordsDESC(records);
        return records.subList(0, 5);
    }

    public List<Record> getCurrentMonthIncomeRecords() {
        return getRecordsByMonth(LocalDate.now(), getIncomeRecords());
    }

    public List<Record> getCurrentMonthOutcomeRecords() {
        return getRecordsByMonth(LocalDate.now(), getOutcomeRecords());
    }

    private List<Record> getRecordsByMonth(LocalDate date, List<Record> records) {
        List<Record> filteredRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.getDate().getMonth().equals(date.getMonth())) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }

    private List<Record> getRecordsByType(RecordType recordType) {
        List<Record> records = getAll();
        List<Record> incomeRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getCategory().getRecordType().equals(recordType)) {
                incomeRecords.add(record);
            }
        }
        return incomeRecords;
    }

    private void sortRecordsDESC(List<Record> records) {
        records.sort(Comparator.comparingDouble(Record::getAmount).reversed());
    }
}
