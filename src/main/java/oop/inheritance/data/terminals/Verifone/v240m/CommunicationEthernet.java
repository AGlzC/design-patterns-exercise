package oop.inheritance.data.terminals.Verifone.v240m;

import oop.inheritance.data.interfaces.Communication;
import oop.inheritance.data.terminals.Verifone.Converter;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.v240m.VerifoneV240mEthernet;

public class CommunicationEthernet implements Communication {

    private static CommunicationEthernet communicationEthernetInstance = null;

    private final VerifoneV240mEthernet ethernet;

    private final Converter converter = new Converter();

    private CommunicationEthernet(){
        ethernet = new VerifoneV240mEthernet();
    }

    public static CommunicationEthernet getInstance(){
        if (communicationEthernetInstance == null){
            synchronized (CommunicationEthernet.class){
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
        ethernet.send(converter.transactionToByteArray(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return converter.byteArrayToTransactionResponse(ethernet.receive());
    }

    @Override
    public void close() {
        ethernet.close();
    }
}
