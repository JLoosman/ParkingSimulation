import java.util.ArrayList;

public interface UI {

    void printMessage(String message);
    String getString(String prompt);
    void displayCars(ArrayList<Car> cars);
}
