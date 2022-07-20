package oop.inheritance.data.terminals.Ingenico;

import oop.library.ingenico.services.IngenicoKeyboard;

public class Keyboard implements oop.inheritance.data.interfaces.Keyboard {

    private static Keyboard keyboardInstance= null;
    private final IngenicoKeyboard keyboard;

    private Keyboard() {
        keyboard = new IngenicoKeyboard();
    }

    public static Keyboard getInstance(){
        if (keyboardInstance == null) {
            synchronized (Keyboard.class) {
                if (keyboardInstance == null) {
                    keyboardInstance = new Keyboard();
                }
            }
        }
        return  keyboardInstance;
    }

    @Override
    public String getChar() {
        return keyboard.getChar();
    }

    @Override
    public String readLine() {
        return keyboard.readLine();
    }
}
