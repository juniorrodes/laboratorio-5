package tests;

// import JUnit packages
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// services import
import services.ContactController;
import services.utils.Contact;

public class ContactControllerTest {

    ContactController contactController;

    /**
     Function to create a dummy contact in the test class.
     The argument name need to contain a first name and last name separated by space
     */
    private Contact createDummyContact(String name, String contactNumber) {
        String[] names = name.split(" ");
        return new Contact(names[0], names[1], contactNumber);
    }

    @Before
    public void setUp() {
        this.contactController = new ContactController();
    }

    @Test
    public void testContactCreationSucceed() {
        Contact contact = this.createDummyContact("José Luis", "99999-9999");

        assertTrue(this.contactController.insertNewContact(contact.getNumber(), contact));
        assertEquals(this.contactController.getContact(contact.getNumber()), contact);
    }

    @Test
    public void testContactCreationFail() {
        String contactNumber = "99999-9999";
        Contact contact = this.createDummyContact("José Luis", contactNumber);
        Contact contactReplace = this.createDummyContact("João Maciel", contactNumber);

        this.contactController.insertNewContact(contact.getNumber(), contact);
        assertFalse(this.contactController.insertNewContact(contactReplace.getNumber(), contactReplace));
        assertEquals(this.contactController.getContact(contactNumber), contact);
    }

    @Test
    public void testContactReplacement() {
        String contactNumber = "99999-9999";
        Contact contact = this.createDummyContact("José Luis", contactNumber);
        Contact contactReplace = this.createDummyContact("João Maciel", contactNumber);

        this.contactController.insertNewContact(contact.getNumber(), contact);
        assertFalse(this.contactController.insertNewContact(contactReplace.getNumber(), contactReplace));
        assertEquals(this.contactController.replaceContact(contactNumber, contactReplace), contact);
        assertEquals(this.contactController.getContact(contactNumber), contactReplace);
    }

}
