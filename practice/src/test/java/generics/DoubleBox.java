package generics;

public class DoubleBox<T> {
    private final T t;

    public DoubleBox(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
