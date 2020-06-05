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
	public JButton character;
	public JButton pein;
	public JButton data_s;
	public JButton computer;
	
	
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
		
		ImageIcon pp = new ImageIcon("培英1.jpg");
		 pein = new JButton(pp);
		
		ImageIcon da = new ImageIcon("資結1.jpg");
		 data_s = new JButton(da);
		
		ImageIcon com = new ImageIcon("英超.jpg");      //有2張圖到時候選
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
		
		ImageIcon cc = new ImageIcon("正面1.png");  
		character = new JButton(cc);
		character.setContentAreaFilled(false);
		character.setSize(60,70);
		//character.setLocation(person_x-10, person_y-40);      //再對照的時候就 x+10 y+40
		setlocation(character);
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
		
		
	}
	
	ImageIcon pp_angry = new ImageIcon("培英.jpg");
	
	ImageIcon da_angry = new ImageIcon("資結.jpg");	
	ImageIcon com_angry = new ImageIcon("英超1.jpg");
	
	
	
	
	private void setlocation(JButton a) {
		a.setLocation(person_x-10, person_y-40);
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
			case"center":
				System.out.println("center");
				if(person_x == 100 && person_y == 280) {           //from water
					for(person_x = 100;person_x != 750 ;person_x = person_x + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 750 && person_y == 625) {   //from grass_2
					for(person_y = 625;person_y != 280 ;person_y = person_y - 1) {
						//System.out.println(person_y);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 750 && person_y == 125) {  //from 賠應
					for(person_y = 125;person_y != 280 ;person_y = person_y + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 1330 && person_y == 150) {    //from 資結
					for(person_y = 150;person_y != 280 ;person_y = person_y + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					for(person_x = 1330;person_x != 750 ;person_x = person_x - 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				break;
			case"water":
				if(person_x == 750 && person_y == 280) {   //from center
					for(person_x = 750;person_x != 100 ;person_x = person_x - 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 100 && person_y == 625) {   //from grass_1
					for(person_y = 625;person_y != 280 ;person_y = person_y - 1) {
						//System.out.println(person_y);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				System.out.println("water");
				break;
			case"grass_1":
				if(person_x == 100 && person_y == 280) {  //from water
					for(person_y = 280;person_y != 625 ;person_y = person_y + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 750 && person_y == 625) {    //from grass_2
					for(person_x = 750;person_x != 100 ;person_x = person_x - 1) {
						//System.out.println(person_y);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				System.out.println("gress_1");
				break;
			case"grass_2":
				if(person_x == 750 && person_y == 280) {  //from center
					for(person_y = 280;person_y != 625 ;person_y = person_y + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 100 && person_y == 625) {   //from grass_1
					for(person_x = 100;person_x != 750 ;person_x = person_x + 1) {
						//System.out.println(person_y);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(person_x == 1250 && person_y == 575) {   //from center
					for(person_x = 1250;person_x != 750 ;person_x = person_x - 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					for(person_y = 575;person_y != 625 ;person_y = person_y + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				System.out.println("gress_2");
				break;
			case"pein":
				pein.setIcon(pp_angry);
				if(person_x == 750 && person_y == 280) {   //from center
					for(person_y = 750;person_y != 125 ;person_y = person_y - 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				System.out.println("pein");
				break;
			case"data_s":
				data_s.setIcon(da_angry);
				if(person_x == 750 && person_y == 280) {   //from center
					for(person_x = 750;person_x != 1330 ;person_x = person_x + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					for(person_y = 280;person_y != 150 ;person_y = person_y - 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				break;
			case"computer":
				computer.setIcon(com_angry);
				if(person_x == 750 && person_y == 625) {   //from grass_2
					for(person_y = 625;person_y != 575 ;person_y = person_y - 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					for(person_x = 750;person_x != 1250 ;person_x = person_x + 1) {
						//System.out.println(person_x);
						setlocation(character);
						try {
							Thread.sleep(1);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				break;
		}
	}
	/*private Rectangle boy = new Rectangle(500,250,80,90);
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(boy.x, boy.y, boy.width, boy.height);
	}*/
	
	
	
	
	
	
	
	


	
}


