package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {
    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private MockMvc mockMvc;

    @Test
    void testCreateCarPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();

        mockMvc.perform(get("/car/createCar"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateCar"))
                .andExpect(model().attributeExists("car"));
    }

    @Test
    void testCreateCarPost() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        Car car = new Car();
        when(carService.create(car)).thenReturn(car);

        mockMvc.perform(post("/car/createCar")
                        .flashAttr("car", car))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("listCar"));

        verify(carService, times(1)).create(car);
    }

    @Test
    void testCarListPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        List<Car> carList = new ArrayList<>();
        when(carService.findAll()).thenReturn(carList);

        mockMvc.perform(get("/car/listCar"))
                .andExpect(status().isOk())
                .andExpect(view().name("CarList"))
                .andExpect(model().attribute("cars", carList));
    }

    @Test
    void testEditCarPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        Car car = new Car();
        car.setCarId("1");
        when(carService.findById("1")).thenReturn(car);

        mockMvc.perform(get("/car/editCar/{carId}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("EditCar"))
                .andExpect(model().attributeExists("car"));
    }

    @Test
    void testEditCarPost() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        Car car = new Car();
        car.setCarId("1");

        mockMvc.perform(post("/car/editCar")
                        .flashAttr("car", car))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("listCar"));

        verify(carService, times(1)).update("1", car);
    }

    @Test
    void testDeleteCar() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        Car car = new Car();
        car.setCarId("1");

        mockMvc.perform(post("/car/deleteCar")
                        .param("carId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("listCar"));

        verify(carService, times(1)).deleteCarById("1");
    }
}
