package rpg.utility;

public class Tuple<X, Y> {
    private final X v1;
    private final Y v2;
    

    public Tuple(X v1, Y v2) {
        this.v1 = v1;
        this.v2 = v2;
    }


    public X v1() {
        return v1;
    }

    public Y v2() {
        return v2;
    }
}
