package Class7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        try {
            sample.sayNick("genious");
            sample.sayNick("fool");
        } catch (FoolException e) {
            System.out.println(e);
        }

    }

    public void sayNick(String nick) throws FoolException {
        if("fool".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("당신의 별명은 " + nick + "입니다.");
    }
}

class FoolException extends Exception {
}