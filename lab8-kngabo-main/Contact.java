import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The {@link Contact} class represents the contact information
 * for a faculty or staff member in the College.
 * 
 * @author CS Professors
 */
public class Contact {
    /** The name of the faculty or staff member. */
    private String name;

    /** The office location of the faculty or staff member. */
    private String office;

    /**
     * Constructs a new Contact.
     * 
     * @param name The name of the faculty or staff member
     * @param office The office location of the faculty or staff member
     */
    public Contact(String name, String office) {
        this.name = name;
        this.office = office;
    }

    /**
     * Gets the name of the faculty or staff member.
     * 
     * @return The name of the faculty or staff member
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the office location of the faculty or staff member.
     * 
     * @return The office location of the faculty or staff member
     */
    public String getOffice() {
        return office;
    }

    /**
     * The main method of this program.  Used for testing Comparators and their 
     * uses.
     * 
     * @param args The command line arguments (unused)
     */
    public static void main(String[] args) {
        /* This first set of lines helps us see what happens when we use 
           the NameComparator class to compare two Contacts. */
        
        // create a few contacts
        Contact c1 = new Contact("Adam", "King 125B");
        Contact c2 = new Contact("Howard", "King 139C");
        Contact c3 = new Contact("Jackie", "King 139");

        // now create a comparator
        NameComparator nameComparator = new NameComparator();

        // check what is returned by the compare method (based on the name instance variable)
        System.out.println("c1 compare c2: " + nameComparator.compare(c1, c2));
        System.out.println("c1 compare c1: " + nameComparator.compare(c1, c1));
        System.out.println("c2 compare c1: " + nameComparator.compare(c2, c1));
        System.out.println(); // add a blank line of output
        // [REMOVE THIS LINE TO TEST] */

        /* The rest of this code investigates what happens when we use 
         * both comparators to help us sort data. */
        
        // create some more Contacts
        Contact c4 = new Contact("Emily", "King 139A");
        Contact c5 = new Contact("Cynthia", "King 139B");
        Contact c6 = new Contact("Josh", "King 229");
        Contact c7 = new Contact("Steve", "King 231");        
        Contact c8 = new Contact("Molly", "King 223A");
        Contact c9 = new Contact("Michael", "King 223B");
        Contact c10 = new Contact("Lucas", "King 223C");
        
        // create a list of all of the Contacts
        Contact[] array = new Contact[]{c1, c2, c3, c4, c5, c6, c7, c8, c9, c10};
        List<Contact> csOffices = Arrays.asList(array);

        // print the contacts as we added them
        for (Contact contact : csOffices) {
            System.out.println(contact.getName() + " is in " + contact.getOffice());
        }
        System.out.println(); // add a blank line of output

        // sort the list by name
        Collections.sort(csOffices, nameComparator);

        // print the contacts again
        for (Contact contact : csOffices) {
            System.out.println(contact.getName() + " is in " + contact.getOffice());
        }
        System.out.println(); // add a blank line of output

        // now sort the list by office
        OfficeComparator officeComparator = new OfficeComparator();
        Collections.sort(csOffices, officeComparator);

        // print the contacts again
        for (Contact contact : csOffices) {
            System.out.println(contact.getName() + " is in " + contact.getOffice());
        }
        // [REMOVE THIS LINE TO TEST] */
    }
}
