package Class9;

import java.util.ArrayList;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args)  {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = inputReader.nextInt();

        for (int i=1; i < 10; i++) {
            System.out.print(i * n + " ");
        }
    }
}