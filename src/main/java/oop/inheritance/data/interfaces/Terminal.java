package oop.inheritance.data.interfaces;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.interfaces.*;

public interface Terminal {

    Display getDisplay();

    Keyboard getKeyboard();

    Printer getPrinter();

    Communication getCommunication(CommunicationType communicationType);

    CardProvider getCardProvider();
}
