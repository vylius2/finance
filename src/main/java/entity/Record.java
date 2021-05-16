package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    private Category category;


    public Record() {
    }

    public Record(double amount, Category category) {
        this.amount = amount;
        this.date = LocalDate.now();
        this.category = category;
    }

    public Record(double amount, Category categoryId, LocalDate date) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Long categoryId) {
        this.category = category;
    }

    @Override
    public String toString() {

        return "id: " + id +
                ", amount: " + amount +
                ", date: " + date.toString() +
                ", category: " + category.getName() +
                ", record type: " + category.getRecordType().toString();
    }


}
