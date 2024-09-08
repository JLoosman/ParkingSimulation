import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUI implements UI {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getString(String prompt) {
        System.out.println(prompt);

        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }

    public void displayCars(ArrayList<Car> cars) {
        for(int i = 0; i < cars.size(); i++) {
            System.out.println(i + 1 + ") " + cars.get(i).getId());
        }
    }
}