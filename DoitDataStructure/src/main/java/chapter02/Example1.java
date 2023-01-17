package chapter02;

import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.println("사람 수를 자동으로 설정합니다.");
        int heads = 1 + random.nextInt(10);
        System.out.printf("사람 수는 %d명입니다.", heads);

        int[] heights = new int[heads];

        System.out.println("키의 값은 아래와 같습니다.");
        for (int i = 0; i < heads; i++) {
            heights[i] = 100 + random.nextInt(90);
            System.out.println(i + "번째 사람의 키: " + heights[i]);
        }

        System.out.println("최댓값은 " + maxOf(heights) + "입니다.");
    }

    private static int maxOf(int[] heights) {
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }
}
