import java.util.Comparator;

public class LengthComparator implements Comparator<Task> {
	/**
     * Compares two {@link Task}s based on {@code length}
     *
     * @param t1 The first {@link Task} to compare
     * @param t2 The second {@link Task} to compare
     * @return negative if {@code t1.length} < {@code t2.length}, 
     *         positive if {@code t1.length} > {@code t2.length},
     *         0 if they are equal
     */
    public int compare(Task t1, Task t2) {
        // compare based on the length instance variable
        if (t1.length == t2.length) {
        	return 0;
        } else if (t1.length < t2.length) {
        	return -1;
        } else {
            // t2 must be greater
            return 1;
        }        
    }
}