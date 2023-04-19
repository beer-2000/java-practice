package generics;

public class Box<T extends Object> {
    private final T t;

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public <T> T returnInputSame(T t) {
        return t;
    }
}
