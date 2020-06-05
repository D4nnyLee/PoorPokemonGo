import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMap2 extends JPanel implements ActionListener{
	public GameMap2() {
		

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
	
		setFocusable(true);
		
		button_location();
 		store_buttom();
		bag_buttom();
		newBackground();
		this.setLayout(null);
	
		setVisible(true);
		
		
		
		}
	
	private void newBackground() {
		JLabel jlb = new JLabel();
		int width = 1536,height = 801;
		ImageIcon image = new ImageIcon("Map2.png");		
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));	
		jlb.setIcon(image);
		jlb.setSize(width, height);
			
		this.add(jlb);
	}
	
	private int person_x = 750;
	private int person_y = 280;
	
	
	
	private void button_location() {
		ImageIcon csie = new ImageIcon("ball.png");
		csie.setImage(csie.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT ));
		JButton center = new JButton(csie);
		center.setContentAreaFilled(false);
		JButton water = new JButton(csie);
		water.setContentAreaFilled(false);
		JButton grass_1 = new JButton(csie);
		grass_1.setContentAreaFilled(false);
		JButton grass_2 = new JButton(csie);
		grass_2.setContentAreaFilled(false);
		
		ImageIcon pp = new ImageIcon("培英.jpg");
		JButton pein = new JButton(pp);
		
		ImageIcon da = new ImageIcon("資結.jpg");
		JButton data_s = new JButton(da);
		
		ImageIcon com = new ImageIcon("英超1.jpg");      //有2張圖到時候選
		JButton computer = new JButton(com);
		
		
		center.setSize(40, 40);
		center.setLocation(750, 280);
	
		water.setSize(40, 40);
		water.setLocation(100, 280);
	
		grass_1.setSize(40, 40);
		grass_1.setLocation(100, 625);

		grass_2.setSize(40, 40);
		grass_2.setLocation(750, 625);
	
		pein.setSize(120, 162);
		pein.setLocation(725, 0);
		
		data_s.setSize(100, 148);
		data_s.setLocation(1310, 40);
		
		computer.setSize(120,154);
		computer.setLocation(1250, 490);
		
		ImageIcon cc = new ImageIcon("正面1.png");  
		JButton character = new JButton(cc);
		character.setContentAreaFilled(false);
		character.setSize(60,70);
		character.setLocation(750-10, 280-40);      //再對照的時候就 x+10 y+40
		character.setActionCommand("character");
		character.addActionListener(this);
		
		//setVisible(true);
		
		this.add(character);
		this.add(center);
		this.add(water);
		this.add(grass_1);
		this.add(grass_2);
		this.add(pein);
		this.add(data_s);
		this.add(computer);
		
		
	}
	
	
	private void store_buttom() {
		ImageIcon store_image = new ImageIcon("Store_icon.png");		
		store_image.setImage(store_image.getImage().getScaledInstance(100, 60,Image.SCALE_DEFAULT ));	
		JButton store = new JButton(store_image);
		store.setActionCommand("store");
		store.setIcon(store_image);
		store.setSize(100,60);
		store.setLocation(1425, 735);
		store.addActionListener(this);
		store.setContentAreaFilled(false);
		setVisible(true);	
		this.add(store);
	}
	
	
	
	private void bag_buttom() {
		ImageIcon bag_buttom = new ImageIcon("Bag_icon.png");		
		bag_buttom.setImage(bag_buttom.getImage().getScaledInstance(100, 60,Image.SCALE_DEFAULT ));	
		JButton bag = new JButton(bag_buttom);
		bag.setActionCommand("bag");
		bag.setIcon(bag_buttom);
		bag.setSize(100,60);
		int bag_x = 1300;
		int bag_y = 735; 
		bag.setLocation(bag_x, bag_y);
		bag.addActionListener(this);
		bag.setContentAreaFilled(false);
		setVisible(true);	
		this.add(bag);
	}	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "store":	
				System.out.println("open store");	
				break;
			case "bag":
				System.out.println("open bag");
				break;		
			case "character":
				System.out.println("move");
				break;
		}
	}
	/*private Rectangle boy = new Rectangle(500,250,80,90);
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(boy.x, boy.y, boy.width, boy.height);
	}*/
	
	
	
	
	
	
	
	


	
}


