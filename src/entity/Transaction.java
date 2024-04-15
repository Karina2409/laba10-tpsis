package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public void flagForReview() {

    }
}
