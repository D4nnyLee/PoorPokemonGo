import java.util.Hashtable;
import java.util.jar.Attributes.Name;

public class Status {
	
	
	
	public int attack;
	public int blood;
	public int exp;
	public int money;
	public Hashtable<String,Integer> skill;
	public int power;
	public String name;
	Status(String n){

		this.name=n;
		setStatus();
		skill=new Hashtable<String, Integer>();
		skill.put("None",2);
	}
	private void setStatus() {
		switch (name) {
		case"player":
			attack=20;
			blood=0;
			money=10000000;
			break;
		case"TA":
			attack=10;
			blood=25;
			money=10;
			power=0;
			break;
		case "DataStructure":
			attack=20;
			blood=100;
			money=50;
			power=0;		
		break;
		case "ComputerScience":
		//這邊打完所有教授的case
			attack=30;
			blood=100;
			money=50;
			power=10;
		case "pein":
			attack=10;
			blood=100;
			money=100;
			power=10;
		default:
			break;
		}
	}
}

