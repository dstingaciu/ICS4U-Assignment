import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class pokerGUI {
	JFrame frame;
	JPanel panel;
	JLabel name1,name2,winner;
	JButton shuffleB;
	int n=1;
	
	public pokerGUI(){
		frame=new JFrame("Poker");
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,3,20,20));
		panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		
	}
	
	public void displayName(String p1Name,String p2Name){
		name1=new JLabel(p1Name);
		name2=new JLabel(p2Name);
	}
	//Output cards based on file names array
	public void displayHand(String []filenames){
		for(int i=0;i<filenames.length;i++){
			
		}
	}
	
	public static void main(String[] args) {
		

	}

}
