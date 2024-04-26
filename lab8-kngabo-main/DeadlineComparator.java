import java.util.Comparator;

public class DeadlineComparator implements Comparator<Task> {
	/**
     * Compares two {@link Task}s based on {@code deadline}
     *
     * @param t1 The first {@link Task} to compare
     * @param t2 The second {@link Task} to compare
     * @return negative if {@code t1.deadline} < {@code t2.deadline}, 
     *         positive if {@code t1.deadline} > {@code t2.deadline},
     *         0 if they are equal
     */
    public int compare(Task t1, Task t2) {
        // compare based on the deadline instance variable
        if (t1.deadline == t2.deadline) {
        	return 0;
        } else if (t1.deadline < t2.deadline) {
        	return -1;
        } else {
            // t2 must be greater
            return 1;
        }        
    }
}
