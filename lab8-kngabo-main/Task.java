/**
 * The Task class represents a computing task.
 * 
 * @author CS Professors
 */
public class Task {
	/** The name of the task. */
	public String name;

	/** The priority of the task. */
	public int priority;

	/** The available time of the task. */
	public int availableTime;

	/** The length of the task (in time). */
	public int length;

	/** The deadline of when the task must be accomplished. */
	public int deadline;
	
	/**
	 * Constructs a new Task.
	 * 
	 * @param name The name of the task
	 * @param priority The priority of the task
	 * @param availableTime The available time of the task
	 * @param length The length of the task (in time)
	 * @param deadline The deadline of when the task must be accomplished
	 */
	public Task(String name, int priority, int availableTime, int length, 
				int deadline) {
		this.deadline = deadline;
		this.name = name;
		this.availableTime = availableTime;
		this.length = length;
		this.deadline = deadline;
		this.priority = priority;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Task [name=" + name + ", priority=" + priority + ", availableTime=" + availableTime + ", length="
				+ length + ", deadline=" + deadline + "]";
	}
}
