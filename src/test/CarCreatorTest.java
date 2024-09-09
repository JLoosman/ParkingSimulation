import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarCreatorTest {
    CarCreator carCreator = new CarCreator();

    @Test
    void createCarTest() {
        assertNotNull(carCreator.createCar());
        assertInstanceOf(Car.class, carCreator.createCar());
    }

    @Test
    void getCarsTest() {
       assertInstanceOf(ArrayList.class, carCreator.getCars());
       assertTrue(carCreator.getCars().isEmpty());
       carCreator.createCar();
       assertEquals(1, carCreator.getCars().size());
    }

    @Test
    void removeCarTest() {
        Car car = carCreator.createCar();
        carCreator.removeCar(car);
        assertTrue(carCreator.getCars().isEmpty());
    }
}