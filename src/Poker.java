public class Poker {	
	static String[] names = new String[10]; 
	public static void main (String[] args) throws InterruptedException{
		
		String won;
		
		Shuffle shuffle = new Shuffle(); 
		
		int[] hands1, hands2;
		String[] suits = {"c", "d", "h", "s"}; 
		
			shuffle.setDeck();   
			hands1 = shuffle.getShuffle1(); 
			hands2 = shuffle.getShuffle2(); 
			
			//Get the name of the picture file
			getName(hands1, hands2, suits);
	
			//First time operations to display GUI elements
			pokerGUI pg=new pokerGUI();
			pg.firstTime1();
			pg.displayHand1(names);	
			pg.empty();
			pg.firstTime2();
			pg.displayHand2(names);		
			pg.shuffleIt();
			
			do{
				//Continually checks if the user presses the shuffle button and when they do reset hands
				if(pg.returnShuff()){
					pg.removeWinner();
					shuffle.setDeck();
					hands1=shuffle.getShuffle1();
					hands2=shuffle.getShuffle2();
					getName(hands1,hands2,suits);
					pg.setShuff(false);
					Thread.sleep(1000); //Makes it seem like the cards are being shuffled
					pg.displayHand1(names);
					pg.displayHand2(names);
					pg.removeShuffle();
					
				}
				//Continually checks if the user presses the who won button and then displays the winner when they do
				if(pg.returnCheckWin()){
					Checker check = new Checker(names,hands1,hands2);
					String winner=check.tieBreaker(hands1, hands2);
					if(winner.equals("The winner is player #1")){
					won=check.getHandNames1();
					}else{
						won=check.getHandNames2();
					}
					pg.setCheckWin(false);
					pg.setWin(winner,won);
				}
			}while(true);
			
			

			 
	}
	
	/*
	 * Returns the name of the pictures and stores them in an array for later use
	 * pre:none
	 * post: Name of picture files based on cards in hand is stored in array
	 */
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
