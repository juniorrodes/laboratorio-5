package tests;

// import JUnit packages
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

// services import
import controllers.ContactController;
import services.utils.ContactInfo;

public class ContactInfoControllerTest {

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
        ContactInfo contactInfo = this.createDummyContact("José Luis", "99999-9999");

        //assertTrue(this.contactController.insertNewContact(contactInfo.getNumber(), contactInfo));
        assertEquals(this.contactController.getContact("99999-9999"), contactInfo);
    }

    @Test
    public void testContactCreationFail() {
        String contactNumber = "99999-9999";
        ContactInfo contactInfo = this.createDummyContact("José Luis", contactNumber);
        ContactInfo contactInfoReplace = this.createDummyContact("João Maciel", contactNumber);

        //this.contactController.insertNewContact(contactInfo.getNumber(), contactInfo);
        //assertFalse(this.contactController.insertNewContact(contactInfoReplace.getNumber(), contactInfoReplace));
        assertEquals(this.contactController.getContact(contactNumber), contactInfo);
    }

    @Test
    public void testContactReplacement() {
        String contactNumber = "99999-9999";
        ContactInfo contactInfo = this.createDummyContact("José Luis", contactNumber);
        ContactInfo contactInfoReplace = this.createDummyContact("João Maciel", contactNumber);

        //this.contactController.insertNewContact(contactInfo.getNumber(), contactInfo);
        //assertFalse(this.contactController.insertNewContact(contactInfoReplace.getNumber(), contactInfoReplace));
        //assertEquals(this.contactController.replaceContact(contactNumber, contactInfoReplace), contactInfo);
        assertEquals(this.contactController.getContact(contactNumber), contactInfoReplace);
    }

}
