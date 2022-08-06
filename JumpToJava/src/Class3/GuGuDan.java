package Class3;

public class GuGuDan {
    public static void main(String[] args) {
        GuGuDan gugudan = new GuGuDan();
        for (int i = 2; i < 10; i++) {
            gugudan.gugu(i);
        }
    }

    public void gugu(int n) {
        for (int i = 1; i < 10; i++) {
            System.out.println(n * i);
        }
    }
}