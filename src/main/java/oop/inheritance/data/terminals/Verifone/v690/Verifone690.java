package oop.inheritance.data.terminals.Verifone.v690;

import oop.inheritance.data.interfaces.CardProvider;
import oop.inheritance.data.interfaces.Communication;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.interfaces.Terminal;

public class Verifone690 implements Terminal {

    @Override
    public Display getDisplay() {
        return Display.getInstance();
    }

    @Override
    public Keyboard getKeyboard() {
        return Keyboard.getInstance();
    }

    @Override
    public Printer getPrinter() {
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
        return new Verifone690CardProvider();
    }

}
