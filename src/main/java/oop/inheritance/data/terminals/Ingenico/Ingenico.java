package oop.inheritance.data.terminals.Ingenico;

import oop.inheritance.data.*;
import oop.inheritance.data.interfaces.CardProvider;
import oop.inheritance.data.interfaces.Communication;
import oop.inheritance.data.interfaces.Terminal;

public class Ingenico implements Terminal {

    @Override
    public oop.inheritance.data.interfaces.Display getDisplay() { return Display.getInstance(); }

    @Override
    public oop.inheritance.data.interfaces.Keyboard getKeyboard() {
        return Keyboard.getInstance();
    }

    @Override
    public oop.inheritance.data.interfaces.Printer getPrinter() {
        return Printer.getInstance();
    }

    @Override
    public Communication getCommunication(CommunicationType communicationType) {
        if (communicationType == CommunicationType.ETHERNET) {
            return CommunicationEthernet.getInstance();
        } else if (communicationType == CommunicationType.MODEM) {
            return CommunicationModem.getInstance();
        } else if (communicationType == CommunicationType.GPS) {
            return CommunicationGPS.getInstance();
        }
        return null;
    }

    @Override
    public CardProvider getCardProvider() {
        return new IngenicoCardProvider();
    }

}
