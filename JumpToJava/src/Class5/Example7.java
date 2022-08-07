package Class5;

public class Example7 {
    public static void main(String[] args) {
        MineralCalculator cal = new MineralCalculator();
        cal.add(new Gold());
        cal.add(new Bronze());
        System.out.println(cal.getValue());
    }
}
