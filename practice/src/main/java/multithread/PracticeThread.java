package multithread;

import java.awt.Toolkit;

public class PracticeThread extends Thread{

    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.beep();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try { Thread.sleep(500); } catch (Exception e) {}
        }
    }
}
