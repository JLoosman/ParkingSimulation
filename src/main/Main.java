// written by Jesiah Loosman

public class Main {
    public static void main(String[] args) {

        Parkhaus parkhaus = new Parkhaus(1);
        CarCreator carCreator = new CarCreator();
        UI ui = new TerminalUI();
        Menu menu = new Menu(parkhaus, carCreator, ui);

        menu.start();
    }
}