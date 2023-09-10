import java.util.Comparator;
import java.util.PriorityQueue;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + '}';
	}
}

class AgeComparator implements Comparator<Person> {
	@Override
	public int compare(Person person1, Person person2) {
		// Compare persons based on their age
		return Integer.compare(person1.getAge(), person2.getAge());
	}
}

public class QueueDemo {
	public static void main(String[] args) {
		// Create a priority queue of Person objects using the custom comparator
		PriorityQueue<Person> priorityQueue = new PriorityQueue<>(new AgeComparator());

		// Adding persons to the priority queue
		priorityQueue.add(new Person("Alice", 30));
		priorityQueue.add(new Person("Bob", 25));
		priorityQueue.add(new Person("Charlie", 35));

		System.out.println("Priority Queue elements (sorted by age ascending):");
		while (!priorityQueue.isEmpty()) {
			Person person = priorityQueue.poll();
			System.out.println(person);
		}
	}
}

