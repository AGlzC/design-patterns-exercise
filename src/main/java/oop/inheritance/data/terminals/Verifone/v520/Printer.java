package oop.inheritance.data.terminals.Verifone.v520;

import oop.library.vx520.VerifoneVx520Printer;

public class Printer implements oop.inheritance.data.interfaces.Printer {

    private static Printer printerInstance= null;

    private static VerifoneVx520Printer printer;

    private Printer() { printer = new VerifoneVx520Printer(); }

    public static Printer getInstance(){
        if (printerInstance == null){
            synchronized (Printer.class){
                if (printerInstance == null){
                    printerInstance = new Printer();
                }
            }
        }
        return printerInstance;
    }

    @Override
    public void printText(int x, String text) {
        printer.print(x, text);
    }

    @Override
    public void lineFeed() {
        printer.lineFeed();
    }
}
