import java.util.Comparator;

public class NameComparator implements Comparator<Contact>{

    public Contact first;
    public Contact second;
    
    public int compare(Contact first, Contact second){
        return first.getName().compareTo(second.getName());
    }
}
