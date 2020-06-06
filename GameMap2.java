import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
public class GameMap2 extends JPanel implements ActionListener{
	private JFrame mainField;
	private JButton b;

	private int Mymoney;
	private Battle battle;
	public GameMap2(JFrame jFrame) {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(Color.green);
		b=new JButton();
		b.setSize(100,100);
		b.setText("按鍵");
		addButtonListener();
		add(b);
		setVisible(true);		
		this.mainField=jFrame;
		
		
		
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				b.setText("按鍵"+e.getKeyChar());
			}
		});

	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		//這裡觸發戰鬥
		Status P=new Status("player");
		//記得給我boss name
		Status M=new Status("boss");
		//傳兩個人的state給我
		battle=new Battle(P,M);
		mainField.add(battle);
		this.setVisible(false);
		Timer listenEnd=new Timer();
		listenEnd.schedule(new TimerTask() {
				
			@Override
			
			public void run() {
				// TODO Auto-generated method stub
				//不斷偵測是否結束
				if(battle.isOver())
				{
					backMap();
					System.out.println("fuck");
					listenEnd.cancel();
					
					
					
				}
				
				
			}
		}, 0, 500);
		
	}
	//戰鬥結束回來
	private void backMap() {
		Mymoney+=battle.getMoney();
		battle.setVisible(false);
		this.setVisible(true);
		battle=null;
	}
	private void addButtonListener() { 
		b.addActionListener(this);
	}
}
