package class5;

public class Sample5 {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        tiger.setName("키위");
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
    }
}