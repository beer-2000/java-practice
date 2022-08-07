package Class5;

class Gold implements Mineral {
    public int getValue() {
        return 100;
    }
}

class Silver implements Mineral {
    public int getValue() {
        return 90;
    }
}

class Bronze implements Mineral {
    public int getValue() {
        return 80;
    }
}

public class MineralCalculator {
    int value = 0;

    public void add(Mineral mineral) {
        this.value += mineral.getValue();
    }

    public int getValue() {
        return this.value;
    }
}