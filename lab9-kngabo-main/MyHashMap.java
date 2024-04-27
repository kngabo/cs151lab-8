import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * The MyHashMap class implements the Map ADT using a hashtable.
 * 
 * @author Your Name Here!
 */
public class MyHashMap<K, V> {
    /* TODO: add your instance variables here */

    private LinkedList<SimpleEntry<K, V>>[] hashtable;

    private int size;

    /** The initial length to use for the hashtable. */
    private static final int INITIAL_LENGTH = 11;

    /** The load factor to use for deciding when to resize our hashtable. */
    private static final float LOAD_FACTOR = 0.75f;

    /** An array of possible table sizes. */
    private static final int TABLE_SIZE[] = { 5, 11, 23, 47, 97, 197, 397, 797, 1597, 3203, 6421, 12853, 25717, 51437,
            102877, 205759, 411527, 823117, 1646237, 3292489, 6584983, 13169977, 26339969, 52679969, 105359939,
            210719881, 421439783, 842879579, 1685759167 };

    /**
     * Creates a new MyHashMap.
     */
    public MyHashMap() {
        /* TODO: implement this constructor */
        this.size = 0;
        this.hashtable = createTable(INITIAL_LENGTH); 
    }

    /**
     * Create a new array of {@link LinkedList}s with a prime length.
     * 
     * @param length The minimum length of the array
     * 
     * @return The new array with empty {@link LinkedList}s
     */
    @SuppressWarnings("unchecked")
    private LinkedList<SimpleEntry<K, V>>[] createTable(int length) {
        // get the closest prime length
        for (int primeCapacity : TABLE_SIZE) {
            if (primeCapacity >= length) {
                length = primeCapacity;
                break;
            }
        }

        // create the array of empty lists
        LinkedList<SimpleEntry<K, V>>[] list = (LinkedList<SimpleEntry<K, V>>[]) new LinkedList[length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<SimpleEntry<K, V>>();
        }

        return list;
    }

    /* TODO: implement your other methods here */

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void clear(){
        for (LinkedList<SimpleEntry<K, V>> value : hashtable) {
            value.clear();
        }
    }

    private SimpleEntry<K, V> find(K key){

        int hash = key.hashCode() & Integer.MAX_VALUE;
        int index = hash % this.hashtable.length;

        LinkedList<SimpleEntry<K, V>> bucket = hashtable[index];

        if(bucket != null){
            for (SimpleEntry<K, V> value : bucket) {
                if(value.getKey() == key){
                    return value;
                }
            }
        }    

        return null;
    }

    public V get(K key){
        SimpleEntry<K, V> entry = find(key);

        if(entry != null){
            return entry.getValue();
        }

        return null;
    }

        private void insert(SimpleEntry<K, V> entry){
            
            K key = entry.getKey();

            if(find(key) != null){
                int hash = key.hashCode() & Integer.MAX_VALUE;
                int index = hash % this.hashtable.length;
                LinkedList<SimpleEntry<K, V>> bucket = hashtable[index];
                bucket.add(entry);
            }
        }

        private void resize(){
            LinkedList<SimpleEntry<K, V>>[] oldHashtable = this.hashtable;
            LinkedList<SimpleEntry<K, V>>[] newHashtable = createTable(oldHashtable.length * 2);
        }

}
