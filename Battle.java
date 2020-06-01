
import java.awt.Color;
import java.awt.Font;
import 	java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
public class Battle extends JPanel implements ActionListener{
	 private Property property;
	 private Timer AnnounceRound=new Timer();
	 private Timer AnnounceSkill=new Timer();
	 private Timer myTimer=new Timer();
	 private Timer monseTimer=new Timer();
	 private JLabel allAnnounce=new JLabel();
	 private boolean round=true;
	 public Battle() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());		
		this.setLayout(null);
		allAnnounce.setSize(500,100);
		allAnnounce.setForeground(Color.white);
		allAnnounce.setFont(new Font("dialog", 1, 50));
		allAnnounce.setLocation(500,250);
		this.add(allAnnounce);
		//這邊傳遞data
		property=new Property(this);
		addButtonEvent();
		
		
		//開始遊戲
		allAnnounce.setText("我的回合!");
		AnnounceRound.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				allAnnounce.setText("");
				for(int i=0;i<property.Y_skill.length;++i)			
					property.skillUse.get(i).setEnabled(true);
			}
		}, 3000);
		
		

		System.out.println("fuck");
	}
	public void actionPerformed(ActionEvent e) {
		int blood;
		int attack;	
		switch (e.getActionCommand()) {
		case "coffee":
			blood=property.blooBar.getValue();
			property.Y_blood=blood+10;
			property.blooBar.setValue(blood+10);
			allAnnounce.setText("使用咖啡!");		
		break;
		case "redBlue":
			blood=property.blooBar.getValue();
			property.Y_blood=blood*2;
			property.blooBar.setValue(blood*2);
			allAnnounce.setText("使用redBlue!");		
		break;
		case "leg":
			attack=(property.Y_attack+=10);
			property.Y_attackText.setText("攻擊力:"+attack);
			allAnnounce.setText("使用學霸大腿!");
			
		break;
		case "underwear":
			//System.out.println(property.Y_attack);
			property.Y_attack+=20;
			attack=property.Y_attack;
			property.Y_attackText.setText("攻擊力:"+attack);
			allAnnounce.setText("使用學霸小褲褲!");
		break;
		case "G_test":
			attack=(property.M_attack-=-10);
			property.M_attackText.setText("攻擊力:"+attack);
			allAnnounce.setText("使用一般考古!");
		break;
		default:
			break;
		}
		for(int i=0;i<property.skillUse.size();++i)
			//System.out.println(property.skillUse.get(i));
			property.skillUse.get(i).setEnabled(false);
			
			
		
		AnnounceSkill.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				allAnnounce.setText("");
				round=true;
				StartGame();
				
			}
		}, 2000);
		
		

	}
	private void addButtonEvent() {
		for(int i=0;i<property.skillUse.size();++i)
		{
			//System.out.println(property.skillUse.get(i));
			property.skillUse.get(i).addActionListener(this);
			property.skillUse.get(i).setEnabled(false);
			
		}
		//System.out.println(property.skillUse.get(0).getActionListeners().length);
		
	}
	private void playerRound() {
		int tempWidth=property.playerWidth;
		int tempHeight=property.playerHeight;
		int tempX=property.player.getLocation().x;
		int tempY=property.player.getLocation().y;
		
		//這裡跑腳色動畫
		property.playerImageNum=0;
		property.playerPath="image\\playerAttack\\player";
		property.playerWidth=400;
		property.playerHeight=500;
		property.player.setLocation(500,100);
		property.player.setSize(400,500);
		
		//腳色攻擊
		
		property.M_blood-=property.Y_attack;
		property.M_blooBar.setValue(property.M_blood);
		++property.M_power;
		
		
		//等技能跑完
		try {
			Thread.sleep(2300);
		} catch (InterruptedException exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}
		
		
		//技能施展完要回來
		property.playerPath="image\\player\\player0";
		property.playerWidth=tempWidth;
		property.playerHeight=tempHeight;
		property.player.setLocation(tempX,tempY);
		property.player.setSize(tempWidth,tempHeight);
		
	}
	private void monsterRound() {
		
		allAnnounce.setText("敵方回合!");
		AnnounceRound.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				allAnnounce.setText("");
				property.powerBar.setValue(property.M_power);//power上升
				property.Y_blood-=property.M_attack;
				property.blooBar.setValue(property.Y_blood);
			}
		}, 3000);

	}
	
	//按下button會開始
	public void StartGame() {
		//我的回合 
		playerRound();
		monsterRound();	
		//等敵方回合跑完
		try {
			Thread.sleep(5000);
		} catch (InterruptedException exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}
		System.out.println("successful");
		allAnnounce.setText("我的回合!");
		AnnounceRound.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				allAnnounce.setText("");
				for(int i=0;i<property.skillUse.size();++i)
					//System.out.println(property.skillUse.get(i));
					property.skillUse.get(i).setEnabled(true);
			}
		}, 3000);

		
		 
	 }
	
}
