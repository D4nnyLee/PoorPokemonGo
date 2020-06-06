import javax.swing.*;
import java.awt.Color;import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tutorial  extends JPanel implements ActionListener{
	 private GameMap2 map2;
	 private JButton start=new JButton("開始遊戲");
	 public Tutorial(GameMap2 mp2) {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		map2=mp2;
		start.setSize(100,100);
		start.addActionListener(this);
		add(start);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("fick");
		 if(e.getActionCommand().equals("開始遊戲"))
		 {
			 this.setVisible(false);
			 map2.setVisible(true);
			 map2.requestFocusInWindow();
		 }
	}
}
