package oop.inheritance.data.terminals.Verifone.v240m;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.v240m.VerifoneV240mChipReader;

public class ChipReader implements CardReader {

    private static ChipReader chipReaderInstance = null;

    private final VerifoneV240mChipReader reader;

    private ChipReader(){
        reader = new VerifoneV240mChipReader();
    }

    public static ChipReader getInstance(){
        if (chipReaderInstance == null){
            synchronized (ChipReader.class){
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
