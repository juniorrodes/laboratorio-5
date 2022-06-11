// import JUnit packages
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// services import
import controllers.ContactController;
import utils.ContactInfo;

public class ContactControllerTest {

    ContactController contactController;

    /**
     Function to create a dummy contact in the test class.
     The argument name need to contain a first name and last name separated by space
     */
    private ContactInfo createDummyContact(String name, String contactNumber) {
        String[] names = name.split(" ");
        return new ContactInfo(names[0], names[1]);
    }

    @Before
    public void setUp() {
        this.contactController = new ContactController();
    }

    @Test
    public void testContactCreationSucceed() {
        String contactNumber = "99999-9999";
        ContactInfo contactInfo = this.createDummyContact("José Luis", contactNumber);
        assertTrue(this.contactController.insertNewContact(contactNumber, contactInfo));
        assertEquals(this.contactController.getContact("99999-9999"), contactInfo);
    }

    @Test
    public void testContactCreationFail() {
        String contactNumber = "99999-9999";
        ContactInfo contactInfo = this.createDummyContact("José Luis", contactNumber);
        ContactInfo contactInfoReplace = this.createDummyContact("Guilherme Lacerda", contactNumber);

        this.contactController.insertNewContact(contactNumber, contactInfo);
        assertFalse(this.contactController.insertNewContact(contactNumber, contactInfoReplace));
        assertEquals(this.contactController.getContact(contactNumber), contactInfo);
    }

    @Test
    public void testContactReplacement() {
        String contactNumber = "99999-9999";
        ContactInfo contactInfo = this.createDummyContact("José Luis", contactNumber);
        ContactInfo contactInfoReplace = this.createDummyContact("João Maciel", contactNumber);

        this.contactController.insertNewContact(contactNumber, contactInfo);
        assertFalse(this.contactController.insertNewContact(contactNumber, contactInfoReplace));
        this.contactController.replaceContact(contactNumber, contactInfoReplace);
        assertEquals(this.contactController.getContact(contactNumber), contactInfoReplace);
    }

}
