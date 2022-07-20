package oop.inheritance.data.terminals.Ingenico;

import oop.library.ingenico.services.IngenicoPrinter;

public class Printer implements oop.inheritance.data.interfaces.Printer {

    private static Printer printerInstance = null;
    private final IngenicoPrinter printer;

    private Printer(){
        printer = new IngenicoPrinter();
    }

    public static Printer getInstance(){
        if (printerInstance == null){
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
