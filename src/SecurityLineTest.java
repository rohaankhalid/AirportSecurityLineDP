import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecurityLineTest {

    @Test
    public void testPriority() {
        SecurityLine line = new SecurityLine();
        line.addPerson(new Person("Rohaan", PersonType.ECONOMY));
        line.addPerson(new Person("Captain Shaheer", PersonType.FLIGHT_STAFF));
        line.addPerson(new Person("Khalid", PersonType.VIP));

        //flight staff first, then VIP, then economy
        assertEquals(PersonType.FLIGHT_STAFF, line.processNext().type);
        assertEquals(PersonType.VIP, line.processNext().type);
        assertEquals(PersonType.ECONOMY, line.processNext().type);
    }

    @Test
    public void testSamePriorityOrder() {
        SecurityLine line = new SecurityLine();
        line.addPerson(new Person("Imran Khan", PersonType.VIP));
        line.addPerson(new Person("Babar Azam", PersonType.VIP));

        //if same types in line, the one that joined the queue first is processed first
        assertEquals("Imran Khan", line.processNext().name);
        assertEquals("Babar Azam", line.processNext().name);
    }
}
