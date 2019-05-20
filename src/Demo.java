import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String args[]) {
        try {
            Demo.demo1();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void demo1() {
        GumContainer gumContainer = new GumContainer(3);
        GumMachine automat = new GumMachine(gumContainer);
        automat.refill(Set.of(new Gum()));
        Coin coin = new Coin();
        automat.insertCoin(coin);
        automat.clickButton();
        Gum gum = automat.takeGum();
        System.out.println(gum);
    }

    private static void demo2() {
        GumContainer gumContainer = new GumContainer(3);
        GumMachine automat = new GumMachine(gumContainer);
        automat.takeGum();
    }

    private static void demo3() {
        GumContainer gumContainer = new GumContainer(3);
        GumMachine automat = new GumMachine(gumContainer);
        automat.returnCoin();
    }

    private static void demo4() {
        GumContainer gumContainer = new GumContainer(3);
        GumMachine automat = new GumMachine(gumContainer);
        automat.insertCoin(new Coin());
        automat.insertCoin(new Coin());
    }

    private static void demo5() {
        GumContainer gumContainer = new GumContainer(3);
        GumMachine automat = new GumMachine(gumContainer);
        automat.insertCoin(new Coin());
        automat.takeGum();
    }
}
