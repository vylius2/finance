package service;

import entity.Category;
import entity.Record;
import entity.RecordType;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceTest {

    Category categoryInc;
    Category categoryOut;

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

        categoryInc = new Category("TestasInc", RecordType.INCOME);
        categoryOut = new Category("TestasOut", RecordType.OUTCOME);

        records = new ArrayList<>();

        double amount = recordService.getTopFiveOutcomeRecords().get(0).getAmount();
        categoryService.save(categoryInc);
        categoryService.save(categoryOut);
        for (int i = 0; i < 5; i++) {

            Record record = new Record(amount + 20000 + i, categoryOut);

            recordService.save(record);
            records.add(record);
        }

    }

    @AfterEach
    public void afterEach(){
        for (Record record: records) {
            recordService.delete(record);
        }
        categoryService.delete(categoryInc);
        categoryService.delete(categoryOut);
    }


    @Test
    public void getByIdTest(){
        Record record = records.get(0);

        Assertions.assertEquals(recordService.getById(record.getId()).getId(), record.getId());
    }

    @Test
    public void deleteTest(){
        Record record = records.get(0);

        recordService.delete(record);
        Assertions.assertNull(recordService.getById(record.getId()));
    }

    @Test
    public void getTopFiveOutcomeRecordsTest(){
        List<Record> topFiveRecords = records;
        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(recordService.getTopFiveOutcomeRecords().get(i).getAmount(),
                    topFiveRecords.get(topFiveRecords.size() - 1 - i).getAmount(), 1);
        }
    }
}
