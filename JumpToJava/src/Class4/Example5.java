package Class4;

public class Example5 {
    public static void main(String[] args) {
        int[] marks = {73, 60, 55, 75, 95, 90, 80, 80, 85, 100};
        int total = 0;

        for(int score: marks) {
            total += score;
        }

        double average;
        average = (float) total / marks.length;
        System.out.println(average);
    }
}
