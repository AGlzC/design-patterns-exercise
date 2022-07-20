package oop.inheritance.data.terminals.Verifone.v240m;

import oop.library.v240m.VerifoneV240mPrinter;

public class Printer implements oop.inheritance.data.interfaces.Printer {

    private static Printer printerInstance = null;
    private final VerifoneV240mPrinter printer;

    private Printer() {
        printer = new VerifoneV240mPrinter();
    }

    public static Printer getInstance() {
        if (printerInstance == null) {
            synchronized (Printer.class) {
                if (printerInstance == null) {
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
