package chapter01;

public class Example12 {
    public static void main(String[] args) {
        String VERTICAL_PREFIX = " |";
        String HORIZON_PREFIX = "---+---------------------------";
        System.out.print("   |");
        for (int i = 1; i <=9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        System.out.println(HORIZON_PREFIX);
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%2d" + VERTICAL_PREFIX, i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i + j);
            }
            System.out.println();
        }
    }
}
