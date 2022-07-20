package oop.inheritance.data.terminals.Ingenico;

import oop.inheritance.data.interfaces.Communication;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoModem;

public class CommunicationModem implements Communication {

    private static CommunicationModem communicationModemInstance = null;

    private final IngenicoModem modem;

    private CommunicationModem(){
        modem = new IngenicoModem();
    }

    public static CommunicationModem getInstance(){
        if (communicationModemInstance == null){
            synchronized (CommunicationModem.class){
                if (communicationModemInstance == null) {
                    communicationModemInstance = new CommunicationModem();
                }
            }
        }
        return communicationModemInstance;
    }
    @Override
    public void open() {
        modem.open();
    }

    @Override
    public void send(Transaction transaction) {
        modem.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return modem.receive();
    }

    @Override
    public void close() {
        modem.close();
    }
}
