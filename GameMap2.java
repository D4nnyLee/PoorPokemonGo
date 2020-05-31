import java.awt.*;
import javax.swing.*;

public class GameMap2 extends JPanel{
	public GameMap2() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLayout(null);
		//setBackground(Color.green);
		//JButton b=new JButton();
		//b.setSize(100,100);
		//add(b);
		//setVisible(true);	
		newBackground();
	
		}
	private void newBackground() {
		try {
			JLabel jlb = new JLabel();
			int width = 1300,height = 700;
			ImageIcon image = new ImageIcon("Map2.png");		
			image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));	
			jlb.setIcon(image);
			jlb.setSize(width, height);
			System.out.println("DeBug");
			this.add(jlb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fuck");
		}
	}
}
