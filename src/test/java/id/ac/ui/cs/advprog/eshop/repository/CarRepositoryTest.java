package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CarRepositoryTest {
    @InjectMocks
    CarRepository carRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Car car = new Car();
        car.setCarId("car-someid");
        car.setCarName("Toyota");
        car.setCarColor("white");
        car.setCarQuantity(1);
        carRepository.create(car);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car.getCarId(), savedCar.getCarId());
        assertEquals(car.getCarName(), savedCar.getCarName());
        assertEquals(car.getCarColor(), savedCar.getCarColor());
        assertEquals(car.getCarQuantity(), savedCar.getCarQuantity());
    }

    @Test
    void testFindAllEmpty() {
        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneCar() {
        Car car1 = new Car();
        car1.setCarId("car-someid");
        car1.setCarName("Toyota");
        car1.setCarColor("white");
        car1.setCarQuantity(1);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("car-someid2");
        car2.setCarName("Toyota");
        car2.setCarColor("white");
        car2.setCarQuantity(1);
        carRepository.create(car2);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car1.getCarId(), savedCar.getCarId());
        savedCar = carIterator.next();
        assertEquals(car2.getCarId(), savedCar.getCarId());
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindById() {
        Car car = new Car();
        car.setCarId("1");
        car.setCarName("Toyota");
        car.setCarColor("white");
        car.setCarQuantity(1);
        carRepository.create(car);

        Car foundCar = carRepository.findById("1");
        assertEquals(car.getCarId(), foundCar.getCarId());
        assertEquals(car.getCarName(), foundCar.getCarName());
        assertEquals(car.getCarColor(), foundCar.getCarColor());
        assertEquals(car.getCarQuantity(), foundCar.getCarQuantity());

        Car falseCar = carRepository.findById("2");
        assertNull(falseCar);
    }

    @Test
    void testEditCar() {
        Car car1 = new Car();
        car1.setCarId("car-someid");
        car1.setCarName("Toyota");
        car1.setCarColor("white");
        car1.setCarQuantity(1);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("car-someid2");
        car2.setCarName("Toyota");
        car2.setCarColor("white");
        car2.setCarQuantity(1);
        carRepository.update("car-someid", car2);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car2.getCarName(), savedCar.getCarName());
        assertEquals(car2.getCarColor(), savedCar.getCarColor());
        assertEquals(car2.getCarQuantity(), savedCar.getCarQuantity());
    }

   @Test
   void testDeleteCar() {
       Car car1 = new Car();
       car1.setCarId("1");
       car1.setCarName("Toyota");
       car1.setCarColor("white");
       car1.setCarQuantity(1);
       carRepository.create(car1);

       carRepository.delete("1");
       Iterator<Car> carIterator = carRepository.findAll();
       assertFalse(carIterator.hasNext());
   }
}
