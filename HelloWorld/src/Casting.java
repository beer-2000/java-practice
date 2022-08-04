public class Casting {

    public static void main(String[] args) {

        double a = 1.1;
        double b = 1;
        String c = "Hello";
        System.out.println(b);

        double d = 1.1;
        int e = (int) 1.1;
        System.out.println(c.getClass());
        System.out.println(c.getClass().getSimpleName());

        String f = Integer.toString(1);
        System.out.println(f.getClass());
    }
}
