
public class Employee extends Person {
	private int EID;
	
	public Employee(String name, int age, int EID) {
		super(name, age);
		this.EID = EID;
		this.setEmployee(true);
	}

	public int getEID() {
		return EID;
	}
}
