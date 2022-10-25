package class4;

public class Example {
    public static void main(String[] args) {
        int[] marks = {70, 60, 55};
        int sum = 0;
        for (int mark: marks) {
            sum += mark;
        }
        float average = (float) sum / marks.length;
        System.out.println(average);
    }
}
