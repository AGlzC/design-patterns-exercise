package oop.inheritance.data.terminals.Verifone.v240m;

import oop.library.v240m.VerifoneV240mKeyboard;

public class Keyboard implements oop.inheritance.data.interfaces.Keyboard {

    private static Keyboard keyboardInstance = null;
    private final VerifoneV240mKeyboard keyboard;

    private Keyboard() {
        keyboard = new VerifoneV240mKeyboard();
    }

    public static Keyboard getInstance() {
        if (keyboardInstance == null) {
            synchronized (Keyboard.class) {
                if (keyboardInstance == null) {
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
