package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class RocketFamilyUnitTest {

    private RocketFamily rocketFamily;

    @BeforeEach
    public void setUp() { rocketFamily = new RocketFamily();
    }


    @DisplayName("should throw exception when pass a empty familyName to setFamilyName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFamilyNameToEmpty(String familyname) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocketFamily.setFamilyName(familyname));
        assertEquals("familyName cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setfamilyName function")
    @Test
    public void shouldThrowExceptionWhenSetEmailToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> rocketFamily.setFamilyName(null));
        assertEquals("familyName cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty description to setDescription function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetDescriptionToEmpty(String description) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocketFamily.setDescription(description));
        assertEquals("description cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setDescription function")
    @Test
    public void shouldThrowExceptionWhenSetDescriptionToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> rocketFamily.setDescription(null));
        assertEquals("description cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty description to setSubCategory function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetSubCategoryToEmpty(String subcategory) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocketFamily.setSubCategory(subcategory));
        assertEquals("subCategory cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setSubCategory function")
    @Test
    public void shouldThrowExceptionWhenSetSubCategoryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> rocketFamily.setSubCategory(null));
        assertEquals("subCategory cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when two rocketfamily equals")
    @Test
    public void shouldReturnTrueWhenTwoRocketFamilyEquals() {
        rocketFamily.setFamilyName("Ariane");
        rocketFamily.setSubCategory("ECA");
        rocketFamily.setDescription("This is Ariane ECA.");
        RocketFamily anotherFamily = new RocketFamily();
        anotherFamily.setFamilyName("Ariane");
        anotherFamily.setSubCategory("ECA");
        anotherFamily.setDescription("This is Ariane ECA.");
        assertTrue(rocketFamily.equals(anotherFamily));
    }

    @DisplayName("should return false when two rocketfamily not equals")
    @Test
    public void shouldReturnFalseWhenTwoRocketFamilyNotEquals() {
        rocketFamily.setFamilyName("Ariane");
        rocketFamily.setSubCategory("ECA");
        rocketFamily.setDescription("This is Ariane ECA.");
        RocketFamily anotherFamily = new RocketFamily();
        anotherFamily.setFamilyName("Ariane");
        anotherFamily.setSubCategory("ES");
        anotherFamily.setDescription("This is Ariane ES.");
        assertFalse(rocketFamily.equals(anotherFamily));
    }


}
