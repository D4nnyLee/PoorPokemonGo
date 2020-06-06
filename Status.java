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
		skill.put("coffee",2);
		skill.put("H_test",5);
		skill.put("underwear",8);
	}
	private void setStatus() {
		switch (name) {
		
		case"assistant":
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
		case "blue":
		//這邊打完所有教授的case
			attack=10;
			blood=100;
			money=50;
			power=10;
		case "boss":
			attack=10;
			blood=200;
			money=100;
			power=10;
		default:
			break;
		}
	}
}

