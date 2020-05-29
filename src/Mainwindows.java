import javax.swing.*;
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
	}
	
}
