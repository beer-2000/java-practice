package chapter06;// 연습6-17
// 도수 정렬(정렬 과정을 출력)

import java.util.Scanner;

class example18 {

	//--- 도수 정렬(배열 요솟값은 0 이상 max 이하) ---//
	static void countingSort(int[] a, int n, int max) {
		int[] f = new int[max + 1];	// 누적도수
		int[] b = new int[n];			// 작업용 목표 배열 

		System.out.println("Step 1 : 도수분포표 작성");			// Step 1
		for (int i = 0; i < n; i++) {
			for (int k = 0; k <= max; k++)
				System.out.printf("%3d", f[k]);
			System.out.println();
			f[a[i]]++;
		}
		for (int k = 0; k <= max; k++)
			System.out.printf("%3d", f[k]);
		System.out.println();

		System.out.println("Step 2 : 누적도수분포표 작성");	// Step 2
		for (int i = 1; i <= max; i++) {
			for (int k = 0; k <= max; k++)
				System.out.printf("%3d", f[k]);
			System.out.println();
			f[i] += f[i - 1];
		}
		for (int k = 0; k <= max; k++)
			System.out.printf("%3d", f[k]);
		System.out.println();


		System.out.println("Step 3 : 정렬");						// Step 3
		for (int i = n - 1; i >= 0; i--) {
			for (int k = 0; k < n; k++)
				System.out.printf("%3d", b[k]);
			System.out.println();
			b[--f[a[i]]] = a[i];
		}
		for (int k = 0; k < n; k++)
			System.out.printf("%3d", b[k]);
		System.out.println();
		
		for (int i = 0;   i < n;i++) a[i] = b[i];					// Step 4
	}

	public static void countingSortWithMinimum(int[] a, int n, int min, int max) {
		int[] temp = new int[n];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = a[i] - min;
		}
		countingSort(temp, n, max - min);
		for (int i = 0; i < temp.length; i++) {
			a[i] = temp[i] + min;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("도수 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		int max = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] > max) max = x[i];

		int min = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] < min) min = x[i];

		countingSortWithMinimum(x, nx, min, max);			// 배열 x를 도수 정렬
		
		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}