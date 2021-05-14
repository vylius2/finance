package service;

import entity.Category;
import entity.Record;
import entity.RecordType;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceTest {

    private RecordService recordService;

    private CategoryService categoryService;

    private List<Record> records;


    @BeforeAll
    static void beforeAll(){
        HibernateConfig.buildSessionFactory();
    }

    @AfterAll
    static void afterAll(){
        HibernateConfig.closeSessionFactory();
    }

    @BeforeEach
    public void setUp(){
        recordService = new RecordService();
        categoryService = new CategoryService();
        records = new ArrayList<>();
        double amount = recordService.getTopFiveOutcomeRecords().get(0).getAmount();
        for (int i = 0; i < 5; i++) {

            Record record = new Record(amount + 20000 + i,
                    categoryService.getAll().get(1));// cia pasidaryt atskirai category

            recordService.save(record);
            records.add(record);
        }

    }

    @AfterEach
    public void afterEach(){
        //assert ar tikrai padelitinta
        for (Record record: records) {
            recordService.deleteRecord(record);
        }
        //assertNull
    }

    @Test
    public void getTopFiveOutcomeRecordsTest(){
        List<Record> topFiveRecords = records;//cia gali reikt vietoj 9 rasyt 10
        Assert.assertEquals(recordService.getTopFiveOutcomeRecords().get(i).getAmount(),
                topFiveRecords.get(topFiveRecords.size() - 1 - i).getAmount(), 1);
    }
}
