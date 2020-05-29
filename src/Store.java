import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.*;
public class Store extends JPanel{
	public Store() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// setExtendedState(JPanel.MAXIMIZED_BOTH);
		//setBackground(Color.red);
		JButton b=new JButton();
		b.setSize(100,100);
		add(b);
		setVisible(true);
	}
}
