import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
public class GameMap1  extends JPanel{
	 public GameMap1() {
		 setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//setBackground(Color.red);
		JButton b=new JButton();
		b.setSize(100,100);
		add(b);
		setVisible(false);
		
		
		
	}
}
