public class Contact implements Comparable<Contact> {
	private String name;
	private String phone;

	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
// constructors, getters
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}
// override toString and compareTo methods
	@Override
	public String toString() {
		return name + " - " + phone;
	}

	@Override
	public int compareTo(Contact other) {
		return this.name.compareToIgnoreCase(other.name);
	}
}
