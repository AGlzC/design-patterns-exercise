package oop.inheritance.data.terminals.Verifone.v690;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.vx690.VerifoneVx690ChipReader;

public class ChipReader implements CardReader {

    private static ChipReader chipReaderInstance = null;

    private static VerifoneVx690ChipReader reader;

    private ChipReader() { reader = new VerifoneVx690ChipReader(); }

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
