import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pokerGUI {
	JFrame frame;
	JPanel panel;
	JLabel name1,name2,winner,backcard,shuffling,howWon;
	JLabel[] hand1=new JLabel[5];
	JLabel[] hand2=new JLabel[5];
	JButton shuffleB,whoWon;
	int n=1;
	static String n1,n2;
	boolean checkwin=false;
	String win;
	int counter1=0,counter2=0;
	
	
	public boolean shuff=false;
	
	public pokerGUI(){
		
		
		frame=new JFrame("Poker");
		
		panel=new JPanel();
		frame.setContentPane(panel);
		panel.setLayout(new GridLayout(0,6,20,20));
		panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		frame.setSize(100,100);
		shuffling=new JLabel();
		winner=new JLabel();
		howWon=new JLabel();
		
		
		frame.getContentPane().setBackground(Color.darkGray);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1280,1024 );

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * First time operation of adding elements to the panel for the first hand
	 * pre:none
	 * post:adds hand 1 and the string player 1
	 */
	
	public void firstTime1(){
		name1=new JLabel("Player 1");
		name1.setForeground(Color.white);
		panel.add(name1);
		for(int i = 0; i < 5; i++) hand1[i] = new JLabel();
		for(int i=0;i<5;i++){
		panel.add(hand1[i]);
		}
	}
	
	/*
	 * First time operation of adding elements to the panel for the second hand
	 * pre:none
	 * post: Adds hand 2 and the string player 2
	 */
	public void firstTime2(){
		name2=new JLabel("Player 2");
		name2.setForeground(Color.white);
		panel.add(name2);
		for(int i = 0; i < 5; i++) hand2[i] = new JLabel();
		for(int i=0;i<5;i++){
		panel.add(hand2[i]);
		}
	}
	

	/* Displays cards based on file names array for first hand
	 * pre:Elements on content panel must be set
	 * post: displays correct card picture
	 */
	public void displayHand2(String []filenames){
		for(int i=0;i<5;i++){
			hand2[i].setIcon(new ImageIcon(filenames[i+5]));	
			panel.revalidate();
				try{
					Thread.sleep(275);
				}catch(InterruptedException ex){
					Thread.currentThread().interrupt();
			}
		}
		counter2++;
	}
	/* Displays cards based on file names array for second hand
	 * pre:Elements on content panel must be set
	 * post: displays correct card picture
	 */	
	public void displayHand1(String[]filenames){
		for(int i=0;i<5;i++){			
			hand1[i].setIcon(new ImageIcon(filenames[i]));
			panel.revalidate();
				try{
					Thread.sleep(275);
				}catch(InterruptedException ex){
					Thread.currentThread().interrupt();
			}
		}
		counter1++;
	}
	
	/*
	 * Displays back of one card in between hands
	 * pre:none
	 * post: displays card back
	 */
	public void empty(){
		for(int i=0;i<5;i++){
		panel.add(new JLabel());
		}
		panel.add(new JLabel(new ImageIcon("redback.png")));
		panel.revalidate();
	}
	
	/*
	 * Adds shuffle and who won button elements to content panel
	 * pre: none
	 * post: displays shuffle and who won buttons
	 */
	public void shuffleIt(){
		shuffleB=new JButton("Re-Shuffle");		
		shuffleB.addActionListener(new shuffle());
		shuffleB.setBackground(Color.gray);
		shuffleB.setForeground(Color.white);
		panel.add(shuffleB);
		whoWon=new JButton("Who Won?");
		whoWon.addActionListener(new won());
		whoWon.setBackground(Color.gray);
		whoWon.setForeground(Color.white);
		panel.add(whoWon);
		panel.add(winner);
		panel.add(howWon);
		panel.revalidate();
	}
	
	/*
	 * Returns the state of shuff variable
	 * pre: shuff must be initialized
	 * post: none
	 */
	public boolean returnShuff(){
		return shuff;
	}
	/*
	 * Changes the state of shuff variable
	 * pre: none
	 * post: State of shuff changed
	 */
	public void setShuff(boolean a){
		shuff=a;
	}
	/*
	 * Returns the state of checkwin variable
	 * pre: checkwin must be initialized
	 * post: none
	 */
	public boolean returnCheckWin(){
		return checkwin;
	}
	/*
	 * Changes the state of checkwin variable
	 * pre: none
	 * post: State of checkwin is changed
	 */
	public void setCheckWin(boolean win){
		checkwin=win;
	}
	
	/*
	 * Displays which player won and how the player won
	 * pre: how won and winner labels must be initialized
	 * post: Displays winner and how they won
	 */
	public void setWin(String whoWon, String how){
		win=whoWon;
		howWon.setText("with a "+how);
		howWon.setForeground(Color.white);
		winner.setText(win+"  ");
		winner.setForeground(Color.white);
		panel.revalidate();
	}
	
	/*
	 * Removes winner elements
	 * pre: none
	 * post: winner and howWon labels are removed
	 */
	public void removeWinner(){
		winner.setText("");
		howWon.setText("");
	}
	
	/*
	 * Displays the back of the cards for each hand
	 * pre: none
	 * post: displays card backs
	 */
	public void displayBack(){
		for(int i=0;i<5;i++){
			hand1[i].setIcon(new ImageIcon("redback.png"));
		}
		for(int i=0;i<5;i++){
			hand2[i].setIcon(new ImageIcon("redback.png"));
		}
		shuff=true;
		panel.revalidate();
	}
	
	/*
	 * Displays string that says its shuffling
	 * pre: shuffling must be initialized 
	 * post: displays label thats says shuffling
	 */
	public void shufflingCards(){
		shuffling.setText("Shuffling!");
		shuffling.setForeground(Color.white);
		panel.add(shuffling);
	}
	
	/*
	 * Removes shuffling
	 * pre: shuffling must be initialized
	 * post: removes shuffling 
	 */
	public void removeShuffle(){
		shuffling.setText("");
		panel.revalidate();
	}
	
	//goes into correct methods for pressing shuffle buttons
	class shuffle implements ActionListener{
		public void actionPerformed(ActionEvent event){
			shufflingCards();
			displayBack();
		}
	}
	
	//Changes state of checkwin to true when action performed is pressed
	class won implements ActionListener{
		public void actionPerformed(ActionEvent event){
			checkwin=true;
		}
	}
}
