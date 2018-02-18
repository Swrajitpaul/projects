/**
 * Author: Swrajit Paul
 * Project: CS 381 poker hand - 1 million 5 card hand result
 * 
 * Description - an array with 52 elements is created to represent a full deck. The deck is segmented into four equal parts in order to 
 * represent the four suits. for example array indices 0 to 12 is filled with its respective index number and represents spades. A while 
 * loop is called a million times to get million different attempts. Then the deck is shuffled and top five cards are picked. From there,
 * four for loops checks the five cards to see which suit the are.
 */
import java.util.*;

public class pokerHand {

	public static int twoPair = 0;
	
	public static int fourOfAKind = 0;
	
	
	public static void main(String[] args) {
		
		
		int [] fullDeck = new int[52];

		// 0-12 represents spades, 13-25 represents hearts, 26-38 represents diamonds, 39-51 represents clubs

		int numberOfHands = 0;
		
		while (numberOfHands < 1000000) {
			
			for(int i = 0; i < fullDeck.length; i++) {
			
				fullDeck[i] = i; // populate the array of 52 with numbers 0 to 51
		
			}
		
			fullDeck = shuffle(fullDeck);
		
			int[] fiveCardsOnHand = new int[5];
			
			for (int i = 0; i < 5; i++) {
				
				fiveCardsOnHand[i] = fullDeck[i];
			}
		
			int numberOfCardsSpades = 0;
			int numberOfCardsHearts = 0;
			int numberOfCardsDiamonds = 0;
			int numberOfCardsClubs = 0;
			
			for (int i = 0; i < fiveCardsOnHand.length; i++) {
				
				if (numberOfCardsSpades == 4 || numberOfCardsHearts == 4 || numberOfCardsDiamonds == 4 || numberOfCardsClubs == 4) {
					fourOfAKind++;
					break;
				}
				
				if (numberOfCardsSpades == 2 && (numberOfCardsHearts == 2 || numberOfCardsDiamonds == 2 || numberOfCardsClubs == 2)) {
					twoPair++;
					break;
				}
				
				if (numberOfCardsHearts == 2 && (numberOfCardsSpades == 2 || numberOfCardsDiamonds == 2 || numberOfCardsClubs == 2)) {
					twoPair++;
					break;
				}
				
				if (numberOfCardsDiamonds == 2 && (numberOfCardsHearts == 2 || numberOfCardsSpades == 2 || numberOfCardsClubs == 2)) {
					twoPair++;
					break;
				}
				
				if (numberOfCardsClubs == 2 && (numberOfCardsHearts == 2 || numberOfCardsDiamonds == 2 || numberOfCardsSpades == 2)) {
					twoPair++;
					break;
				}
				
				for (int j = 0; j < 13; j++) {
					
					if(fiveCardsOnHand[i] == j) {
					
						numberOfCardsSpades++;
					
						break;
					}
				}
				
				for (int j = 13; j < 26; j++) {
					
					if(fiveCardsOnHand[i] == j) {
						
						numberOfCardsHearts++;
					
						break;
					}
				}

				for (int j = 36; j < 39; j++) {
					
					if(fiveCardsOnHand[i] == j) {
						
						numberOfCardsDiamonds++;
					
						break;
					}
				}

				for (int j = 39; j < 52; j++) {
					
					if(fiveCardsOnHand[i] == j) {
						
						numberOfCardsClubs++;
					
						break;
					}
				}
				
				
			}
			
			numberOfHands++;
		}
		
		System.out.println("The final result for 1 million 5 card hand is: ");
		
		System.out.println("Number of two pairs: " + twoPair + "  or  " + ((twoPair/1000000.0) * 100) + "%" );
		
		System.out.println("Number of four of a kind: " + fourOfAKind + "  or  " + ((fourOfAKind/1000000.0) * 100) + "%");
	
	} 

	/**
	 * 
	 * @param array takes in an array that represents a deck
	 * @return array that is shuffled 
	 */
	public static int[] shuffle(int[] array) {
		
		int i = array.length-1;
		
		for( ; i >= 1 ; i --) {
			
			Random rand = new Random();
			
			int j = rand.nextInt(i);
			
			int temp = array[i];
			
			array[i] = array[j];
			
			array[j] = temp;
			
		}
		
		return array;
		
	} // end of shuffle method
	
} // end of class
