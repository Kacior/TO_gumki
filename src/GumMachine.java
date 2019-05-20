import java.util.Collection;

public class GumMachine {
    private Coin coinSlot;
    private Gum gumTray;
    private GumContainer gumContainer;

    public GumMachine(GumContainer gumContainer) {
        this.gumContainer = gumContainer;
    }

    public void insertCoin(Coin coin) {
        if (this.coinSlot != null) {
            throw new RuntimeException("Coin tray is not empty");
        }
        this.coinSlot = coin;
    }

    public void clickButton() {
        this.acceptPurchase();
    }

    private void acceptPurchase() {
        if (this.coinSlot == null) {
            throw new RuntimeException("No coin in slot");
        }
        if (this.gumTray!=null){
            throw new RuntimeException("Gum is still not obtained");
        }
        this.coinSlot = null; // or: CoinContainer
        this.gumTray = this.gumContainer.getGum();
    }

    public Gum takeGum() {
        if (this.gumTray == null) {
            throw new RuntimeException("No gum on tray");
        }
        Gum gum = this.gumTray;
        this.gumTray = null;
        return gum;
    }

    public Coin returnCoin() {
        if (this.coinSlot == null) {
            throw new RuntimeException("No coin in slot");
        }
        Coin coin = this.coinSlot;
        this.coinSlot = null;
        return coin;
    }

    public void refill(Collection<Gum> gums) {
        this.gumContainer.refill(gums);
    }
}
