import java.util.*; 

public class Poker {	
	static String[] names = new String[10]; 
	public static void main (String[] args) throws InterruptedException{
		
		Shuffle shuffle = new Shuffle(); 
		int[] hands1, hands2;
		String[] suits = {"c", "d", "h", "s"}; 
		
			shuffle.setDeck();   
			hands1 = shuffle.getShuffle1(); 
			hands2 = shuffle.getShuffle2(); 
			
			getName(hands1, hands2, suits); 
			
			pokerGUI pg=new pokerGUI();
			pg.firstTime1();
			pg.displayHand1(names);	
			pg.empty();
			pg.firstTime2();
			pg.displayHand2(names);		
			pg.shuffleIt();
			
			do{
				if(pg.returnShuff()){
					shuffle.setDeck();
					hands1=shuffle.getShuffle1();
					hands2=shuffle.getShuffle2();
					getName(hands1,hands2,suits);
					pg.setShuff(false);
					pg.displayHand1(names);
					pg.displayHand2(names);
				}
			}while(true);
			
			

			
			//new pokerGUI(names); 
	}
	
	public static void getName(int[] hands1, int[] hands2, String[] suits){
		int temp; 
		for (int n = 0; n < 5; n++){
			temp = hands1[n] % 13; 
			if (temp == 0){
				temp = 13; 
				
			}
			names[n] = suits[((hands1[n]-1) / 13)] + String.valueOf(temp) + ".png"; 
		}
		for (int n = 0; n < 5; n++){
			temp = hands2[n] % 13; 
			if (temp == 0){
				temp = 13; 
			}
			names[n+5] = suits[((hands2[n]-1) / 13)] + String.valueOf(temp) + ".png"; 
		} 
	}
}
