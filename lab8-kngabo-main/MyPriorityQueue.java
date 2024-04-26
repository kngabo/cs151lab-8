import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

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

    public int rightChild(int index){
        return 2 * index + 1;
    }

    public boolean offer(T item){
        int size = this.size();
        this.heap.add(item);
        percolateUp(this.heap.size() - 1);
        
        return this.size() == size + 1 ;
    }

    private void percolateUp(int index){

    
        int parent = parent(index);

        if(parent == 0){
            return;
        }

        if(this.comparator.compare(this.heap.get(index), this.heap.get(parent)) < 0){

            T temp = this.heap.get(parent);
            this.heap.set(parent, this.heap.get(index));
            this.heap.set(index, temp);

            percolateUp(parent);
        }
    }

    public T poll() {

        if(this.heap.size() <= 0){
            return null;
        }

        T root = this.heap.get(1);
        T lastItem = this.heap.get(this.heap.size()-1);

        if(this. heap.size() > 0){
            this.heap.set(1, lastItem);
            int last = this.heap.size() - 1;
            this.heap.remove(last);
            percolateDown(1);
        }
        return root;
    }

    private void percolateDown(int index) {
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        int smallest = index;
    
        if (leftChildIndex < this.heap.size() && this.comparator.compare(this.heap.get(leftChildIndex), this.heap.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
    
        if (rightChildIndex < this.heap.size() && this.comparator.compare(this.heap.get(rightChildIndex), this.heap.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
    
        if (smallest != index) {
            T temp = this.heap.get(index);
            this.heap.set(index, this.heap.get(smallest));
            this.heap.set(smallest, temp);
            percolateDown(smallest);  
        }
    }
    


    @Override
    public T peek() {
        return this.heap.get(1);
    }
}
