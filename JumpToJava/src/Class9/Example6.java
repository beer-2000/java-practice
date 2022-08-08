package Class9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args)  {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter a numbers: ");
        String userInput = inputReader.nextLine();
        String[] numbers = userInput.split(",");

        int total = 0;
        for(String num: numbers) {
            num = num.trim();
            int n = Integer.parseInt(num);

            total += n;
        }
        System.out.println(total);
    }
}