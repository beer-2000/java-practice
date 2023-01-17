//package chapter4;// 연습4-1
//// int형 고정 길이 큐의 사용 예(IntQueue 클래스의 모든 메서드 를 사용)
//
//import java.util.Scanner;
//
//class Example2 {
//
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		IntQueue s = new IntQueue(64);	// 최대 64개를 푸시할 수 있는 스택
//
//		while (true) {
//			System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
//			System.out.print("(1) 인큐 (2) 디큐 (3) 리어 " +
//											 "(4) 덤프 (5) 검색 (6) 비움 " +
//											 "(7) 출력 (0) 종료 : ");
//
//			int menu = stdIn.nextInt();
//			if (menu == 0) break;
//
//			int x;
//			switch (menu) {
//			 case 1: 								// 인큐
//				System.out.print("데이터 : ");
//				x = stdIn.nextInt();
//				try {
//					s.inqueue(x);
//			 	} catch (IntQueue.OverflowIntQueueException e) {
//					System.out.println("큐가 가득 찼습니다.");
//				}
//				break;
//
//			 case 2: 								// 팝
//				try {
//			 		x = s.dequeue();
//					System.out.println("디큐한 데이터는 " + x + "입니다.");
//			 	} catch (IntQueue.EmptyIntQueueException e) {
//					System.out.println("큐가 비어 있습니다.");
//				}
//				break;
//
//			 case 3: 								// 리어
//				try {
//			 		x = s.rear();
//					System.out.println("리어의 데이터는 " + x + "입니다.");
//			 	} catch (IntQueue.EmptyIntQueueException e) {
//					System.out.println("큐가 비어 있습니다.");
//				}
//				break;
//
//			 case 4:								// 덤프
//				s.dump();
//				break;
//
//			 case 5:								// 검색
//				System.out.print("검색할 데이터 : ");
//				x = stdIn.nextInt();
//				int n = s.indexOf(x);
//				if (n >= 0)
//					System.out.println(n +"번째로 삽입되었습니다.");
//				else
//					System.out.println("그 데이터가 없습니다.");
//				break;
//
//			 case 6:								// 비웁니다
//				 s.clear();
//				 break;
//
//			 case 7:								// 데이터 출력
//				System.out.println("용량 : " + s.getCapacity());
//				System.out.println("데이터수 : " + s.size());
//				System.out.println("비어 " + (s.isEmpty()  ? "있습니다."
//														: "있지 않습니다."));
//				System.out.println("가득 " + (s.isFull() ? "차 있습니다."
//														: "차 있지 않습니다."));
//				break;
//			}
//		}
//	}
//}
