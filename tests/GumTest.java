import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;

public class GumTest {
    @Test
    public void BaseOccurance() {
        GumContainer gumContainer = new GumContainer(3);
        GumMachine automat = new GumMachine(gumContainer);
        automat.refill(Set.of(new Gum()));
        Coin coin = new Coin();
        automat.insertCoin(coin);
        automat.clickButton();
        Gum gum = automat.takeGum();
        assertEquals("Gum", gum.toString());
    }

    @Test
    public void OutOfStockOccurance() {
        try {
            GumContainer gumContainer = new GumContainer(0);
            GumMachine automat = new GumMachine(gumContainer);
            automat.refill(Set.of(new Gum()));
            Coin coin = new Coin();
            automat.insertCoin(coin);
            automat.clickButton();
            Gum gum = automat.takeGum();
        } catch (RuntimeException e) {
            assertEquals("Too many gums", e.getMessage());
        }
    }

    @Test
    public void MultipleCoinsOccurance() {
        try {
            GumContainer gumContainer = new GumContainer(3);
            GumMachine automat = new GumMachine(gumContainer);
            automat.refill(Set.of(new Gum()));
            Coin coin = new Coin();
            Coin anotherCoin = new Coin();
            automat.insertCoin(coin);
            automat.insertCoin(anotherCoin);
        }
        catch(RuntimeException e){
            assertEquals("Coin tray is not empty", e.getMessage());
        }
    }
    @Test
    public void UntakenGumOcurrance(){
        try {
            GumContainer gumContainer = new GumContainer(3);
            GumMachine automat = new GumMachine(gumContainer);
            automat.refill(Set.of(new Gum()));
            Coin coin = new Coin();
            Coin anotherCoin = new Coin();
            automat.insertCoin(coin);
            automat.clickButton();
            automat.insertCoin(anotherCoin);
            automat.clickButton();
        }
        catch(RuntimeException e){
            assertEquals("Gum is still not obtained", e.getMessage());
        }
    }
    @Test
    public void ReturnNonExistentCoinOccurance(){
        try {
            GumContainer gumContainer = new GumContainer(3);
            GumMachine automat = new GumMachine(gumContainer);
            automat.returnCoin();
        }
        catch(RuntimeException e){
            assertEquals("No coin in slot", e.getMessage());
        }
    }
}
