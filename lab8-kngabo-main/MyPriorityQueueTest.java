import static org.junit.Assert.assertEquals;
import java.util.Comparator;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MyPriorityQueueTest {
    @Test
    void testOffer() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> pQueue = new MyPriorityQueue<>(comparator);
        Integer[] insertList = {2, 8, 13, 34, 21, 5, 55, 1, 89, 144, 3};

        // Insert elements into the priority queue
        for (Integer item : insertList) {
            pQueue.offer(item);
        }

        // Assert size and check ordering by polling
        assertEquals(insertList.length, pQueue.size());
        Integer previous = null;
        while (!pQueue.isEmpty()) {
            Integer current = pQueue.poll();
            if (previous != null) {
                assertTrue(comparator.compare(previous, current) <= 0);
            }
            previous = current;
        }
    }

    @Test
    void testPoll() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> pQueue = new MyPriorityQueue<>(comparator);
        Integer[] insertList = {2, 8, 13, 34, 21, 5, 55, 1, 89, 144, 3};

        // Insert elements into the priority queue
        for (Integer item : insertList) {
            pQueue.offer(item);
        }

        // Poll elements and check order
        Integer[] sortedList = Arrays.copyOf(insertList, insertList.length);
        Arrays.sort(sortedList);
        for (Integer expected : sortedList) {
            assertEquals(expected, pQueue.poll());
        }
    }
}
