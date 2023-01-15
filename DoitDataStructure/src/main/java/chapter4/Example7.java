package chapter4;
// int형 고정 길이 큐의 사용 예

import java.util.Scanner;

class Example7 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDeque s = new IntDeque(64);    // 최대 64개를 인큐할 수 있는 큐

        while (true) {
            System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)프론트 인큐　(2)리어 인큐 (3)프론트 디큐 (4)리어 디큐　(5)프론트 (6)리어　(7)덤프　(0)종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) {
                break;
            }

            int x;
            switch (menu) {
                case 1:                                // 인큐
                    System.out.print("프론트로 인큐할 데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.enqueFront(x);
                    } catch (IntDeque.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:                                // 인큐
                    System.out.print("리어로 인큐할 데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.enqueRear(x);
                    } catch (IntDeque.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 3:                                // 디큐
                    try {
                        x = s.dequeFront();
                        System.out.println("프론트로 디큐한 데이터는 " + x + "입니다.");
                    } catch (IntDeque.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:                                // 디큐
                    try {
                        x = s.dequeRear();
                        System.out.println("리어로 디큐한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 5:                                // 프론트
                    try {
                        x = s.front();
                        System.out.println("프론트에 존재하는 데이터는 " + x + "입니다.");
                    } catch (IntDeque.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 6:                                // 프론트
                    try {
                        x = s.rear();
                        System.out.println("리어에 존재하는 데이터는 " + x + "입니다.");
                    } catch (IntDeque.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 7:                                // 덤프
                    s.dump();
                    break;
            }
            s.printDeque();
        }
    }
}