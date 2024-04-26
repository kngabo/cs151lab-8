import java.util.Comparator;

public class PriorityComparator implements Comparator<Task> {
	/**
     * Compares two {@link Task}s based on {@code priority}
     *
     * @param t1 The first {@link Task} to compare
     * @param t2 The second {@link Task} to compare
     * @return negative if {@code t1.priority} < {@code t2.priority}, 
     *         positive if {@code t1.priority} > {@code t2.priority},
     *         0 if they are equal
     */
    public int compare(Task t1, Task t2) {
        // compare based on the priority instance variable
        if (t1.length == t2.length) {
        	return 0;
        } else if (t1.priority < t2.priority) {
        	return -1;
        } else {
            // t2 must be greater
            return 1;
        }        
    }
}