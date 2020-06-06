import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameMap2 extends JPanel implements ActionListener{
	public GameMap2() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		button_location();
 		store_buttom();
		bag_buttom();
		newBackground();
		this.setLayout(null);
		
		
		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				
				//System.out.println(e.getKeyChar());
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					person_y -=10;
					character.setLocation(person_x,person_y);
					character.setIcon(up_1);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					person_y +=10;
					character.setLocation(person_x,person_y);
					character.setIcon(down_1);
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					person_x +=10;
					character.setLocation(person_x,person_y);
					character.setIcon(right_1);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					person_x -=10;
					character.setLocation(person_x,person_y);
					character.setIcon(left_1);
				}
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					//if(person_x + 40 );
				}
				the_TA_locaton(person_x,person_y);
				the_professors(person_x,person_y);
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		setFocusable(true);
		setVisible(true);
		requestFocusInWindow();
	
		
		
		}
	private int person_x = 750;
	private int person_y = 280;  
	public JButton character;
	public JButton pein;
	public JButton data_s;
	public JButton computer;
	int x_up  = 0;
	int x_lower = 0;
	int y_up =0;
	int y_lower = 0;
	
	ImageIcon down_1 = new ImageIcon("正面1.png"); 
	ImageIcon down_2 = new ImageIcon("正面2.png"); 
	ImageIcon down_3 = new ImageIcon("正面3.png"); 
	ImageIcon up_1 = new ImageIcon("背面1.png"); 
	ImageIcon up_2 = new ImageIcon("背面2.png"); 
	ImageIcon up_3 = new ImageIcon("背面3.png"); 
	ImageIcon right_1 = new ImageIcon("向右1.png"); 
	ImageIcon right_2 = new ImageIcon("向右2.png"); 
	ImageIcon right_3 = new ImageIcon("向右3.png"); 
	ImageIcon left_1 = new ImageIcon("向左1.png"); 
	ImageIcon left_2 = new ImageIcon("向左2.png"); 
	ImageIcon left_3 = new ImageIcon("向左3.png"); 
	
	
	private void newBackground() {
		JLabel jlb = new JLabel();
		int width = 1536,height = 801;
		ImageIcon image = new ImageIcon("Map2.png");		
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));	
		jlb.setIcon(image);
		jlb.setSize(width, height);
			
		this.add(jlb);
	}
	ImageIcon pp = new ImageIcon("培英1.jpg");
	ImageIcon da = new ImageIcon("資結1.jpg");
	ImageIcon com = new ImageIcon("英超.jpg");
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
		
		
		 pein = new JButton(pp);
		
		
		 data_s = new JButton(da);
		
		
		 computer = new JButton(com);
		
		
		center.setSize(40, 40);
		center.setLocation(750, 280);
		center.setActionCommand("center");
		center.addActionListener(this);
	
		water.setSize(40, 40);
		water.setLocation(100, 280);
		water.setActionCommand("water");
		water.addActionListener(this);
	
		grass_1.setSize(40, 40);
		grass_1.setLocation(100, 625);
		grass_1.setActionCommand("grass_1");
		grass_1.addActionListener(this);

		grass_2.setSize(40, 40);
		grass_2.setLocation(750, 625);
		grass_2.setActionCommand("grass_2");
		grass_2.addActionListener(this);
	
		pein.setSize(120, 162);
		pein.setLocation(725, 0);
		pein.setActionCommand("pein");
		pein.addActionListener(this);
		
		data_s.setSize(100, 148);
		data_s.setLocation(1310, 40);
		data_s.setActionCommand("data_s");
		data_s.addActionListener(this);
		
		computer.setSize(120,154);
		computer.setLocation(1250, 490);
		computer.setActionCommand("computer");
		computer.addActionListener(this);
		
		
		character = new JButton(down_1);
		character.setContentAreaFilled(false);
		character.setSize(60,70);
		character.setLocation(person_x, person_y);      //再對照的時候就 x+10 y+40
		//setlocation(character);
		character.setActionCommand("character");
		character.addActionListener(this);
		character.setBorderPainted(false); 
		
		
		//setVisible(true);
		
		this.add(character);
		this.add(center);
		this.add(water);
		this.add(grass_1);
		this.add(grass_2);
		this.add(pein);
		this.add(data_s);
		this.add(computer);
		this.requestFocusInWindow();
		
	}
	
	ImageIcon pp_angry = new ImageIcon("培英.jpg");
	
	ImageIcon da_angry = new ImageIcon("資結.jpg");	
	ImageIcon com_angry = new ImageIcon("英超1.jpg");
	
	
	
	
	/*private void setlocation(JButton a) {
		a.setLocation(person_x + 40,person_y -10);
		
	}*/
	

	
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
		}
		this.requestFocusInWindow();
	}	
	
	public void  the_TA_locaton(int person_x,int person_y) {
		if(person_x >0 && person_x < 750 && person_y > 450 && person_y < 700) {
			x_up = (int) (Math.random()*750);
			x_lower = x_up + 200;
			y_up = 300+(int) (Math.random()*350);
			y_lower = y_up + 200;			
			if(person_x > x_up && person_x < x_lower && person_y > y_up && person_y < y_lower) {
				System.out.println(x_up);
				System.out.println(y_up);
				//生怪
			}
		}
	}
	
	public void the_professors(int person_x,int person_y) {
		if(person_x >725 && person_x < 845 && person_y > 0 && person_y < 162) {
			System.out.println("pein");
			pein.setIcon(pp_angry);
		}
		else {
			pein.setIcon(pp);
		}
		if(person_x >1310 && person_x < 1410 && person_y > 40 && person_y < 188) {
			System.out.println("data_s");
			data_s.setIcon(da_angry);
		}
		else {
			data_s.setIcon(da);
		}
		if(person_x >1250 && person_x < 1370 && person_y > 490 && person_y < 644) {
			System.out.println("computer");
			computer.setIcon(com_angry);
		}
		else {
			computer.setIcon(com);
		}

		
	}
	
	
	/*public void actionPerformed(ActionEvent e) {
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
			case"center":
				System.out.println("center");
				if(person_x == 100 && person_y == 280) {  //from water		
						Timer timer = new Timer();  
						TimerTask task = new TimerTask() {  
				            @Override
				            public void run() {  
				            	person_x += 1;
				            	character.setLocation(person_x,person_y);
				            	if(person_x == 750) {
				            		//setlocation(character);
				            		timer.cancel();
				            	}
				            }  
				        };  
				        
				        long delay = 0;  
				        long intevalPeriod = 4;  
				        timer.scheduleAtFixedRate(task, delay, intevalPeriod); 
				        timer.schedule(task, delay);  
						
				        
					}
			*/	



	
	
	
	
	
	


	
}


