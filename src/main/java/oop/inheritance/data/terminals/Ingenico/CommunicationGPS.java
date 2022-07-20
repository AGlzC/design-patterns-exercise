package oop.inheritance.data.terminals.Ingenico;

import oop.inheritance.data.interfaces.Communication;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoGPS;

public class CommunicationGPS implements Communication {

    private static CommunicationGPS communicationGPSInstance = null;

    private final IngenicoGPS gps;

    private CommunicationGPS(){
        gps = new IngenicoGPS();
    }

    public static CommunicationGPS getInstance() {
        if (communicationGPSInstance == null) {
            synchronized (CommunicationGPS.class) {
                if (communicationGPSInstance == null) {
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
        gps.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return gps.receive();
    }

    @Override
    public void close() {
        gps.close();
    }
}
