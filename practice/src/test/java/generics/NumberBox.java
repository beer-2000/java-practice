package generics;

public class NumberBox<T extends Number> {
    T number;

    public NumberBox(T number) {
        this.number = number;
    }

    public void print(Number number) {

    }
}
