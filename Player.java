import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Player extends Property {
	public JLabel p;
	public ArrayList<JButton> skillUse=new ArrayList<JButton>();
	public String [] skill;
	private Timer playerIdel=new Timer();
	//傳給battle跑動畫用的
	public int playerImageNum=0;
	public String playerPath="image\\player\\player0";
	public int playerWidth=150;
	public int playerHeight=300;
	public Player(JPanel  fieldJPanel,Status pStatus) {
		// TODO Auto-generated constructor stub
		battleField=fieldJPanel;
		setPlayer(pStatus);
		setPlayerProperty();
		newskillButton();
		
		//開始player的timer
		playerIdel.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				// TODO Auto-generated method stub

				ImageIcon image = new ImageIcon(playerPath+playerImageNum+".gif");//例項化ImageIcon 物件
				image.setImage(image.getImage().getScaledInstance(playerWidth, playerHeight,Image.SCALE_DEFAULT ));
				p.setIcon(image);
				
				++playerImageNum;
				if(playerImageNum>=43)
					playerImageNum=0;
			}
		}, 0,50);
		
	}
	public void setPlayer(Status s) {
	 //設定
		p = new JLabel();	//例項化JLble
		int width = this.playerWidth;
		int height = this.playerHeight;
		p.setSize(width, height);
		p.setLocation(500,300);
		//player.setOpaque(true); 
		//player.setBackground(Color.red);
		battleField.add(p);
		attack=s.attack;
		blood=s.blood;
		money=s.money;
		skill=s.skill;
		
		 
	 }
	public void setPlayerProperty() {
		bloodText=new JLabel("我方血量");
		bloodText.setSize(100,50);
		bloodText.setForeground(Color.white);
		bloodText.setFont(new Font("dialog", 1, 20));
		blooBar=new JProgressBar();
		blooBar.setMaximum(100);
		blooBar.setMinimum(0);
		blooBar.setValue(this.blood);
		blooBar.setForeground(Color.red);
		blooBar.setSize(200,30);
		blooBar.setLocation(0,50);
		attackText=new JLabel("攻擊力:"+this.attack);
		attackText.setSize(100,50);
		attackText.setLocation(0,100);
		attackText.setForeground(Color.white);
		attackText.setFont(new Font("dialog", 1, 20));
		battleField.add(blooBar);
		battleField.add(bloodText);
		battleField.add(attackText);
		
	}
	private void newskillButton() {
		//System.out.print(Y_skill[0]);
		
		for(int i=0;i<this.skill.length;++i)
		{
			
			JButton button=new JButton(this.skill[i]);
			button.setSize(80,50);
			button.setVisible(true);
			
			button.setLocation(0+80*(i/5),400+50*(i%5));

		    skillUse.add(button);
		    
		    
			battleField.add(skillUse.get(i));
		}
		
	}


}
