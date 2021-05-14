package ui;

import entity.Category;
import entity.Record;
import service.CategoryService;
import service.RecordService;

import java.util.List;
import java.util.Scanner;

public class CmdInterface {


    Scanner scanner = new Scanner(System.in);//DEL SITO GALI KILT PROBLEMU!!!!!

    public void start() {
        RecordService recordService = new RecordService();
        boolean run = true;
        while (run) {
            mainMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    recordService.save(arrangeOutcomeRecordFromUser());
                    break;
                case 2:
                    recordService.save(arrangeIncomeRecordFromUser());
                    break;
                case 3:
                    viewData();
                    break;
                case 4:
                    run = false;
                default:
                    break;
            }
        }
    }

    private void viewData() {
        RecordService recordService = new RecordService();
        System.out.println("1.Rodyti visas islaidas\n" +
                "2.Rodyti visas pajamas\n" +
                "3.Rodyti sio menesio islaidas\n" +
                "4.Rodyti sio menesio pajamas\n" +
                "5.Rodyti 5 didziausias islaidas\n" +
                "6.Gristi atgal");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                recordService.getOutcomeRecords().forEach(record -> System.out.println(record.toString()));
                break;
            case 2:
                recordService.getIncomeRecords().forEach(record -> System.out.println(record.toString()));
                break;
            case 3:
                recordService.getCurrentMonthOutcomeRecords().forEach(record -> System.out.println(record.toString()));
                break;
            case 4:
                recordService.getCurrentMonthIncomeRecords().forEach(record -> System.out.println(record.toString()));
                break;
            case 5:
                recordService.getTopFiveOutcomeRecords().forEach(record -> System.out.println(record.toString()));
                break;
            case 6:
                break;
            default:
                viewData();//CIA GALI KILTI PROBLEMU
                break;
        }
    }

    private void mainMenu() {
        System.out.println("\nPasirinkite ivesti" +
                "\n1. Ivesti islaidas" +
                "\n2.Ivesti pajamas" +
                "\n3.Perziureti duomenis" +
                "\n4.Baigti darba");
    }

    public Record arrangeIncomeRecordFromUser() {
        return formRecordFromUser(true);
    }

    public Record arrangeOutcomeRecordFromUser() {
        return formRecordFromUser(false);
    }


    private double getAmountFromUser() {
        System.out.println("Iveskite suma:");
        return scanner.nextDouble();
    }

    private <T extends Category> Category getCategoryFromUser(List<T> t) {
        System.out.println("Pasirinkite kategorija: ");
        for (int i = 0; i < t.size(); i++) {
            System.out.println((i + 1) + "." + t.get(i).getName());
        }
        return t.get(scanner.nextInt() - 1);
    }

    private Record formRecordFromUser(boolean isIncome) {
        CategoryService categoryService = new CategoryService();
        if (isIncome) {
            return new Record(getAmountFromUser(), getCategoryFromUser(categoryService.getIncomeCategories()));
        } else
            return new Record(getAmountFromUser(), getCategoryFromUser(categoryService.getOutcomeCategories()));
    }
}
