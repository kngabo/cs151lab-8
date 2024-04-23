import java.util.Comparator;

public class OfficeComparator implements Comparator<Contact> {

    public Contact first;
    public Contact second;
    
    public int compare(Contact first, Contact second){
        return first.getOffice().compareTo(second.getOffice());
    }
}
