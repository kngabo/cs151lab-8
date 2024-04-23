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

    public int parent(int index){
        return index/2;
    }

    public int leftChild(int index){
        return 2 * index;
    }

    public int Child(int index){
        return 2 * index + 1;
    }

    public boolean offer(T item){
        int size = this.size();
        this.heap.add(item);
        percolateUp(this.heap.size());
        
        return this.size() == size + 1 ;
    }

    private void percolateUp(int index){

        int parent = parent(index);

        if(parent(index) == 0){
            return;
        }

        if(comparator.compare(this.heap.get(index), this.heap.get(parent)) < 0){
            this.heap.set(parent, this.heap.get(index));
            this.heap.set(index, this.heap.get(parent));

            percolateUp(parent);
        }
    }
}
