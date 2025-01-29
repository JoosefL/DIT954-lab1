import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    private Saab95 saabTest;
    private Volvo240 volvoTest;



    // "Återställer" objekten inför varje test, gör testerna oberoende av varandra
    @BeforeEach
    void Setup() {
        saabTest = new Saab95();
        volvoTest = new Volvo240();
    }



    @org.junit.jupiter.api.Test
    void speedFactor() {

        saabTest.setTurboOn();
        assertEquals(1.625, saabTest.speedFactor());
        saabTest.setTurboOff();
        assertEquals(1.25, saabTest.speedFactor());

        assertEquals(1.25, volvoTest.speedFactor());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        assertEquals(0, saabTest.getCurrentSpeed());
        assertEquals(0, volvoTest.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        assertEquals(0, saabTest.getCurrentSpeed());
        assertEquals(0, volvoTest.getCurrentSpeed());
    }

    @Test
    void getX() {

        assertEquals(saabTest.getX(), 0);
        assertEquals(volvoTest.getX(), 0);
    }

    @Test
    void getY() {
        assertEquals(saabTest.getY(), 0);
        assertEquals(volvoTest.getY(), 0);
    }

    @Test
    void getModelName() {
        assertEquals(saabTest.getModelName(), "Saab95");
        assertEquals(volvoTest.getModelName(), "Volvo240");
    }

    @Test
    void getNrDoors() {
        assertEquals(saabTest.getNrDoors(), 2);
        assertEquals(volvoTest.getNrDoors(), 4);
    }

    @Test
    void getEnginePower() {
        assertEquals(saabTest.getEnginePower(), 125);
        assertEquals(volvoTest.getEnginePower(), 100);
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(saabTest.getCurrentSpeed(), 0);
        assertEquals(volvoTest.getCurrentSpeed(), 0);
    }

    @Test
    void getColor() {
        assertSame(saabTest.getColor(), Color.red);
        assertSame(volvoTest.getColor(), Color.black);
    }

    @Test
    void setColor() {
        saabTest.setColor(Color.black);
        assertSame(saabTest.getColor(), Color.BLACK);

        volvoTest.setColor(Color.blue);
        assertSame(volvoTest.getColor(), Color.blue);
    }

    @Test
    void startEngine() {
        saabTest.startEngine();
        assertEquals(saabTest.getCurrentSpeed(), 0.1);

        volvoTest.startEngine();
        assertEquals(volvoTest.getCurrentSpeed(), 0.1);
    }

/*

Är private, men kan testas indirekt via gas och brake, eller kanske increment/decrementSpeed

    @Test
    void setCurrentSpeed() {

    }
*/


    @Test
    void move() {
        volvoTest.startEngine();
        volvoTest.move();
        assertEquals(volvoTest.getX(), 0.1);

        saabTest.startEngine();
        saabTest.move();
        assertEquals(saabTest.getX(), 0.1);

    }

    @Test
    void turnLeft() {


    }

    @Test
    void turnRight() {
    }

    @Test
    void gas() {
        saabTest.gas(0.5);
        volvoTest.gas(0.5);

    }

    @Test
    void brake() {
        saabTest.brake(0.5);
        volvoTest.brake(0.5);
    }

    @Test
    void stopEngine() {
        assertEquals(saabTest.getCurrentSpeed(), 0);
        assertEquals(volvoTest.getCurrentSpeed(), 0);
    }







/*
    @Test
    void gasShouldIncreaseSpeed() {
        double speedBefore = saabTest.getCurrentSpeed();
        saabTest.gas(0.5);
        double speedAfter = saabTest.getCurrentSpeed();

        assertTrue(speedAfter > speedBefore, "Speed did not increase after calling gas()!");
    }

    @Test
    void brakeShouldDecreaseSpeed() {
        saabTest.gas(1.0); // Först gasar vi upp bilen för att få en högre hastighet
        double speedBefore = saabTest.getCurrentSpeed();
        saabTest.brake(0.5);
        double speedAfter = saabTest.getCurrentSpeed();

        assertTrue(speedAfter < speedBefore, "Speed did not decrease after calling brake()!");
    }
*/

}