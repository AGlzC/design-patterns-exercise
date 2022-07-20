package oop.inheritance.data.terminals.Verifone.v520;

import oop.library.vx520.VerifoneVx520Display;

public class Display implements oop.inheritance.data.interfaces.Display {

    private static Display displayInstance = null;

    private static VerifoneVx520Display display;

    private Display() { display = new VerifoneVx520Display(); }

    public static Display getInstance(){
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
        display.showMessage(text, x, y);
    }

    @Override
    public void clearScreen() {
        display.clear();
    }

}
