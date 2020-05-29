import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.*;
public class Battle extends JPanel{
	 public Battle() {
		 setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(Color.red);
		JButton b=new JButton();
		b.setSize(100,100);
		add(b);
		setVisible(true);
		
	}
	
}
