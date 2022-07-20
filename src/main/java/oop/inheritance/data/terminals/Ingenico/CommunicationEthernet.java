package oop.inheritance.data.terminals.Ingenico;

import oop.inheritance.data.interfaces.Communication;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoEthernet;

public class CommunicationEthernet implements Communication {

    private static CommunicationEthernet communicationEthernetInstance = null;

    private final IngenicoEthernet ethernet;

    private CommunicationEthernet(){
        ethernet = new IngenicoEthernet();
    }

    public  static CommunicationEthernet getInstance(){
        if (communicationEthernetInstance == null){
            synchronized (CommunicationEthernet.class) {
                if (communicationEthernetInstance == null) {
                    communicationEthernetInstance = new CommunicationEthernet();
                }
            }
        }
        return communicationEthernetInstance;
    }

    @Override
    public void open() {
        ethernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        ethernet.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return ethernet.receive();
    }

    @Override
    public void close() {
        ethernet.close();
    }
}
