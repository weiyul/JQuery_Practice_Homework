package employee;


public class Employee {
	
	private String FirstName;

	@Override
	public String toString() {
		return "Employees [FirstName=" + FirstName + "]";
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}	
}
