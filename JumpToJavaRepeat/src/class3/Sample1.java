package class3;

public class Sample1 {
    public static void main(String[] args) {
        String a = "Hello Java Java";
        String b = new String("Hello Java Java");
        System.out.println(a.indexOf("J"));
        System.out.println(a.contains("J"));
        System.out.println(a.replaceAll("Java", "World"));
        System.out.println(a);

        b = b.replaceAll("Java", "World");
        System.out.println(b);
    }
}
