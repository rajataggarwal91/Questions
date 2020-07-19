/*
 * The Task:
 * Design a Deck of playing cards for use in making card games (e.g. Blackjack, Poker, etc).
 * The Deck class should be usable or extendable by people creating new card games.
 * It should have features of a real deck of cards, and be usable in any game.
 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import com.sun.tools.javac.util.Assert;

public class AppleInterview {

    public static void main(String[] args) {
        Card cardA = new Card("A","Spade");
        Card cardB = new Card("J","Spade");
        Card cardC = new Card("Q","Spade");
        Card cardD = new Card("K","Spade");

        Stack<Card> cards = new Stack<Card>();
        cards.push(cardA);
        cards.push(cardB);
        Deck deck = new Deck(cards);
        Assert.check(deck.getTopOfDeck().equals(cardB));
        Assert.check(deck.getTopOfDeck().equals(cardA));

        Assert.check(deck.putCardAtTop(cardA));
        Assert.check(deck.putCardAtTop(cardB));
        Assert.check(deck.putCardAtTop(cardC));
        Assert.check(deck.putCardAtTop(cardD));
        deck.shuffle();
        System.out.println(deck);
    }
}

/*
 * Definition of a Deck
 */
class Deck {
    Stack<Card> cards;

    Deck(Stack<Card> cards) {
        this.cards = cards;
    }

    public Card getTopOfDeck() {

        if (cards.size() == 0) {
            return null;
        }
        return cards.pop();
    }

    public Boolean putCardAtTop(Card card) {
        cards.push(card);
        return true;
    }

    public void shuffle() {
        List<Card> tempList = new ArrayList<>();
        int size = cards.size();
        for (int i = 0 ; i < size; i++) {
            tempList.add(cards.pop());
        }

        while (tempList.size() != 0) {
            size = tempList.size();
            int randomNumber = (int) Math.floor(Math.random() * (size - 1));
            cards.push(tempList.get(randomNumber));
            tempList.remove(randomNumber);
        }

    }

    @Override
    public String toString() {
        StringBuilder deckCards = new StringBuilder();
        for (Card card : cards) {
             deckCards.append(card.getCardName() + card.getSuite() + " ");
        }
        return deckCards.toString();
    }

}

class Card {
    String cardName;
    String suite;

    Card(String cardName, String suite) {
        this.cardName = cardName;
        this.suite = suite;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getSuite() {
        return this.suite;
    }

    public int compareTo(Card card, Comparator<Card> comparator) {
        return comparator.compare(this, card);
    }


}

class CustomComparator implements Comparator<Card> {
    private String cards[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    @Override
    public int compare(Card a, Card b) {
        return Integer.valueOf(Arrays.asList(cards).indexOf(a.getCardName())).compareTo(Integer.valueOf(Arrays.asList
        (cards).indexOf(b.getCardName())));
    }
}


