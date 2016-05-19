import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pokerGUI {
	JFrame frame;
	JPanel panel;
	JLabel name1,name2,winner,backcard,shuffling;
	JLabel[] hand1;
	JLabel[] hand2;
	JButton shuffleB;
	int n=1;
	static String n1,n2;
	
	public pokerGUI(){
		
		
		frame=new JFrame("Poker");
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,6,20,20));
		panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		
		
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	//Output cards based on file names array
	public void displayHand2(String []filenames,String p2Name){
		name2=new JLabel(p2Name);
		panel.add(name2);
		for(int i=5;i<10;i++){
			hand2[i]=new JLabel(new ImageIcon(filenames[i]));
			panel.add(hand2[i]);
		}
	}
	public void displayHand1(String[]filenames,String p1Name){
		name1=new JLabel(p1Name);
		panel.add(name1);
		for(int i=0;i<5;i++){
			hand1[i]=new JLabel(new ImageIcon(filenames[i]));
			panel.add(hand1[i]);
		}
	}
	public void empty(){
		for(int i=0;i<5;i++){
		panel.add(new JLabel());
		}
		backcard=new JLabel(new ImageIcon("redback.png"));
	}
	
	public void shuffleIt(){
		shuffleB=new JButton("Re-Shuffle");
		shuffleB.setActionCommand("False");
		shuffleB.addActionListener(new shuffle());
	}
	
	public void displayBack(){
		for(int i=0;i<5;i++){
			hand1[i].setIcon(new ImageIcon("redback.png"));
		}
		for(int i=5;i<10;i++){
			hand2[i].setIcon(new ImageIcon("redback.png"));
		}
		panel.repaint();
		panel.revalidate();
	}
	
	public void shufflingCards(){
		shuffling=new JLabel("SHUFFLING!!!");
		panel.add(shuffling);
	}
	
	public void removeShuffle(){
		panel.remove(shuffling);
		panel.repaint();
		panel.revalidate();
	}
	
	public static void runGUI(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		pokerGUI pg=new pokerGUI();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				runGUI();
			}
		});

	}
	
	class shuffle implements ActionListener{
		public void actionPerformed(ActionEvent event){
			displayBack();
		}
	}
}
