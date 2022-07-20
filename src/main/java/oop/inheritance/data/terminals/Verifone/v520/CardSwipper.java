package oop.inheritance.data.terminals.Verifone.v520;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.vx520.VerifoneVx520CardSwipper;

public class CardSwipper implements CardReader {

    private static  CardSwipper cardSwipperInstance = null;
    private final VerifoneVx520CardSwipper reader;

    private CardSwipper(){
        reader = new VerifoneVx520CardSwipper();
    }

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
