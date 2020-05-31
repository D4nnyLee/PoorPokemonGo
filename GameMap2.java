import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
public class GameMap2 extends JPanel{
	public GameMap2() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(Color.green);
		JButton b=new JButton();
		b.setSize(100,100);
		add(b);
		setVisible(false);
	}
}
