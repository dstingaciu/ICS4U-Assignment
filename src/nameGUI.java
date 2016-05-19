import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class nameGUI implements ActionListener {
	JTextField name,name2;
	JLabel blah;
	JFrame frame;
	JPanel panel;
	JButton next;
	String p1name,p2name;
	public nameGUI(){
		frame=new JFrame("Names");
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,6,20,20));
		panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		
		blah=new JLabel("Name 1:");

		name=new JTextField(150);
		p1name=name.getText();
		next=new JButton("Next player");
		next.setActionCommand("name");
		next.addActionListener(this);
		p2name=name2.getText();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

	}
	
	public String returnName1(){
		return p1name;
	}
	public String returnName2(){
		return p2name;
	}
	public void actionPerformed(ActionEvent event){
		String eventName=event.getActionCommand();
		if(eventName.equals("name")){
		blah.setText("Name 2: ");
		next.setText("Finish");
		next.setActionCommand("exit");
		name2=new JTextField(150);
		}else{
			System.exit(0);
		}
	}
	
}
