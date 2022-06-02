package banking;

import java.util.Objects;

public class Person extends AccountHolder {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName, int idNumber) {
		super(idNumber);
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getFirstName() {
		        return this.firstName;
	}

	public String getLastName() {
		// complete the function
        return this.lastName;
	}


}
