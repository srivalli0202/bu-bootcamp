import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContactTest {
    
    @Test
    public void testContactConstructorAndGetters() {
        Contact contact = new Contact("John Doe", "555-1234");
        assertEquals("John Doe", contact.getName());
        assertEquals("555-1234", contact.getPhone());
    }
    
    @Test
    public void testToString() {
        Contact contact = new Contact("Jane Smith", "555-5678");
        String expected = "Jane Smith - 555-5678";
        assertEquals(expected, contact.toString());
    }
    
    @Test
    public void testCompareToSameNames() {
        Contact contact1 = new Contact("Alice", "111-1111");
        Contact contact2 = new Contact("Alice", "222-2222");
        assertEquals(0, contact1.compareTo(contact2));
    }
    
    @Test
    public void testCompareToFirstNameBefore() {
        Contact contact1 = new Contact("Alice", "111-1111");
        Contact contact2 = new Contact("Bob", "222-2222");
        assertTrue(contact1.compareTo(contact2) < 0);
    }
    
    @Test
    public void testCompareToFirstNameAfter() {
        Contact contact1 = new Contact("Bob", "111-1111");
        Contact contact2 = new Contact("Alice", "222-2222");
        assertTrue(contact1.compareTo(contact2) > 0);
    }
    
    @Test
    public void testCompareToCaseInsensitive() {
        Contact contact1 = new Contact("alice", "111-1111");
        Contact contact2 = new Contact("ALICE", "222-2222");
        assertEquals(0, contact1.compareTo(contact2));
    }
    
    @Test
    public void testCompareToDifferentCases() {
        Contact contact1 = new Contact("alice", "111-1111");
        Contact contact2 = new Contact("bob", "222-2222");
        assertTrue(contact1.compareTo(contact2) < 0);
    }
    
    @Test
    public void testContactWithEmptyStrings() {
        Contact contact = new Contact("", "");
        assertEquals("", contact.getName());
        assertEquals("", contact.getPhone());
        assertEquals(" - ", contact.toString());
    }
}
