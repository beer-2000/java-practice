package class5;

interface Predator {
    String getFood();
}

public class Animal {
    String name;

    public void setName(String name) {
        this.bark();
        this.name = name;
    }

    private void bark() {
        System.out.println("왈왈");
    }
}

class Tiger extends Animal implements Predator {
    public String getFood() {
        return "apple";
    }
}

class Lion extends Animal implements Predator {
    public String getFood() {
        return "banana";
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }
}