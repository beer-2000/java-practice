package chapter1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Max of 3 : " + getMaxOf3(1,2,3));
        System.out.println("Max of 3 : " + getMaxOf3(7,6,3));
    }

    private static int getMaxOf3(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
