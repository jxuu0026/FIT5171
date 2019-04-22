package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PayloadUnitTest {

    private Payload payload;

    @BeforeEach
    public void setUp() {
        payload = new Payload();
    }


    @DisplayName("should throw exception when pass null to setType function")
    @Test
    public void shouldThrowExceptionToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> payload.setType(null));
        assertEquals("type cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setLaunchSite")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLaunchSiteToEmpty(String type) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> payload.setType(type));
        assertEquals("type cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setDescription function")
    @Test
    public void shouldThrowDescriptionExceptionToNull() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> payload.setDescription(null));
        assertEquals("description cannot be null", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setDescription")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetDescriptionoEmpty(String description) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> payload.setDescription(description));
        assertEquals("description cannot be null", exception.getMessage());
    }


}
