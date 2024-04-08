package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
        this.car.setCarId("car-someid");
        this.car.setCarName("Toyota");
        this.car.setCarColor("white");
        this.car.setCarQuantity(1);
    }

    @Test
    void testGetCarId() {assertEquals("car-someid", this.car.getCarId());}

    @Test
    void testGetCarName() {assertEquals("Toyota", this.car.getCarName());}

    @Test
    void testGetCarColor() {assertEquals("white", this.car.getCarColor());}

    @Test
    void testGetCarQuantity() {assertEquals(1, this.car.getCarQuantity());}

    @Test
    void testGetCarIdInvalid() {assertNotEquals("Invalid ID", this.car.getCarId());}

    @Test
    void testGetCarNameInvalid() {assertNotEquals(null, this.car.getCarName());}

    @Test
    void testGetCarColorInvalid() {assertNotEquals(null, this.car.getCarColor());}

    @Test
    void testGetCarQuantityInvalid() {assertNotEquals(100, this.car.getCarQuantity());}
}
