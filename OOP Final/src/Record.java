
public class Record {
	int BID;
	String bookName;
	String studentName;
	int SID;
	int recordNumber;
	boolean renting;
	
	public Record(Book b, Student s, int recordNumber, boolean renting) {
		this.BID = b.getBID();
		this.SID = s.getSID();
		this.recordNumber = recordNumber;
		this.renting = renting;
		this.bookName = b.getName();
		this.studentName = s.getName();
		
		b.setBorrowed(renting);
	}
	
	public String toString() {
		if(renting) {
			return "(" + recordNumber + ") " + bookName + ", rented by " + studentName;
		} else {
			return "(" + recordNumber + ") " + bookName + ", returned by " + studentName;
		}
	}
}
