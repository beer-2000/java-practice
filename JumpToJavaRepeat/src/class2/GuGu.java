public class GuGu {
    public static void main(String[] args) {
        GuGu gugu = new GuGu();
        for(int i = 2; i < 10; i++) {
            gugu.dan(i);
        }
    }

    public void dan(int n) {
        for(int i = 1; i < 10; i++) {
            System.out.println(n * i);
        }
    }
}
