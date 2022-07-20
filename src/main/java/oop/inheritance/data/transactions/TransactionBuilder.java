package oop.inheritance.data.transactions;

import oop.inheritance.data.card.GenericCard;
import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public class TransactionBuilder {

    private int cents;
    private GenericCard card;
    private LocalDateTime datetime;

    private final Transaction transaction = new Transaction();

    public TransactionBuilder amountInCents(int cents) {
        transaction.setAmountInCents(cents);
        return this;
    }

    public TransactionBuilder algocard(GenericCard card) {
        transaction.setCard(card.getIngenicoCard());
        return this;
    }

    public TransactionBuilder localDateTime(LocalDateTime dateTime) {
        transaction.setLocalDateTime(dateTime);
        return this;
    }

    public Transaction build() {
        return transaction;
    }
}
