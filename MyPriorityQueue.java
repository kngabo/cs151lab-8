import java.util.*;

public class MyPriorityQueue<T> extends AbstractQueue<T>{
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    public MyPriorityQueue(Comparator<T> comparator){
        this.heap = new ArrayList<T>();
        this.comparator = comparator;
        this.heap.add(null);
    }

    public Comparator<T> getComparator(){
        return this.comparator;
    }

    public Iterator<T> iterator(){
        return this.heap.iterator();
    }

    public int size(){
        return this.heap.size() - 1;
    }

    public void clear(){
        this.heap.clear();
        this.heap.add(null);
    }
}
