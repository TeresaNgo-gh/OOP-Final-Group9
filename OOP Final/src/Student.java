
public class Student extends Person{
	private int SID;
	private int gradYear;
	private String major = "Undecided";
	
	public Student(String name, int age, int gradYear, int SID) {
		super(name, age);
		this.setEmployee(false);
		this.SID = SID;
		this.gradYear = gradYear;
	}
	
	public Student(String name, int age, int gradYear, int SID, String major) {
		this(name, age, SID, gradYear);
		this.setMajor(major);
	}

	public int getSID() {
		return SID;
	}

	public int getGradYear() {
		return gradYear;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String toString() {
		return "Student name:\t\t" + getName()
				+ "\nAge:\t\t\t" + getAge() 
				+ "\nGraduation year:\t" + getGradYear()
				+ "\nMajor:\t\t\t" + getMajor()
				+ "\nStudent ID:\t\t" + getSID();
	}
}
