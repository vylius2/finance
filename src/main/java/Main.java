import entity.Category;
import entity.Record;
import entity.RecordType;
import service.CategoryService;
import service.RecordService;
import ui.CmdInterface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CmdInterface cmdInterface = new CmdInterface();
        //cmdInterface.start();



        RecordService recordService = new RecordService();
        CategoryService categoryService = new CategoryService();

        categoryService.getAll().forEach();

//        Category category = new Category("TransportasTest", RecordType.OUTCOME);
//        Record record = new Record(recordService.getTopFiveOutcomeRecords().get(0).getAmount() + 20000 + 1,
//                categoryService.getAll().get(1));

        System.out.println(categoryService.getAll().get(1).toString());
//        System.out.println(record.toString() + "\n" +record.getCategory().toString());
    }
}
