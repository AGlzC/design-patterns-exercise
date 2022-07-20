package oop.inheritance.data.terminals.Verifone.v690;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.vx690.VerifoneVx690CardSwipper;

public class CardSwipper implements CardReader {
    private static CardSwipper cardSwipperInstance = null;

    private static VerifoneVx690CardSwipper reader;

    private CardSwipper() { reader = new VerifoneVx690CardSwipper(); }


    public static CardSwipper getInstance(){
        if (cardSwipperInstance == null){
            synchronized (CardSwipper.class){
                if (cardSwipperInstance == null){
                    cardSwipperInstance = new CardSwipper();
                }
            }
        }
        return cardSwipperInstance;
    }

    @Override
    public GenericCard readCard() {
        return new GenericCard(reader.readCard());
    }
}
