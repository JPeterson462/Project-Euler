package com.digiturtle.projects.day4;

import java.util.Arrays;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project54 implements BasicProject {
	
	public static void main(String[] args) {
		new Project54().run();
	}
	
	public class Card implements Comparable<Card> {
		
		public char suit, id;
		
		public int index;
		
		public Card(char suit, char id) {
			this.suit = suit;
			this.id = id;
			index = getIndex();
		}
		
		private int getIndex() {
			switch (id) {
				case 'J':
					return 11;
				case 'Q':
					return 12;
				case 'K':
					return 13;
				case 'A': 
					return 14;
				case 'T':
					return 10;
				default:
					return Integer.parseInt("" + id);
			}
		}
		
		public String toString() {
			return new String(new char[] { id, suit });
		}

		@Override
		public int compareTo(Card c) {
			return Integer.compare(index, c.index);
		}
		
	}
	
	public class Hand {
		
		public Card[] cards;
		
		public Hand(String[] cardValues) {
			cards = new Card[cardValues.length];
			for (int i = 0; i < cards.length; i++) {
				cards[i] = new Card(cardValues[i].charAt(1), cardValues[i].charAt(0));
			}
			Arrays.sort(cards);
		}
		
		public boolean isFlush() {
			char suit = cards[0].suit;
			for (int i = 0; i < cards.length; i++) {
				if (cards[i].suit != suit) {
					return false;
				}
			}
			return true;
		}
		
		public boolean isStraight() {
			int index = cards[0].index;
			for (int i = 1; i < cards.length; i++) {
				if (cards[i].index - index != 1) {
					return false;
				}
				index = cards[i].index;
			}
			return true;
		}
		
		public String toString() {
			return Arrays.toString(cards);
		}
		
	}
	
	public class Choice {
		
		public int index;
		
		public Card[] cards;
		
		public Choice(Card[] cards, int index) {
			 this.cards = cards;
			 this.index = index;
			 Arrays.sort(cards);
		}
		
		public String toString() {
			return Arrays.toString(cards) + ":" + index;
		}
		
	}
	
	public Hand[] parseHands(String line) {
		String[] parts = line.split(" ");
		Hand[] hands = new Hand[2];
		hands[0] = new Hand(new String[] { parts[0], parts[1], parts[2], parts[3], parts[4] });
		hands[1] = new Hand(new String[] { parts[5], parts[6], parts[7], parts[8], parts[9] });
		return hands;
	}
	
	public Choice getBestChoice(Hand hand) {
		if (hand.isFlush() && hand.isStraight() && hand.cards[0].index == 10) {
			return new Choice(hand.cards, 10);
		}
		if (hand.isFlush() && hand.isStraight()) {
			return new Choice(hand.cards, 9);
		}
		if (hand.cards[1].id == hand.cards[2].id && hand.cards[2].id == hand.cards[3].id) {
			if (hand.cards[0].id == hand.cards[1].id) {
				return new Choice(new Card[] { hand.cards[0], hand.cards[1], hand.cards[2], hand.cards[3] }, 8);
			}
			if (hand.cards[3].id == hand.cards[4].id) {
				return new Choice(new Card[] { hand.cards[1], hand.cards[2], hand.cards[3], hand.cards[4] }, 8);
			}
		}
		{
			if (hand.cards[0].id == hand.cards[1].id && hand.cards[2].id == hand.cards[3].id && hand.cards[3].id == hand.cards[4].id) {
				return new Choice(hand.cards, 7);
			}
			if (hand.cards[3].id == hand.cards[4].id && hand.cards[0].id == hand.cards[1].id && hand.cards[1].id == hand.cards[2].id) {
				return new Choice(hand.cards, 7);
			}
		}
		if (hand.isFlush()) {
			return new Choice(hand.cards, 6);
		}
		if (hand.isStraight()) {
			return new Choice(hand.cards, 5);
		}
		{
			if (hand.cards[0].id == hand.cards[1].id && hand.cards[1].id == hand.cards[2].id) {
				return new Choice(new Card[] { hand.cards[0], hand.cards[1], hand.cards[2] }, 4);
			}
			if (hand.cards[1].id == hand.cards[2].id && hand.cards[2].id == hand.cards[3].id) {
				return new Choice(new Card[] { hand.cards[1], hand.cards[2], hand.cards[3] }, 4);
			}
			if (hand.cards[2].id == hand.cards[3].id && hand.cards[3].id == hand.cards[4].id) {
				return new Choice(new Card[] { hand.cards[2], hand.cards[3], hand.cards[4] }, 4);
			}
		}
		{
			if (hand.cards[0].id == hand.cards[1].id && hand.cards[2].id == hand.cards[3].id) {
				return new Choice(new Card[] { hand.cards[0], hand.cards[1], hand.cards[2], hand.cards[3] }, 3);
			}
			if (hand.cards[0].id == hand.cards[1].id && hand.cards[3].id == hand.cards[4].id) {
				return new Choice(new Card[] { hand.cards[0], hand.cards[1], hand.cards[3], hand.cards[4] }, 3);
			}
			if (hand.cards[1].id == hand.cards[2].id && hand.cards[3].id == hand.cards[4].id) {
				return new Choice(new Card[] { hand.cards[1], hand.cards[2], hand.cards[3], hand.cards[4] }, 3);
			}
			
		}
		{
			if (hand.cards[0].id == hand.cards[1].id) {
				return new Choice(new Card[] { hand.cards[0], hand.cards[1] }, 2);
			}
			if (hand.cards[1].id == hand.cards[2].id) {
				return new Choice(new Card[] { hand.cards[1], hand.cards[2] }, 2);
			}
			if (hand.cards[2].id == hand.cards[3].id) {
				return new Choice(new Card[] { hand.cards[2], hand.cards[3] }, 2);
			}
			if (hand.cards[3].id == hand.cards[4].id) {
				return new Choice(new Card[] { hand.cards[3], hand.cards[4] }, 2);
			}
		}
		return new Choice(new Card[] { hand.cards[4], hand.cards[3], hand.cards[2], hand.cards[1], hand.cards[0] }, 1);
	}
	
	public boolean doesPlayerOneWin(Hand[] hands) {
		Choice c1 = getBestChoice(hands[0]), c2 = getBestChoice(hands[1]);
		if (c1.index > c2.index) {
			return true;
		}
		else if (c2.index > c1.index) {
			return false;
		}
		else {
			Card p1 = c1.cards[c1.cards.length - 1];
			Card p2 = c2.cards[c2.cards.length - 1];
			if (p1.index > p2.index) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void run() {
		String[] lines = Utils.readFile("poker.txt");
		int playerOne = 0, playerTwo = 0;
		for (String line : lines) {
			Hand[] hands = parseHands(line);
			if (doesPlayerOneWin(hands)) {
				playerOne++;
			} else {
				playerTwo++;
			}
		}
		System.out.println("Player One: " + playerOne + ". Player two: " + playerTwo);
	}

}
