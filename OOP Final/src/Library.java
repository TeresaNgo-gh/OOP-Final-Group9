import java.util.ArrayList;
import java.util.Scanner;

public class Library {


	static ArrayList<Book> books = new ArrayList<Book>();
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Record> record = new ArrayList<Record>();

	static int numOfBooks = 0;
	static int numOfEmployees = 0;
	static int numOfStudents = 0;

	public static void addBook(String name, String publisher, String author, int year){
		books.add(new Book(name, publisher, author, year, numOfBooks));
		numOfBooks ++;
	}

	public static void addEmployee(String name, int age) {
		employees.add(new Employee(name, age, numOfEmployees));
		numOfEmployees ++;
	}

	public static void addStudent(String name, int age, int gradYear) {
		students.add(new Student(name, age, gradYear, numOfStudents));
		numOfStudents ++;
	}

	public static void rentBook(Book b, Student s) {
		record.add(new Record(b, s, record.size(), true));
	}

	public static void returnBook(Book b, Student s) {
		record.add(new Record(b, s, record.size(), false));
	}

	private static void setup() {
		addBook("A Game of Thrones", "Bantam Books", "George R.R. Martin", 1996);
		addBook("A Clash of Kings", "Bantam Books", "George R.R. Martin", 1998);
		addBook("A Storm of Swords", "Bantam Books", "George R.R. Martin", 2000);
		addBook("A Feast for Crows", "Bantam Books", "George R.R. Martin", 2005);
		addBook("A Dance with Dragons", "Bantam Books", "George R.R. Martin", 2011);

		addEmployee("Admin", -1);
		addEmployee("Brady Weiman", 21);
		addEmployee("Goose", 3);

		addStudent("John Doe", 19, 2022);
		addStudent("Jane Doe", 25, 2021);

		rentBook(books.get(2), students.get(0));
	}

	public static void main(String args[]) {

		setup();

		Scanner input = new Scanner(System.in);

		while(true) {
			System.out.println("Welcome to the Library System. \n"
					+ "You can do the following actions: \n"
					+ "(1) Student login \n"
					+ "(2) Employee login \n"
					+ "(3) Exit the system");

			int action = 0;

			// Select student/employee login
			while (true) {
				try {
					String line = input.nextLine();
					action = Integer.parseInt(line);
					if(action == 1 || action == 2 || action == 3) {
						break;
					}
					System.out.println("Invalid action. Please re-enter the action number:");
				} catch(Exception e) {
					System.out.println("Invalid action. Please re-enter the action number:");
				}
			}

			if(action == 3) {
				return;
			}

			// Student login
			if(action == 1) {
				System.out.println("Please enter your Student ID:");
				Student currentStudent = null;
				while(true) {
					try {
						String line = input.nextLine();
						action = Integer.parseInt(line);
						currentStudent = students.get(action);
						break;
					} catch(Exception e) {
						System.out.println("Invalid Student ID number. Please re-enter:");
					}
				}

				System.out.println("Welcome, " + currentStudent.getName() + "!\n");

				// Student
				student: while(true) {
					System.out.println("You can do the following actions:\n"
							+ "(1) Check your student info\n"
							+ "(2) Rent a book\n"
							+ "(3) Return a book\n"
							+ "(4) Log out");

					// Student action
					while(true) {
						try {
							String line = input.nextLine();
							action = Integer.parseInt(line);
							if(action == 1 || action == 2 || action == 3 || action == 4) {
								break;
							}
						} catch(Exception e) {
							System.out.println("Invalid action. Please re-enter the action number:");
						}
					}

					// logout
					if(action == 4) {
						break;
					}

					// Check student status
					else if(action == 1) {
						System.out.println(currentStudent);
					}

					// Rent a book

					else if(action == 2) {

						System.out.println("Which book would you like to rent?");
						for(Book b : books) {
							System.out.println(b);
						}

						Book b = null;

						while(true) {
							try {
								String line = input.nextLine();
								action = Integer.parseInt(line);
								b = books.get(action);
								if(b.isBorrowed()) {
									System.out.println("The book is already rented :(");
									continue student;
								}
								break;
							} catch(Exception e) {
								System.out.println("Invalid Book ID. Please re-enter:");
							}
						}

						rentBook(b, currentStudent);
						System.out.println("You have successfully rented the book!");
					}

					// return a book
					else if(action == 3) {
						int count = 0;
						for(Book b : books) {
							for(int i = record.size()-1; i >= 0; i --) { 
								if(b.getBID() == record.get(i).BID && record.get(i).renting && b.isBorrowed() && currentStudent.getSID() == record.get(i).SID) {
									System.out.println(record.get(i));
									count ++;
									break;
								}
							}
						}

						if(count == 0) {
							System.out.println("Sorry, it seems like you haven't rented any books yet :(");
							continue;
						} 

						while(true) {
							try {
								String line = input.nextLine();
								action = Integer.parseInt(line);

								if(record.get(action).SID == currentStudent.getSID()) {
									break;
								}

								System.out.println("Invalid action. Please re-enter:");

							} catch(Exception e) {
								System.out.println("Invalid action. Please re-enter:");
							}
						}

						returnBook(books.get(record.get(action).BID), currentStudent);
						System.out.println("You have successfully returned the book!");
					}
				}
			}

			else if(action == 2) {

				System.out.println("Please enter your Employee ID:");
				Employee currentEmployee = null;
				while(true) {
					try {
						String line = input.nextLine();
						action = Integer.parseInt(line);
						currentEmployee = employees.get(action);
						break;
					} catch(Exception e) {
						System.out.println("Invalid Employee ID number. Please re-enter:");
					}
				}

				System.out.println("Welcome, " + currentEmployee.getName() + "!");

				// Employee actions
				while(true) {
					System.out.println("You can do the following actions:\n"
							+ "(1) Register a student\n"
							+ "(2) Check rent records\n"
							+ "(3) Log out");

					// Employee action
					while(true) {
						try {
							String line = input.nextLine();
							action = Integer.parseInt(line);
							if(action == 1 || action == 2 || action == 3) {
								break;
							}
						} catch(Exception e) {
							System.out.println("Invalid action. Please re-enter the action number:");
						}
					}

					if(action == 3) {
						break;
					}

					else if(action == 1) {
						System.out.println("Please enter the student's name:");
						String name = input.nextLine();
						System.out.println("Pleast enter the student's age:");
						while(true) {
							try {
								String line = input.nextLine();
								action = Integer.parseInt(line);
								break;
							} catch(Exception e) {
								System.out.println("Invalid action. Please re-enter the age:");
							}
						}
						int age = action;
						System.out.println("Please enter the graduation year:");
						while(true) {
							try {
								String line = input.nextLine();
								action = Integer.parseInt(line);
								break;
							} catch(Exception e) {
								System.out.println("Invalid action. Please re-enter the graduation year:");
							}
						}
						int gradYear = action;

						addStudent(name, age, gradYear);
						System.out.println("Student added! Their student ID is " + (students.size() - 1) + ".");
					}

					else if(action == 2) {
						System.out.println("Here's the complete record:");

						for(Record r : record) {
							System.out.println(r);
						}
					}
				}
			}
		}
	}
}
