package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserUnitTest {
    private User target;

    @BeforeEach
    public void setUp() {
        target = new User();
    }


    @DisplayName("should throw exception when pass a empty email address to setEmail function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetEmailToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setEmail(email));
        assertEquals("input email is invalid", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setEmail function")
    @Test
    public void shouldThrowExceptionWhenSetEmailToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setEmail(null));
        assertEquals(null, exception.getMessage());
    }

    @DisplayName("should throw exceptions when pass a null password to setPassword function")
    @Test
    public void shouldThrowExceptionWhenSetPasswordToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPassword(null));
        assertEquals("password cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when two users have the same email")
    @Test
    public void shouldReturnTrueWhenUsersHaveSameEmail() {
        target.setEmail("abc@example.com");
        String email = "abc@example.com";
        User anotherUser = new User();
        anotherUser.setEmail(email);
        assertTrue(target.equals(anotherUser));
    }


    @DisplayName("should return false when two users have different emails")
    @Test
    public void shouldReturnFalseWhenUsersHaveDifferentEmails() {
        target.setEmail("abc@example.com");
        User anotherUser = new User();
        anotherUser.setEmail("def@example.com");
        assertFalse(target.equals(anotherUser));
    }

    @DisplayName("should throw exception when pass a empty first name to setFirstName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFirstNameToEmpty(String firstname) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setFirstName(firstname));
        assertEquals("firstName cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setFirstName function")
    @Test
    public void shouldThrowExceptionWhenSetFirstNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFirstName(null));
        assertEquals("firstName cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty last name to setLastName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLastNameToEmpty(String lastname) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setLastName(lastname));
        assertEquals("lastName cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should throw exception when pass null to setLastName function")
    @Test
    public void shouldThrowExceptionWhenSetLastNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLastName(null));
        assertEquals("lastName cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when given password match")
    @Test
    public void shouldReturnTrueWhenPasswordMatch() {
        String password = "123456";
        target.setPassword(password);
        User anotherUser = new User();
        anotherUser.setPassword(password);
        assertTrue(target.isPasswordMatch(password));
    }

    @DisplayName("should return false when password not match")
    @Test
    public void shouldReturnFalseWhenPasswordNotMatch() {
        target.setPassword("123456");
        User anotherUser = new User();
        anotherUser.setPassword("654321");
        assertFalse(target.isPasswordMatch(anotherUser.getPassword()));
    }

    @DisplayName("should harsh email correctly")
    @Test
    public void shouldHarshEmailCorrectly() {
        String email = "123@gmail.com";
        target.setEmail(email);
        User anotherUser = new User();
        anotherUser.setEmail(email);
        assertEquals(-1970481726,target.hashCode());
    }

    @DisplayName("should return string correctly")
    @Test
    public void shouldReturnStringCorrectly() {
        String firstName = "Jingshuai";
        String lastName = "Xu";
        String email = "123@gmail.com";
        target.setFirstName(firstName);
        target.setLastName(lastName);
        target.setEmail(email);

        assertEquals("User{" + "firstName='" + "Jingshuai" + '\'' +
                ", lastName='" + "Xu" + '\'' +
                ", email='" + "123@gmail.com" + '\'' +
                '}',target.toString());
    }
}