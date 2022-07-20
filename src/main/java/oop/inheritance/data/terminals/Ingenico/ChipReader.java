package oop.inheritance.data.terminals.Ingenico;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.ingenico.services.IngenicoChipReader;

public class ChipReader implements CardReader {

    private static ChipReader chipReaderInstance= null;

    private final IngenicoChipReader reader;

    private ChipReader(){
        reader = new IngenicoChipReader();
    }

    public static ChipReader getInstance(){
        if (chipReaderInstance == null){
            synchronized (ChipReader.class) {
                if (chipReaderInstance == null) {
                    chipReaderInstance = new ChipReader();
                }
            }
        }
        return chipReaderInstance;
    }
    @Override
    public GenericCard readCard() {
        return new GenericCard(reader.readCard());
    }
}
