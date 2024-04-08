import java.util.PriorityQueue;

public class SecurityLine {
    private PriorityQueue<Person> queue;

    public SecurityLine() {
        this.queue = new PriorityQueue<>();
    }

    public void addPerson(Person person) {
        queue.add(person);
    }

    public Person processNext() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        SecurityLine line = new SecurityLine();
        line.addPerson(new Person("Muhammad", PersonType.ECONOMY));
        line.addPerson(new Person("Captain Ali", PersonType.FLIGHT_STAFF));
        line.addPerson(new Person("Zainab", PersonType.VIP));
        line.addPerson(new Person("Abdullah", PersonType.ECONOMY));
        line.addPerson(new Person("Fatima", PersonType.ECONOMY));

        System.out.println("Processing order:");
        while (!line.queue.isEmpty()) {
            System.out.println(line.processNext());
        }
    }
}
