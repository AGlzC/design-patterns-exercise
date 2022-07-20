package oop.inheritance.data.terminals.Verifone.v690;

import oop.inheritance.data.interfaces.Communication;
import oop.inheritance.data.terminals.Verifone.Converter;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.vx690.VerifoneVx690GPS;

public class CommunicationGPS implements Communication {

    private static CommunicationGPS communicationGPSInstance = null;

    private static VerifoneVx690GPS gps;

    private final Converter converter = new Converter();

    private CommunicationGPS() { gps = new VerifoneVx690GPS(); }

    public static CommunicationGPS getInstance(){
        if (communicationGPSInstance == null){
            synchronized (CommunicationGPS.class){
                if (communicationGPSInstance == null){
                    communicationGPSInstance = new CommunicationGPS();
                }
            }
        }
        return communicationGPSInstance;
    }

    @Override
    public void open() {
        gps.open();
    }

    @Override
    public void send(Transaction transaction) {
        gps.send(converter.transactionToByteArray(transaction));
    }

    @Override
    public TransactionResponse receive() {
        return converter.byteArrayToTransactionResponse(gps.receive());
    }

    @Override
    public void close() {
        gps.close();
    }
}
