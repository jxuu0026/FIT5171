package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchUnitTest {

    private Launch launch;

    @BeforeEach
    public void setUp() {
        launch = new Launch();
    }


    @DisplayName("should throw exception when pass null to setLaunchSite function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchSiteToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> launch.setLaunchSite(null));
        assertEquals("launchSite cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setLaunchSite")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLaunchSiteToEmpty(String launchsite) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> launch.setLaunchSite(launchsite));
        assertEquals("launchSite cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should throw exception when pass null to setOrbit function")
    @Test
    public void shouldThrowExceptionWhenSetOrbitToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> launch.setOrbit(null));
        assertEquals("orbit cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setOrbit")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetOrbitToEmpty(String orbit) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> launch.setOrbit(orbit));
        assertEquals("orbit cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should throw exception when pass null to setFunction function")
    @Test
    public void shouldThrowExceptionWhenSetFunnctionToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> launch.setFunction(null));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setFunction")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFunctionToEmpty(String function) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> launch.setFunction(function));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when two launch equals")
    @Test
    public void shouldReturnTrueWhenTwoRocketsEquals() {
        LocalDate launchDate = LocalDate.of(2017, Month.MAY, 15);
        Rocket launchVehicle = new Rocket("Jingshuai","China","Target");;
        LaunchServiceProvider launchServiceProvider = new LaunchServiceProvider("Junzhu",1999,"Australia");
        String orbit = "666";
        launch.setLaunchDate(launchDate);
        launch.setLaunchVehicle(launchVehicle);
        launch.setLaunchServiceProvider(launchServiceProvider);
        launch.setOrbit(orbit);
        Launch anotherLaunch = new Launch();
        anotherLaunch.setLaunchDate(launchDate);
        anotherLaunch.setLaunchVehicle(launchVehicle);
        anotherLaunch.setLaunchServiceProvider(launchServiceProvider);
        anotherLaunch.setOrbit(orbit);
        assertTrue(launch.equals(anotherLaunch));

    }

    @DisplayName("should return false when two launch not equals")
    @Test
    public void shouldReturnFalseWhenTwoRocketsNotEquals() {
        LocalDate launchDate = LocalDate.of(2017, Month.MAY, 15);
        Rocket launchVehicle = new Rocket("Jingshuai","China","Target");;
        LaunchServiceProvider launchServiceProvider = new LaunchServiceProvider("Junzhu",1999,"Australia");
        String orbit = "666";
        launch.setLaunchDate(launchDate);
        launch.setLaunchVehicle(launchVehicle);
        launch.setLaunchServiceProvider(launchServiceProvider);
        launch.setOrbit(orbit);
        Launch anotherLaunch = new Launch();
        anotherLaunch.setLaunchDate(launchDate);
        anotherLaunch.setLaunchVehicle(launchVehicle);
        anotherLaunch.setLaunchServiceProvider(launchServiceProvider);
        anotherLaunch.setOrbit("777");
        assertFalse(launch.equals(anotherLaunch));

    }

    @DisplayName("should harsh infor correctly")
    @Test
    public void shouldHarshInforCorrectly() {
        LocalDate launchDate = LocalDate.of(2017, Month.MAY, 15);
        Rocket launchVehicle = new Rocket("Jingshuai","China","Target");;
        LaunchServiceProvider launchServiceProvider = new LaunchServiceProvider("Junzhu",1999,"Australia");
        String orbit = "666";
        Launch anotherLaunch = new Launch();
        anotherLaunch.setLaunchDate(launchDate);
        anotherLaunch.setLaunchVehicle(launchVehicle);
        anotherLaunch.setLaunchServiceProvider(launchServiceProvider);
        anotherLaunch.setOrbit(orbit);

        assertEquals(426667837,anotherLaunch.hashCode());
    }

    @DisplayName("should set setLaunchDate correctly")
    @Test
    public void shouldsetLaunchDateCorrectly() {
        LocalDate launchDate = LocalDate.of(2017, Month.MAY, 15);
        launch.setLaunchDate(launchDate);
        assertEquals(LocalDate.of(2017, Month.MAY, 15),launch.getLaunchDate());

    }

    @DisplayName("launch year cannot be greater than current year")
    @Test
    public void shouldsetLaunchYearCorrectly() {
        LocalDate launchDate = LocalDate.of(2020, Month.MAY, 15);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> launch.setLaunchDate(launchDate));
        assertEquals("Year can not greater than current year", exception.getMessage());

    }

    @DisplayName("should set setLaunchVehicle correctly")
    @Test
    public void shouldsetLaunchVehicleCorrectly() {
        Rocket rocket = new Rocket("Jingshuai","China","Target");
        launch.setLaunchVehicle(rocket);
        assertEquals(rocket,launch.getLaunchVehicle());

    }

    @DisplayName("should set setServiceProvider correctly")
    @Test
    public void shouldsetServiceProviderCorrectly() {
        LaunchServiceProvider launchServiceProvider = new LaunchServiceProvider("Junzhu",1999,"Australia");
        launch.setLaunchServiceProvider(launchServiceProvider);
        assertEquals(launchServiceProvider,launch.getLaunchServiceProvider());

    }




    @DisplayName("should set setPrice correctly")
    @Test
    public void shouldsetSetPriceCorrectly() {
        BigDecimal bd = new BigDecimal(1.0);
        launch.setPrice(bd);
        assertEquals(bd,launch.getPrice());

    }





}
