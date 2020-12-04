package com.solution;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class S2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        S2 s = new S2();
        Card c1 = new Card(1, 0, 1, 1);
        Card c2 = new Card(0, 0, 0, 1);
        Card c3 = new Card(0, 0, 2, 1);
        System.out.println(s.isCardsSetExisted(new Card[]{c1, c2, c3}));
    }

    public boolean isCardsSetExisted(Card[] cards) {
        Set<Card> set = new HashSet();
        set.add(cards[0]);
        for(int i=1; i<cards.length; i++) {
            for(int j=i+1; j<cards.length; j++) {
                if(set.contains(new Card(cards[i], cards[j]))) {
                    return true;
                }
            }
            set.add(cards[i]);
        }
        return false;
    }
}

class Card {
    int[] att;

    public Card(int color, int count, int shading, int shape) {
        this.att = new int[4];
        this.att[0] = color;
        this.att[1] = count;
        this.att[2] = shading;
        this.att[3] = shape;
    }

    public Card(Card card1, Card card2) {
        this.att = new int[8];
        for(int i=0; i<4; i++) {
            this.att[i] = card1.att[i];
            this.att[i+4] = card2.att[i];
        }
    }

    public int hashCode() {
        return 1;
    }

    //for set.contains, this is the new object, other is the object in set
    public boolean equals(Object obj) {
        Card other = (Card) obj;
        if(this.att.length != 8) return false;
        Card c1 = new Card(this.att[0], this.att[1], this.att[2], this.att[3]);
        Card c2 = new Card(this.att[4], this.att[5], this.att[6], this.att[7]);
        return areCardsOneSet(c1, c2, other);
    }

    private boolean areCardsOneSet(Card c1, Card c2, Card c3) {
        for(int i=0; i<4; i++) {
            if(!isThreeAttSame(c1.att[i], c2.att[i], c3.att[i]) &&
                    !isTreeAttDiff(c1.att[i], c2.att[i], c3.att[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isThreeAttSame(int a1, int a2, int a3) {
        return a1 == a2 && a1 == a3 && a2 == a3;
    }

    private boolean isTreeAttDiff(int a1, int a2, int a3) {
        return a1 != a2 && a1 != a3 && a2 != a3;
    }
}


