
import java.awt.Toolkit;
import multithread.Calculator;
import multithread.PracticeThread;
import multithread.User1Thread;
import multithread.User2Thread;

public class Practice {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
		autoSaveThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println(Thread.currentThread().getName());
		System.out.println("메인 스레드 종료");
	}
}

class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용 저장");
	}

	@Override
	public void run() {
		while(true) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
				save();
			}
		}
	}
}
