import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager {
	public static void main(String[] args) {
		HashMap<String, Contact> contacts = new HashMap<>();

		// Add at least five contacts
		contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 555-0101"));
		contacts.put("Bob", new Contact("Bob", "+1 555-0202"));
		contacts.put("Charlie", new Contact("Charlie", "+1 555-0303"));
		contacts.put("Diana", new Contact("Diana", "+1 555-0404"));
		contacts.put("Eve", new Contact("Eve", "+1 555-0505"));

		// Lookup one contact by name and print details (known)
		String lookupName = "Charlie";
		System.out.println("Lookup result for '" + lookupName + "':");
		Contact found = contacts.get(lookupName);
		if (found != null) {
			System.out.println(found);
		} else {
			System.out.println("Contact not found.");
		}

		// Lookup an unknown contact to show the not-found message
		String unknownName = "Zoe";
		System.out.println("\nLookup result for '" + unknownName + "':");
		Contact notFound = contacts.get(unknownName);
		if (notFound != null) {
			System.out.println(notFound);
		} else {
			System.out.println("Contact not found.");
		}

		// Collect all contacts into an ArrayList, sort alphabetically by name, and print
		ArrayList<Contact> sortedContacts = new ArrayList<>(contacts.values());
		sortedContacts.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));

		System.out.println("\n=== All Contacts ===");
		for (Contact c : sortedContacts) {
			System.out.println(c);
		}
	}
}
