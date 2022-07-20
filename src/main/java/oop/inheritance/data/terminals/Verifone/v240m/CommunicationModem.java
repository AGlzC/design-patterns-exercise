package oop.inheritance.data.terminals.Verifone.v240m;

import oop.inheritance.data.interfaces.Communication;
import oop.inheritance.data.terminals.Verifone.Converter;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

import oop.library.vx520.VerifoneVx520Modem;

public class CommunicationModem implements Communication {

    private static CommunicationModem communicationModemInstance = null;

    private final VerifoneVx520Modem modem;

    private final Converter converter = new Converter();

    private CommunicationModem(){
        modem = new VerifoneVx520Modem();
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
    public void send(Transaction transaction){
        modem.send(converter.transactionToByteArray(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return converter.byteArrayToTransactionResponse(modem.receive());
    }

    @Override
    public void close() {
        modem.close();
    }
}
