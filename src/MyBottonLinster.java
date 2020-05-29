import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBottonLinster implements ActionListener {
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		System.out.println(e.getSource());
		System.out.println("you bad");
	}
}
