package oop.inheritance.data.terminals.Verifone.v240m;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;

import oop.library.v240m.VerifoneV240mCardSwipper;

public class CardSwipper implements CardReader {

    private static CardSwipper cardSwipperInstance = null;

    private final VerifoneV240mCardSwipper reader;

    private CardSwipper() {
        reader = new VerifoneV240mCardSwipper();
    }

    public static CardSwipper getInstance(){
        if (cardSwipperInstance == null){
            synchronized(CardSwipper.class) {
                if (cardSwipperInstance == null) {
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
