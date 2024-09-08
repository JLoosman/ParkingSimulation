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

        String result = scan.nextLine();

        // scan.close();
        return result;
    }
}