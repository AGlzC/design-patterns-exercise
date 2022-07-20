package oop.inheritance.data.terminals.Ingenico;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardReader;
import oop.library.ingenico.services.IngenicoCardSwipper;

public class CardSwipper implements CardReader {

    private static CardSwipper cardSwipperInstance = null;

    private final IngenicoCardSwipper reader;

    private CardSwipper() {
        reader = new IngenicoCardSwipper();
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
