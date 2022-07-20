package oop.inheritance.data.terminals.Verifone.v520;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.vx520.VerifoneVx520ChipReader;

public class ChipReader implements CardReader {

    private static ChipReader chipReaderInstance = null;

    private static VerifoneVx520ChipReader reader;

    private ChipReader() { reader = new VerifoneVx520ChipReader(); }

    public static ChipReader getInstance(){
        if (chipReaderInstance == null){
            synchronized (ChipReader.class){
                if (chipReaderInstance == null){
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
