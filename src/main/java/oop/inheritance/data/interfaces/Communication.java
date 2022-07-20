package oop.inheritance.data.interfaces;

import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

public interface Communication {

    void open();

    void send(Transaction transaction);

    TransactionResponse receive();

    void close();
}
