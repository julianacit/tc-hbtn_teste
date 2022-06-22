import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class PersonTest {
    Person person;

    @BeforeAll
    public void setup() {
        person = new Person();
    }

    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String user) {
        person.setUser(user);
        Assertions.assertTrue(person.checkUser());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String user) {
        person.setUser(user);
        Assertions.assertFalse(person.checkUser());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password) {
        person.setPassword(password);
        Assertions.assertTrue(person.checkPassword());
    }
}