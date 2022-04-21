package Main;

public class Main {

    public static void main(String[] args) {
        Main.excute();
    }

    public static void excute() {
        new Controller(new Model(), new View());
    }

}
