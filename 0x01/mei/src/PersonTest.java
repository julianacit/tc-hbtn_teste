import org.junit.jupiter.api.*;

public class PersonTest {
    @BeforeEach
    public void setup() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = sdf.parse("2000");
        Person person = new Person("Paul", "McCartney", date, true, true, true);
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