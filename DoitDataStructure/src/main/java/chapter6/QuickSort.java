package chapter6;// 퀵 정렬

import java.util.Scanner;

class QuickSort {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    static void print(int[] a) {
        for (int number: a) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    //--- 퀵 정렬 ---//
    static void quickSort(int[] a, int left, int right) {
        System.out.println("정렬 시작");
        print(a);
        int pl = left;                   // 왼쪽 커서
        int pr = right;                  // 오른쪽 커서
        int x = a[(pl + pr) / 2];        // 피벗(가운데 요소)
        System.out.printf("%d에서 %d까지 %d로 분할", left, right, x);
        System.out.println();

        do {
            while (a[pl] < x) pl++;
            System.out.println("pl: " + pl);
            while (a[pr] > x) pr--;
            System.out.println("pr: " + pr);
            if (pl <= pr) {
                swap(a, pl++, pr--);
                print(a);
            }
        } while (pl <= pr);
        System.out.println("정렬 완료");
        print(a);

        if (left < pr)  quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
