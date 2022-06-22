import org.junit.jupiter.api.*;
import java.util.Calendar;

public class PersonTest {
    Person person;
    @BeforeEach
    public void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2000);
        person = new Person("Paul", "McCartney", calendar.getTime(), true, true, true);
    }

    @Test
    public void show_full_name() {
        Assertions.assertEquals("Paul McCartney", person.fullName());
    }
    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        Assertions.assertEquals(14400, person.calculateYearlySalary());
    }
    @Test
    public void person_is_MEI() {
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        Assertions.assertTrue(person.isMEI());
    }
    @Test
    public void person_is_not_MEI() {
        Assertions.assertFalse(person.isMEI());
    }
}