package Class5;

import java.util.ArrayList;
import java.util.Arrays;

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }

    boolean isOdd() {
        return this.value % 2 == 1;
    }

    float avg(int[] numbers) {
        float total = 0;
        for (int number: numbers) {
            total += number;
        }
        float average = total / numbers.length;
        return average;
    }

    float avg(ArrayList<Integer> numbers) {
        float total = 0;
        for (int number: numbers) {
            total += number;
        }
        float average = total / numbers.size();
        return average;
    }
}

class UpgradeCalculator extends Calculator {
    void minus(int val) {
        this.value -= val;
    }
}

public class Example1 {
    public static void main(String[] args) {
        MaxLimitCalculator cal = new MaxLimitCalculator();
        cal.add(50);
        cal.add(47);
        System.out.println(cal.getValue());
        System.out.println(cal.isOdd());

        int[] numbers = {10, 33, 99};
        System.out.println(cal.avg(numbers));

        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(23, 51, 24, 88, 12));
        System.out.println(cal.avg(numberList));
    }
}