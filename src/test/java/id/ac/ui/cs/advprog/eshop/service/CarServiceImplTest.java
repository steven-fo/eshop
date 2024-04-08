package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    void testCreate() {
        Car car = new Car();
        carService.create(car);
        verify(carRepository, times(1)).create(car);
    }

    @Test
    void testFindAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        Iterator<Car> iterator = cars.iterator();
        when(carRepository.findAll()).thenReturn(iterator);

        List<Car> result = carService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void testFindById() {
        String id = "1";
        Car expectedCar = new Car();
        when(carRepository.findById(id)).thenReturn(expectedCar);

        Car result = carService.findById(id);
        assertEquals(expectedCar, result);
    }

    @Test
    void testUpdate() {
        Car currentCar = new Car();
        currentCar.setCarId("1");
        Car newCar = new Car();

        carService.update("1", newCar);
        verify(carRepository, times(1)).update("1", newCar);
    }

    @Test
    void testDelete() {
        Car car = new Car();
        carService.deleteCarById("1");
        verify(carRepository, times(1)).delete("1");
    }
}
