package Class4;

public class Example2 {
    public static void main(String[] args) {
        int result = 0;
        int i = 0;
        while(i <= 1000) {
            if(i % 3 == 0) {
                result += i;
            }
            i++;
        }
        System.out.println(result);
    }
}
