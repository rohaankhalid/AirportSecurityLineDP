public class Person implements Comparable<Person> {
    private static int sequenceGenerator = 0;
    
    String name;
    PersonType type;
    int sequenceNumber;

    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;
        this.sequenceNumber = sequenceGenerator++;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }

    @Override
    public int compareTo(Person other) {
        int typeComparison = other.type.compareTo(this.type);
        return typeComparison == 0 ? Integer.compare(this.sequenceNumber, other.sequenceNumber) : typeComparison;
    }
}
