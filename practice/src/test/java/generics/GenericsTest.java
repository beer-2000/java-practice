package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GenericsTest {
    public <T> Box<T> boxing(T t) {
        return new Box<>(t);
    }

    public <T extends Number> Box<? extends Number> boxingDouble(T t, String str) {
        T a = t;
        return new Box<T>(t);
    }

    public Box<? extends Number> printAndReturnBox(Box<? extends Number> box) {
        System.out.println(box.getT().getClass().getSimpleName());
        return box;
    }

    public <K, V> V returnSecondType(K k) {
        return (V) k;
    }

    public <T extends Object> List<T> copy(List<T> values) {
        List<T> resultList = new ArrayList<>();
        for (T value : values) {
            resultList.add(value);
        }
        return resultList;
    }

    @Test
    void 박싱() {
        Box<String> boxOfString = new Box<>("HI");
        System.out.println(Arrays.toString(boxOfString.getT().split("")));

    }

    @Test
    void 박싱2() {
        Box<Date> boxOfInteger = new Box<>(new Date());
        System.out.println(boxOfInteger.getT());
    }

    @Test
    void 매개변수_2개() {
        Box<Float> box = (Box<Float>) boxingDouble((float) 1, "hi");
        System.out.println(box.getT().getClass().getName());
    }

    @Test
    void 박스_출력_와일드카드() {
        Box<? extends Double> box = boxing(1.5);
        printAndReturnBox(box);
    }

    @Test
    void 박스는_Stirng_타입파라미터는_Integer() {
        Box<? extends String> box = new Box<>("hi");
        System.out.println(box.returnInputSame(1).getClass().getSimpleName());
        System.out.println(box.getT().getClass().getSimpleName());
    }

    @Test
    void 두가지_타입_중_하나는_전달하지_않음() {
        // ClassCastException 발생
        System.out.println(this.<String, Integer>returnSecondType("hi").getClass().getSimpleName());
    }

    @Test
    void numberBox() {

//        System.out.println(new NumberBox<String>("hi").number.getClass().getSimpleName());
    }

    @Test
    void 공변성_체크() {
//        Box<Number> boxOfNumber;
//        Box<Integer> boxOfInteger = new Box<>(2);
//        boxOfNumber = boxOfInteger; // java: incompatible types: generics.Box<java.lang.Integer> cannot be converted to generics.Box<java.lang.Number>

        Box<? extends Number> boxOfNumber;
        Box<Integer> boxOfInteger = new Box<>(2);
        boxOfNumber = boxOfInteger;
    }

    @Test
    void 공변성_체크2() {
        List<String> strings = new ArrayList<>();
        strings.add("hi");
        System.out.println(copy(strings));
        System.out.println(copy(strings).get(0).getClass().getSimpleName());
    }

    @Test
    void 반공변성_체크() {
        IntegerFactory integerFactory = new IntegerFactory();
        List<Number> values = new ArrayList<>();
        integerFactory.consume(values);
        System.out.println(values);
        List<?> list = new ArrayList<>();
        list.add(null);
    }
}

class Practice {
    @Test
    public void 제네릭_외부_생성() {
        GenericsTest genericsTest = new GenericsTest();
        genericsTest.박싱();
        genericsTest.박싱2();
    }
}

class IntegerFactory {
    private final List<Integer> numbers;

    public IntegerFactory() {
        this.numbers = new ArrayList<>();
        this.numbers.add(1);
    }

    public void consume(List<? super Integer> values) {
        values.add(this.numbers.get(0));
    }
}
