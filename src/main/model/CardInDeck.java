package model;

public class CardInDeck {
    private Card theCard;
    private int copies;

    public CardInDeck(Card card, int copies) {
        this.theCard = card;
        this.copies = copies;
    }

    //EFFECTS: return card in deck
    public Card getCard() {
        return theCard;
    }

    //MODIFIES: THIS
    //EFFECTS: Sets number of copies of card within deck
    public void setCopies(int copies) {
        this.copies = copies;
    }

    //EFFECTS: return copies of card within deck
    public int getCopies() {
        return copies;
    }

}
