package oop.inheritance.data.terminals.Verifone.v520;

import oop.inheritance.data.card.GenericCard;
import oop.inheritance.data.interfaces.CardConsumer;
import oop.inheritance.data.interfaces.CardProvider;

public class Verifone520CardProvider implements CardProvider {

    private final CardSwipper cardSwipper = CardSwipper.getInstance();

    private final ChipReader chipReader = ChipReader.getInstance();

    @Override
    public void readCard(CardConsumer cardConsumer) {
        GenericCard card;
        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        cardConsumer.consumeCard(card);
    }
}
