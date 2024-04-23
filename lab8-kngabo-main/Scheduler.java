import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The Scheduler class schedules {@link Task}s.
 * 
 * @author CS Professors
 */
public class Scheduler {
	/**
	 * Constructs a new Scheduler.
	 */
	public Scheduler() {
		// nothing to do
	}

	/**
	 * Reads the {@link Task}s from a given filename and saves them in a
	 * {@link MyPriorityQueue} sorted by the available instance variable (i.e., when
	 * they would be started by a user).
	 * 
	 * @param filename The name of the file containing the {@link Task}s
	 * 
	 * @return A {@link MyPriorityQueue} of {@link Task}s in {@code filename}
	 */
	private MyPriorityQueue<Task> readTasks(String filename) {
		MyPriorityQueue<Task> tasks = new MyPriorityQueue<Task>(new AvailableComparator());
		
		// read in the tasks
		Scanner input = null;
		try{
			input = new Scanner(new File(filename));
			while (input.hasNextLine() && input.hasNext()) {
				String name = input.next();
				System.out.println(name);
				int priority = input.nextInt();
				int availableTime = input.nextInt();
				int length = input.nextInt();
				int deadline = input.nextInt(); 
				Task task = new Task(name, priority, availableTime, length, deadline);
				
				tasks.offer(task);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Missing file: " + filename);
			System.exit(-1);
		} finally {
			if (input != null) {
				input.close();
			}
		}

		return tasks;
	}

	/**
	 * Creates an empty {@link MyPriorityQueue} with a given type of
	 * {@link Comparator}.
	 * 
	 * @param sortType The type of {@link Comparator} to use
	 * 
	 * @return An empty {@link MyPriorityQueue}
	 */
	private MyPriorityQueue<Task> createPriorityQueue(String sortType) {
		// create the appropriate comparator
		Comparator<Task> comparator = null;
		
		if (sortType.equals("available")) {
			comparator = new AvailableComparator();
			System.out.println("Scheduling jobs by Availability");
		} else if (sortType.equals("priority")) {
			comparator = new PriorityComparator();
			System.out.println("Scheduling jobs by Priority");
		} else if (sortType.equals("deadline")) {
			comparator = new DeadlineComparator();
			System.out.println("Scheduling jobs by Deadline");
		} else if  (sortType.equals("length")) {
			comparator = new LengthComparator();
			System.out.println("Scheduling jobs by Length");
		} else {
			System.out.println("You have entered an invalid option for sort.  Please enter one of the following:");
			System.out.println("sorttypes: available, priority, deadline, length");
			System.exit(-1);
		} 

		// create the PriorityQueue using that comparator
		return new MyPriorityQueue<Task>(comparator);
	}

	public void run(String filename, String sortType) {
		// read in the tasks
		MyPriorityQueue<Task> tasks = readTasks(filename);

		// create a Priority Queue with the user's desired comparator
		MyPriorityQueue<Task> runOrder = createPriorityQueue(sortType);

		// some variables for keeping track of what happens when the Tasks run
		int time = 0;
		boolean currentlyRunning = false;
		Task currentTask = null;
		int startTime = 0;
		int missedDeadlines = 0;
		int missedMillis = 0;
		int[] priorities = new int[10];
		int priorityInversions = 0;
		
		// run as long as there are still tasks to go
		while (tasks.size() + runOrder.size() > 0) {
			// is a task available to run?
			while (tasks.size() > 0) {
				Task task = tasks.peek();
				if (task.availableTime <= time) {
					// the task can enqueue
					runOrder.offer(tasks.poll());
					priorities[task.priority] = priorities[task.priority] + 1;

					// System.out.println("\nEnqueued:");
					// for (Task printTask : tasks) {
					// 	System.out.println(printTask);
					// }
					// System.out.println("");
				} else {
					break;
				}
			}
			
			// check if the current task should end
			if (currentlyRunning) {
				if (time >= startTime + currentTask.length) {
					currentlyRunning = false;

					// was the task done in time?
					if (startTime + currentTask.length > currentTask.deadline) {
						missedDeadlines = missedDeadlines + 1;
						missedMillis = missedMillis + (startTime + currentTask.length - currentTask.deadline);
					}
					priorities[currentTask.priority] = priorities[currentTask.priority] - 1;
				}
			}
			
			// check if a task should start running
			if (!currentlyRunning) {
				if (runOrder.size() > 0) {
					// get the next task in run order
					currentTask = runOrder.poll();
					currentlyRunning = true;
					startTime = time;
					
					// check for priority inversions (tasks ran out of order)
					for (int i = 0; i < currentTask.priority; i++) {
						if (priorities[i] > 0) {
							priorityInversions = priorityInversions + 1;
							break;
						}
					}
					
					System.out.println("" + time + ": running " + currentTask.name + " priority " + currentTask.priority + " availability " + currentTask.availableTime + " length " + currentTask.length + " deadline " + currentTask.deadline + " " + runOrder.size() + " other jobs in queue.");
				}
			}
			
			// move foreward in time in 10ms increments
			time = time + 10;
		}
		
		System.out.println("All jobs have been run. " + missedDeadlines + " deadlines were missed, by a total of " + missedMillis + " milliseconds.  There were " + priorityInversions + " priority inversions.");
	}

	/**
	 * The main behavior of our program.
	 * 
	 * @param args The command line arguments: (1) a filename of tasks and
	 * 			   (2) an instance variable to sort by
	 */
	public static void main(String[] args) {
		// check if we have enough command line arguments
		if (args.length < 2) {
			System.out.println("Program usage: java Scheduler <filename> <sorttype>");
			System.out.println("sorttypes: available, priority, deadline, length");
			return;
		}

		// parse the arguments
		String filename = args[0];
		String sort = args[1];

		Scheduler scheduler = new Scheduler();
		scheduler.run(filename, sort);
	}
}
