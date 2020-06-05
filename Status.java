import java.util.jar.Attributes.Name;

public class Status {
	
	
	
	public int attack;
	public int blood;
	public int exp;
	public int money;
	public String []skill;
	public int power;
	public String name;
	Status(String n){

		this.name=n;
		setStatus();
	}
	private void setStatus() {
		switch (name) {
		case"player":
			attack=10;
			blood=100;
			String []temp= {"coffee","redBlue","ticket","medician","phone","mask","leg","underwear","G_test","H_test","None"};
			skill=temp;
			break;
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

