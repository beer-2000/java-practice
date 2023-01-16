// 연습5-6
// 메서드 recur3의 비재귀적 구현

import java.util.Scanner;

class Recur3 {

	//--- 메서드 recur의 비재귀적 구현 ---//
	static void recur3(int n) {
		int[] nstk = new int[10];
		int[] sstk = new int[10];
		int ptr = -1;
		int sw = 0;

		while (true) {
			if (n > 0) {
				ptr++;
				nstk[ptr] = n;
				sstk[ptr] = sw;

				if (sw == 0)
					n = n - 1;
				else if (sw == 1) {
					n = n - 2;
					sw = 0;
				}
				continue;
			}
			do {
				n  = nstk[ptr];
				sw = sstk[ptr--] + 1;

				if (sw == 2) {
					System.out.println(n);
					if (ptr < 0)
						return;
				}
			} while (sw == 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int   x = stdIn.nextInt();

		recur3(x);
	}
}

