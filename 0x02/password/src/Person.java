import java.util.regex.*;

public class Person {
    private String user;
    private String password;

    private static final String USER_PATTERN = "^(?!.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";

    private static final Pattern userPattern = Pattern.compile(USER_PATTERN);
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public Person() {
    }

    public boolean checkUser() {
        Matcher matcher = userPattern.matcher(user);
        return matcher.matches();
    }

    public boolean checkPassword() {
        atcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}