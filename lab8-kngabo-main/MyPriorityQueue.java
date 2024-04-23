import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class MyPriorityQueue<T> extends AbstractQueue<T> {

    private ArrayList<T> heap;
    private Comparator<T> comparator;
}
