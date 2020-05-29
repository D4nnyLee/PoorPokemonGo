package swingPractice;
import java.awt.Color;

import javax.swing.*;
public class practice1 {

	public practice1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jFrame=new JFrame();
		jFrame.setSize(600,800);
		jFrame.setLayout(null);
		ListenButton listenButton=new ListenButton();
		JButton jButton=new JButton("fuck me");
		jButton.setLocation(100,300);
		jButton.setSize(100,100);
		jButton.addActionListener(listenButton);
		jFrame.add(jButton);
		jFrame.getContentPane().setBackground(Color.red);
		jFrame.setVisible(true);
	}

}
