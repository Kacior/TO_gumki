import java.util.Collection;
import java.util.HashSet;

public class GumContainer {
    private int max;
    private Collection<Gum> gums;

    public GumContainer(int max) {
        this.max = max;
        this.gums = new HashSet<>();
    }

    public Gum getGum() {
        if (this.gums.isEmpty()) {
            throw new RuntimeException("No gums in container");
        }
        /*
        Collections.shuffle(gums);
        return Collections.get(gums, 0);
        */
        return this.gums.stream().skip((int) (this.gums.size() * Math.random())).findFirst().get();
    }

    public void refill(Collection<Gum> gums) {
        if (this.gums.size() + gums.size() > this.max) {
            throw new RuntimeException("Too many gums");
        }
        this.gums.addAll(gums);
    }
}
