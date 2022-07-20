package oop.inheritance.data.terminals.Verifone.v240m;

import oop.library.v240m.VerifoneV240mDisplay;

public class Display implements oop.inheritance.data.interfaces.Display {

    private static Display displayInstance = null;
    private final VerifoneV240mDisplay display;

    private Display() {
        display = new VerifoneV240mDisplay();
    }

    public static Display getInstance() {
        if (displayInstance == null) {
            synchronized (oop.inheritance.data.terminals.Ingenico.Display.class) {
                if (displayInstance == null) {
                    displayInstance = new Display();
                }
            }
        }
        return displayInstance;
    }

    @Override
    public void displayText(int x, int y, String text) {
        display.print(x, y, text);
    }

    @Override
    public void clearScreen() {
        display.clear();
    }

}
