package multithread;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Time;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Practice {

    @Test
    void 공유작업() {
        WorkObject workObject = new WorkObject();

        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        threadA.start();
        threadB.start();
    }

    @Test
    void 작업_중지() {

        for (int i = 0; i < 2; i++) {
            PrintThread thread = new PrintThread();
            thread.start();
//            try {
//                Thread.sleep(0, 10);
//            } catch (InterruptedException e) {
//            }
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            if (thread.getMemory()) {
                System.out.println(i);
                break;
            }
//            assertThat(thread.getMemory()).isTrue();
        }
    }

    @Test
    void 데몬스레드() {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
//        autoSaveThread.setDaemon(true);
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

class WorkObject {
    public synchronized void methodA() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " : methodA 작업 실행");
        notifyAll();
        try { wait(); } catch (InterruptedException e) {}
    }

    public synchronized void methodB() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " : methodB 작업 실행");
        notify();
        try { wait(); } catch (InterruptedException e) {}
    }
}

class ThreadA extends Thread {
    private WorkObject workObject;

    public ThreadA(WorkObject workObject) {
        super.setName("ThreadA");
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodA();
        }
    }
}

class ThreadB extends Thread {
    private WorkObject workObject;

    public ThreadB(WorkObject workObject) {
        super.setName("ThreadB");
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodB();
        }
    }
}

class PrintThread extends Thread {
    private boolean memory = true;

    public void run() {
//        try {
            while (true) {
                System.out.println("실행 중");
//                Thread.sleep(10);
                if (Thread.interrupted()) {
                    System.out.println("인터럽트 감지");
                    break;
                }
            }
//        } catch (InterruptedException e) {
//            this.memory = false;
//            System.out.println("예외 발생으로 리소스 정리");
//        }
//        System.out.println("실행 종료");
    }

    public boolean getMemory() {
        return this.memory;
    }
}
