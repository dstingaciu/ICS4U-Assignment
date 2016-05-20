import java.util.*; 

public class Shuffle {
	public static Stack <Integer> deck = new Stack <Integer>(); 
	public static int[] hand1 = new int[5]; 
	public static int[] hand2 = new int[5]; 
	
	
	public void setDeck(){
		deck.clear();
		for (int n=1; n<53; n++){
			deck.push(n);
		} 
	}
	
	public int[] getShuffle1(){
		Collections.shuffle(deck);
		for (int n = 0; n < 5; n++){
			hand1[n] = deck.pop(); 
		}
		return (hand1); 
	}
	
	public int[] getShuffle2(){
		Collections.shuffle(deck);
		for (int n = 0; n < 5; n++){
			hand2[n] = deck.pop(); 
		}
		return (hand2); 
	}
}
