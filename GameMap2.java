import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMap2 extends JPanel implements ActionListener,KeyListener{
	public GameMap2() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLayout(null);
		//setBackground(Color.green);
		//JButton b=new JButton();
		//b.setSize(100,100);
		//add(b);
		//setVisible(true);	
		
		
        //addFocusListener(this);  
		
		store_buttom();
		bag_buttom();
		character();
		newBackground();
		
	
		}
	private void newBackground() {
		try {
			JLabel jlb = new JLabel();
			int width = 1536,height = 801;
			ImageIcon image = new ImageIcon("Map2.png");		
			image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));	
			jlb.setIcon(image);
			jlb.setSize(width, height);
			
			this.add(jlb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fuck");
		}
	}
	private void store_buttom() {
		ImageIcon store_image = new ImageIcon("Store_icon.png");		
		store_image.setImage(store_image.getImage().getScaledInstance(100, 60,Image.SCALE_DEFAULT ));	
		JButton store = new JButton(store_image);
		store.setActionCommand("store");
		store.setIcon(store_image);
		store.setSize(100,60);
		store.setLocation(1425, 735);
		//System.out.println("DeBug");
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
		bag.setLocation(1300, 735);
		//System.out.println("DeBug");
		bag.addActionListener(this);
		bag.setContentAreaFilled(false);
		setVisible(true);	
		this.add(bag);
	}	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "store":	
					System.out.println("asasassasa");
				break;
			case "bag":
					System.out.println("open bag");
				break;		
		}
	}
	private void character() {

		try {
			JLabel jlb = new JLabel();
			int width = 80,height = 90;
			ImageIcon image = new ImageIcon("背面1.png");		
			image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));	
			jlb.setIcon(image);
			jlb.setSize(width, height);
			this.add(jlb);
			
			addKeyListener(this);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fuck");
		}
	}
	@Override 
    public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("上");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("下");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("右");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("左");
			break;
		}
    }
    @Override 
    public void keyReleased(KeyEvent e) {
       
    }
    @Override 
    public void keyTyped(KeyEvent e) {
        
    }
	
}


