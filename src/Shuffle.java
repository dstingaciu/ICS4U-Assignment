import java.util.*; 

public class Shuffle {
	public static Stack <Integer> deck = new Stack <Integer>(); 
	public static int[] hand1 = new int[5]; 
	public static int[] hand2 = new int[5]; 
	
	/*
	 * Creates a stack of 52 numbers (1-52)
	 * pre:none
	 * post: stack is created
	 */
	public void setDeck(){
		deck.clear();
		for (int n=1; n<53; n++){
			deck.push(n);
		} 
	}
	
	/*
	 * Shuffles stack and pops 5 numbers from stack and returns them for 1st hand
	 * pre: none
	 * post: returns hand 1 array
	 */
	public int[] getShuffle1(){
		Collections.shuffle(deck);
		for (int n = 0; n < 5; n++){
			hand1[n] = deck.pop(); 
		}
		return (hand1); 
	}
	/*
	 * Shuffles stack and pops 5 numbers from stack and returns them for 2nd hand
	 * pre: none
	 * post: returns hand 2 array
	 */
	public int[] getShuffle2(){
		Collections.shuffle(deck);
		for (int n = 0; n < 5; n++){
			hand2[n] = deck.pop(); 
		}
		return (hand2); 
	}
}
