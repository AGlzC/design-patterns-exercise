package oop.inheritance.data.interfaces;

import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public interface Builder {

    void setAmount(int cents);

    void setCard(Card card);

    void setDateTime(LocalDateTime dateTime);

    void setTransaction(Transaction transaction);
}
