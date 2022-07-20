package oop.inheritance;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.*;
import oop.inheritance.data.terminals.TerminalFactory;
import oop.inheritance.data.transactions.TransactionBuilder;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

import java.time.LocalDateTime;

public class Application {

    private final CommunicationType communicationType = CommunicationType.ETHERNET;

    private final Terminal terminal;

    public Application(SupportedTerminal supportedTerminal) {
        terminal = TerminalFactory.getInstance(supportedTerminal);
    }

    public void showMenu() {
        Display display = terminal.getDisplay();

        display.displayText(5, 5, "MENU");
        display.displayText(5, 10, "1. VENTA");
        display.displayText(5, 13, "2. DEVOLUCION");
        display.displayText(5, 16, "3. REPORTE");
        display.displayText(5, 23, "4. CONFIGURACION");
    }

    public String readKey() {
        return terminal.getKeyboard().getChar();
    }

    public void doSale() {
        Display display = terminal.getDisplay();
        Keyboard keyboard = terminal.getKeyboard();

        CardProvider cardProvider = terminal.getCardProvider();

        CardConsumer cardConsumer = new CardConsumer() {
            @Override
            public void consumeCard(GenericCard card) {
                display.clearScreen();
                display.displayText(5, 20, "Capture monto:");

                String amount = keyboard.readLine(); //Amount with decimal point as string

                Transaction transaction = new TransactionBuilder()
                        .localDateTime(LocalDateTime.now())
                        .algocard(card)
                        .amountInCents(Integer.parseInt(amount.replace(".", "")))
                        .build();

                TransactionResponse response = sendSale(transaction);

                if (response.isApproved()) {
                    display.displayText(5, 20, "APROBADA");
                    printReceipt(transaction, response.getHostReference());
                } else {
                    display.displayText(5, 20, "DENEGADA");
                }

            }
        };
        cardProvider.readCard(cardConsumer);

        cardProvider = card -> {
            GenericCard genericCard = null;
            display.clearScreen();
            display.displayText(5, 20, "Capture monto:");

            String amount = keyboard.readLine(); //Amount with decimal point as string

            Transaction transaction = new TransactionBuilder()
                    .localDateTime(LocalDateTime.now())
                    .algocard(genericCard)
                    .amountInCents(Integer.parseInt(amount.replace(".", "")))
                    .build();

            TransactionResponse response = sendSale(transaction);

            if (response.isApproved()) {
                display.displayText(5, 20, "APROBADA");
                printReceipt(transaction, response.getHostReference());
            } else {
                display.displayText(5, 20, "DENEGADA");
            }
        };
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        Card card = transaction.getCard();
        Printer printer = terminal.getPrinter();

        printer.printText(5, "APROBADA");
        printer.lineFeed();
        printer.printText(5, card.getAccount());
        printer.lineFeed();
        printer.printText(5, "" + transaction.getAmountInCents());
        printer.lineFeed();
        printer.printText(5, "________________");
    }

    private TransactionResponse sendSale(Transaction transaction) {
        Communication communication = terminal.getCommunication(communicationType);

        communication.open();
        communication.send(transaction);
        TransactionResponse transactionResponse = communication.receive();
        communication.close();
        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        terminal.getDisplay().clearScreen();
    }
}
