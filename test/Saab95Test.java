import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saabTest = new Saab95();
    Volvo240 volvoTest = new Volvo240();

    @BeforeEach
    void Setup() {

    }

    @Test
    void speedFactor() {

        saabTest.setTurboOn();
        assertEquals(1.625, saabTest.speedFactor());
        saabTest.setTurboOff();
        assertEquals(1.25, saabTest.speedFactor());

        assertEquals(1.25, volvoTest.speedFactor());

    }

    @Test
    void incrementSpeed() {
        assertEquals(0, saabTest.getCurrentSpeed());
        assertEquals(0, volvoTest.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        assertEquals(0, saabTest.getCurrentSpeed());
        assertEquals(0, volvoTest.getCurrentSpeed());
    }

    @Test
    void setTurboOn() {
        saabTest.setTurboOn();
        assertTrue(saabTest.isTurboOn());
    }

    @Test
    void setTurboOff() {
        saabTest.setTurboOff();
        assertFalse(saabTest.isTurboOn());
    }


}