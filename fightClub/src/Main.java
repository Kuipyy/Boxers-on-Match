//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Fighter Tom = new Fighter("Tom", 15, 50, 85);
        Fighter Bob = new Fighter("Bob", 12, 50, 80);

        Match m1 = new Match(Tom, Bob, 75, 95);

        m1.run();
    }
}