package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchServiceProviderUnitTest {

    private LaunchServiceProvider launchServiceProvider;

    @BeforeEach
    public void setUp() {
        launchServiceProvider = new LaunchServiceProvider("SpaceX", 2002, "USA" );
    }

    @DisplayName("should throw exception when pass null name value to the constructor")
    @org.junit.jupiter.api.Test
    public void nameCannotBeNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new LaunchServiceProvider(null, 2002, "USA"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null country value to the constructor")
    @org.junit.jupiter.api.Test
    public void countryCannotBeNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new LaunchServiceProvider("SpaceX", 2002, null));
        assertEquals("Country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should not be the same rocket")
    @org.junit.jupiter.api.Test
    public void sameNameYearCountryMeansSameProvider() {
        LaunchServiceProvider l = new LaunchServiceProvider("SpaceXX", 2002, "USA" );
        assertFalse(launchServiceProvider.equals(l));
    }

    @DisplayName("should be different providers")
    @org.junit.jupiter.api.Test
    public void differentNameMeansDifferentProvider() {
        LaunchServiceProvider l = new LaunchServiceProvider("SpaceXX", 2002, "USA" );
        assertFalse(launchServiceProvider.equals(l));
    }

    @org.junit.jupiter.api.Test
    public void differentCountryMeansDifferentProvider() {
        LaunchServiceProvider l = new LaunchServiceProvider("SpaceX", 2002, "China" );
        assertFalse(launchServiceProvider.equals(l));
    }

    @org.junit.jupiter.api.Test
    public void differentYearMeansDifferentProvider() {
        LaunchServiceProvider l = new LaunchServiceProvider("SpaceX", 2003, "USA" );
        assertFalse(launchServiceProvider.equals(l));
    }

    @DisplayName("yearFounded cannot be greater than current year")
    @org.junit.jupiter.api.Test
    public void shouldSetYearFoundedCorrectly() {
        //LaunchServiceProvider anotherProvider = new LaunchServiceProvider("Jingshuai", 2020, "China");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new LaunchServiceProvider("SpaceX", 2020, "USA"));
        assertEquals("Year founded can not greater than the current year", exception.getMessage());

    }

    //test set
    //cannot be null 
    @DisplayName("Should throw exception when pass null headquaters value to the method")
    @org.junit.jupiter.api.Test
    public void headquartersCannotBeNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> launchServiceProvider.setHeadquarters(null));
        assertEquals("Headquaters cannot be null or empty", exception.getMessage());
    }

    //cannot be empty
    @org.junit.jupiter.api.Test
    public void headquartersCannotBeEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> launchServiceProvider.setHeadquarters(""));
        assertEquals("Headquaters cannot be null or empty", exception.getMessage());
    }

    //test get
    @org.junit.jupiter.api.Test
    public void testValueSet_getHeadquarters() {
        launchServiceProvider.getHeadquarters();
    }

    @org.junit.jupiter.api.Test
    public void testValueSet_rockets() {
        launchServiceProvider.getRockets();
    }

    //Test if the value can be call
    @org.junit.jupiter.api.Test
    public void headquartersValueEqualToSetHeadquarters() {
        String headquarters = "Space";
        launchServiceProvider.setHeadquarters(headquarters);

        assertEquals(headquarters, launchServiceProvider.getHeadquarters());

    }
}