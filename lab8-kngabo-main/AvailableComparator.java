import java.util.Comparator;

/**
 * The AvailableComparator class implements a {@link Comparator} for {@link Task}s
 * that compares based on the {@code availableTime} instance variable.
 * 
 * @author CS Professors
 */
public class AvailableComparator implements Comparator<Task> {
	/**
     * Compares two {@link Task}s based on {@code availableTime}
     *
     * @param t1 The first {@link Task} to compare
     * @param t2 The second {@link Task} to compare
     * @return negative if {@code t1.availableTime} < {@code t2.availableTime}, 
     *         positive if {@code t1.availableTime} > {@code t2.availableTime},
     *         0 if they are equal
     */
    public int compare(Task t1, Task t2) {
        // compare based on the availableTime instance variable
        if (t1.availableTime == t2.availableTime) {
        	return 0;
        } else if (t1.availableTime < t2.availableTime) {
        	return -1;
        } else {
            // t2 must be greater
            return 1;
        }        
    }
}
