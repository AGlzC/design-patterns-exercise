package oop.inheritance.data.terminals.Ingenico;

import oop.library.ingenico.services.IngenicoDisplay;

public class Display implements oop.inheritance.data.interfaces.Display {

    private static Display displayInstance = null;
    private final IngenicoDisplay display;

    private Display() {
        display = new IngenicoDisplay();
    }

    public static Display getInstance() {
        if (displayInstance == null) {
            synchronized (Display.class) {
                if (displayInstance == null){
                    displayInstance = new Display();
                }
            }
        }
        return displayInstance;
    }

    @Override
    public void displayText(int x, int y, String text) {
        display.showMessage(x, y, text);
    }

    @Override
    public void clearScreen() {
        display.clear();
    }
}
