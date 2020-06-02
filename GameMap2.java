import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMap2 extends JPanel implements ActionListener, KeyListener{
	public GameMap2() {
		this.addKeyListener(this);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLayout(null);
		setFocusable(true);
 		store_buttom();
		bag_buttom();
		newBackground();
		
		
		}
	
	private int bag_x = 1300;
	private int bag_y = 700; 
	
	private void newBackground() {
		JLabel jlb = new JLabel();
		int width = 1536,height = 801;
		ImageIcon image = new ImageIcon("Map2.png");		
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));	
		jlb.setIcon(image);
		jlb.setSize(width, height);
			
		this.add(jlb);
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
	
	ImageIcon bag_buttom = new ImageIcon("Bag_icon.png");		
	//bag_buttom.setImage(bag_buttom.getImage().getScaledInstance(100, 60,Image.SCALE_DEFAULT ));	
	JButton bag = new JButton(bag_buttom);
	
	private void bag_buttom() {
		
		bag.setActionCommand("bag");
		bag.setIcon(bag_buttom);
		bag.setSize(100,60);
		bag.setLocation(bag_x, bag_y);
		//bag.addActionListener(this);
		bag.addKeyListener(this);
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
		}
	}
	/*private Rectangle boy = new Rectangle(500,250,80,90);
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(boy.x, boy.y, boy.width, boy.height);
	}*/
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key keyTyped code:" + e.getKeyCode());
		System.out.println("eeeeeeeeeeeeeeeeeeeeee");
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			bag.setLocation(bag_x , bag_y-5);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			bag.setLocation(bag_x , bag_y+5);;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bag.setLocation(bag_x +5 , bag_y);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			bag.setLocation(bag_x-5 , bag_y);
		}
	
		}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("key keyTyped code:" + e.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("key keyTyped code:" + e.getKeyCode());
	}
	
	
	
	
	
	


	
}


