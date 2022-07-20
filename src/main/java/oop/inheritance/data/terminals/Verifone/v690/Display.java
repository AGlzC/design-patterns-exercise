package oop.inheritance.data.terminals.Verifone.v690;

import oop.library.vx690.VerifoneVx690Display;

public class Display implements oop.inheritance.data.interfaces.Display {

    private static Display displayInstance = null;

    private static VerifoneVx690Display display;

    private Display() { display = new VerifoneVx690Display(); }

    public static Display getInstance() {
        if (displayInstance == null){
            synchronized (Display.class){
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
