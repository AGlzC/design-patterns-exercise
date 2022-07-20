package oop.inheritance.data.terminals.Verifone.v520;

import oop.library.vx520.VerifoneVx520Keyboard;

public class Keyboard implements oop.inheritance.data.interfaces.Keyboard {

    private static Keyboard keyboardInstance = null;
    private static VerifoneVx520Keyboard keyboard;

    private Keyboard() { keyboard = new VerifoneVx520Keyboard(); }

    public static Keyboard getInstance(){
        if (keyboardInstance == null){
            synchronized (Keyboard.class){
                if (keyboardInstance == null){
                    keyboardInstance = new Keyboard();
                }
            }
        }
        return keyboardInstance;
    }

    @Override
    public String getChar() {
        return keyboard.get();
    }

    @Override
    public String readLine() {
        return null;
    }
}
