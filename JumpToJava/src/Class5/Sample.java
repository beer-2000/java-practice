package Class5;

public class Sample {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
        tiger.bark();
        System.out.println(tiger.getFood());
    }
}
