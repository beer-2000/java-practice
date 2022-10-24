public class Sample {
    int number = 1;

    public static void main(String[] args) {
        Sample a = new Sample();
        Sample b = new Sample();
        b.number = 2;

        System.out.println(a.getNumber());
        System.out.println(b.getNumber());
    }

    int getNumber() {
        return number;
    }
}

//class Counter {
//    int count = 0;
//
//    int getNumber()
//}