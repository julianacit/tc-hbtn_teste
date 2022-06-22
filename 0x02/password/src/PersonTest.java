import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;

public class PersonTest {
    Person person;

    @BeforeAll
    public void setup() {
        person = new Person();
    }

    @ParameterizedTest
    @ValueSource(Strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String user) {
        person.setUser(user);
        Assertions.assertTrue(person.checkUser());
    }

    @ParameterizedTest
    @ValueSource(Strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String user) {
        person.setUser(user);
        Assertions.assertFalse(person.checkUser());
    }

    @ParameterizedTest
    @ValueSource(Strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(Strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(Strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(Strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password) {
        person.setPassword(password);
        Assertions.assertTrue(person.checkPassword());
    }
}