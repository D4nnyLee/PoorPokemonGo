import javax.swing.*;
import java.awt.event.*;
public class Mainwindows extends JFrame {
	Mainwindows() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(null);
		GameMap1 map1 = new GameMap1();	
		GameMap2 map2 = new GameMap2();
		Store store = new Store();		
		Battle battle = new Battle();		
		add(map1);
		add(map2);
		add(battle);
		add(store);
		
		map2.requestFocusInWindow();
		map2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				map2.requestFocusInWindow();
			}
			
		});
	}
	
}
