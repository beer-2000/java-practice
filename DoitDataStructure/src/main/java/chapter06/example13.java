package chapter06;// 퀵 정렬(개선한 버전)

import java.util.Scanner;

class example13 {
	
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- x[a], x[b], x[c]을 정렬(중앙값의 인덱스를 반환)---//
    static int sort3elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a]) swap(x, b, a);
        if (x[c] < x[b]) swap(x, c, b);
        if (x[b] < x[a]) swap(x, b, a);
        return b;
    }

    //--- 퀵 정렬 ---//
    static void quickSort(int[] a, int n) {
        if (n <= 9) {
            int temp;
            for (int i =  1; i < n; i++) {
                temp = a[i];
                int j;
                for (j = i; j > 0 && a[j - 1] > temp; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = temp;
            }
            return;
        }
        int pl = 0;                                  // 왼쪽 커서
        int pr = n - 1;                                 // 오른쪽 커서
        int m = sort3elem(a, pl, (pl + pr) / 2, pr);    // 맨 앞・맨 끝・가운데를 정렬
        int x = a[m];                                   // 피벗

        swap(a, m, n - 2);            // 가운데 요소와 맨 끝에서 2번째 요소를 교환
        pl++;                             // 왼쪽 커서를 1 오른쪽으로
        pr -= 2;                          // 오른쪽 커서를 2 왼쪽으로

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (0 < pr) {
            int[] tempArray = new int[pr + 1];
            for (int i = 0; i < pr; i++) {
                tempArray[i] = a[i];
            }
            quickSort(tempArray, pr + 1);
            for (int i =0; i < pr; i++) {
                a[i] = tempArray[i];
            }
        }
        if (pl < n - 1) {
            int[] tempArray = new int[n - pl];
            for (int i = 0; i < n - pl; i++) {
                tempArray[i] = a[i + pl];
            }
            quickSort(a, n - pl);
            for (int i = 0; i < n - pl; i++) {
                a[i + pl] = tempArray[i];
            }
        }
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

        quickSort(x, nx);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
