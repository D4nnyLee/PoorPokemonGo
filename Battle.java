
import java.awt.Color;
import java.awt.Font;
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
	 private Timer gameTimer=new Timer();
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
		gameTimer.schedule(new TimerTask() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				StartGame();
			}
		}, 0, 2000);

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
		AnnounceSkill.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				allAnnounce.setText("");
			}
		}, 1000);
		attack=0;
		blood=0;
		

	}
	private void addButtonEvent() {
		for(int i=0;i<property.skillUse.size();++i)
		{
			//System.out.println(property.skillUse.get(i));
			property.skillUse.get(i).addActionListener(this);
			
			
		}
		//System.out.println(property.skillUse.get(0).getActionListeners().length);
		
	}
	
	
	
	public void StartGame() {
		//我的回合 
		if(round)
		{
			allAnnounce.setText("我的回合!");
			AnnounceRound.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					allAnnounce.setText("");
				}
			}, 1000);
			round=false;
		}
		else {
			allAnnounce.setText("敵方回合!");
			AnnounceRound.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					allAnnounce.setText("");
				}
			}, 1000);
			round=true;
		}
		 
	 }
	
}
