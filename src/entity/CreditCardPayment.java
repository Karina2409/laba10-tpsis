package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "card-payment")
class CreditCardPayment extends Transaction {
    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount, "CREDIT_CARD");
        this.cardNumber = cardNumber;
    }

    @Override
    public void flagForReview() {
    }
}