package class5;

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
        if (this.value % 2 == 1) {
            return true;
        }
        return false;
    }

    int avg(ArrayList<Integer> intList) {
        int sum = 0;
        for (int number: intList) {
            sum += number;
        }
        return sum / intList.size();
    }
}

class UpgradeCalculator extends Calculator {
    void minus(int val) {
        this.value -= val;
    }
}

class MaxLimitCalculator extends Calculator {
    int getValue() {
        if (this.value > 100) {
            this.value = 100;
        }
        return this.value;
    }
}

public class Example1 {
    public static void main(String[] args) {
        MineralCalculator cal = new MineralCalculator();
        cal.add(new Gold());
        cal.add(new Silver());
        cal.add(new Bronze());
        System.out.println(cal.getValue());  // 270 출력
    }
}