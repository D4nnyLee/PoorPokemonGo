import java.awt.Color;
import  java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.Thread.State;
import java.util.ArrayList;

import javax.swing.*;
public class Battle extends JPanel{
	private int M_attack,Y_attack;
	private int M_blood,Y_blood;
	private int M_exp,Y_exp;
	private int M_power;
	private int M_money,Y_money;
	private String []Y_skill;
	private JLabel player;
	private JLabel monster;
	private JLabel bloodText;
	private JLabel M_bloodText;
	private JLabel Y_attackText;
	private JLabel M_attackText;
	private ArrayList<JButton> skillUse=new ArrayList<JButton>();
	private JProgressBar blooBar;
	private JProgressBar M_blooBar;
	private JProgressBar powerBar;
	 public Battle() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());		
		//這邊應該要接state然後傳下去?
		this.setLayout(null);
		//這邊傳遞data
		Status Monster=new Status();
		Status Character=new Status();
		StartGame(Character, Monster);
		

		//之後試試能不能多形
		//Property pro=new Property();
		//AllCharacter player=new Player();
		//AllCharacter professor=new Professor();
		//AllCharacter assistant=new Assistant();
		
		
		
		//這邊new我以及怪獸
		newCharacter();
		//這邊new property
		newProperty();
		//這邊new我的技能button
		newskillButton();
		//這邊new戰鬥場景(最後New才不會被圖層蓋掉)
		newBackground();
		
		
		
		
	}

	private void addButtonEvent() {
			
	}
		
	private void newProperty() {
		bloodText=new JLabel("我方血量");
		bloodText.setSize(100,50);
		bloodText.setForeground(Color.white);
		bloodText.setFont(new Font("dialog", 1, 20));
		blooBar=new JProgressBar();
		blooBar.setMaximum(this.M_blood);
		blooBar.setMinimum(0);
		blooBar.setValue(this.M_blood);
		blooBar.setForeground(Color.red);
		blooBar.setSize(200,30);
		blooBar.setLocation(0,50);
		Y_attackText=new JLabel("攻擊力:"+this.Y_attack);
		Y_attackText.setSize(100,50);
		Y_attackText.setLocation(0,100);
		Y_attackText.setForeground(Color.white);
		Y_attackText.setFont(new Font("dialog", 1, 20));
		this.add(blooBar);
		this.add(bloodText);
		this.add(Y_attackText);
		
		M_bloodText=new JLabel("敵方血量");
		M_bloodText.setSize(100,50);
		M_bloodText.setLocation(1100,0);
		M_bloodText.setForeground(Color.white);
		M_bloodText.setFont(new Font("dialog", 1, 20));
		M_blooBar=new JProgressBar();
		M_blooBar.setMaximum(this.M_blood);
		M_blooBar.setMinimum(0);
		M_blooBar.setValue(this.M_blood);
		M_blooBar.setForeground(Color.red);
		M_blooBar.setSize(200,30);
		M_blooBar.setLocation(1100,50);
		M_attackText=new JLabel("攻擊力:"+this.M_attack);
		M_attackText.setSize(100,50);
		M_attackText.setLocation(1100,100);
		M_attackText.setForeground(Color.white);
		M_attackText.setFont(new Font("dialog", 1, 20));
		powerBar=new JProgressBar();
		powerBar.setMaximum(10);
		powerBar.setMinimum(0);
		powerBar.setValue(this.M_power);
		powerBar.setForeground(Color.yellow);
		powerBar.setLocation(1100,150);
		powerBar.setSize(200,20);
		this.add(M_blooBar);
		this.add(M_bloodText);
		this.add(M_attackText);
		this.add(powerBar);
		 
	}
	private void newBackground() {
		try {
			JLabel jlb = new JLabel();	//例項化JLble
			int width = 1300,height = 700;	//這是圖片和JLable的寬度和高度
			ImageIcon image = new ImageIcon("image\\field1.png");//例項化ImageIcon 物件
			/*下面這句意思是:得到此圖示的 Image(image.getImage());
			在此基礎上建立它的縮放版本,縮放版本的寬度,高度與JLble一致(getScaledInstance(width, height,Image.SCALE_DEFAULT ))
			最後該影象就設定為得到的縮放版本(image.setImage)
			*/
			image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));//可以用下面三句程式碼來代替
			//Image img = image.getImage();
			//img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			//image.setImage(img);
			jlb.setIcon(image);
			jlb.setSize(width, height);
			this.add(jlb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fuck");
		}

		
	}
	private void newCharacter() {
		
	    player = new JLabel();	//例項化JLble
		int width = 100,height = 200;	//這是圖片和JLable的寬度和高度
		ImageIcon image = new ImageIcon("image\\player.png");//例項化ImageIcon 物件
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		player.setIcon(image);
		player.setSize(width, height);
		player.setLocation(500,400);
		this.add(player);
		
		
		width = 100;
		height = 500;
		monster =new JLabel();
		ImageIcon image2 = new ImageIcon("image\\professor.png");//例項化ImageIcon 物件
		image2.setImage(image2.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		monster.setIcon(image2);
		monster.setSize(width, height);
		monster.setLocation(900,100);
		this.add(monster);
	}
	private void newskillButton() {
		//System.out.print(Y_skill[0]);
		
		for(int i=0;i<this.Y_skill.length;++i)
		{
			
			JButton button=new JButton(this.Y_skill[i]);
			button.setSize(100,50);
			button.setVisible(true);
			button.setLocation(100*i,600);
		    skillUse.add(button);
		    
		    
			this.add(skillUse.get(i));
		}
		
	}
	 //遇到怪物的時候new我這個物件call這個function把State物件送進來
	public void StartGame(Status Character,Status Monster) {
		 //怪獸設定
		 M_attack=Monster.attack;
		 M_blood=Monster.blood;
		 M_money=Monster.money;
		 this.M_power=Monster.power;
		 //我的設定
		 Y_attack=Character.attack;
		 Y_blood=Character.blood;
		 Y_skill=Character.skill;
		 
		 
	 }
	
}
