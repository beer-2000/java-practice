package chapter5;

import chapter4.IntStack;

public class example6 {
    public static void main(String[] args) {
        recur4(4);
    }

    private static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.println(n);
        }
    }

    private static void recur4(int n) {
        IntStack stack = new IntStack(n);

        while (true) {
            for (int i = n; i > 0; i--) {
                stack.push(i);
            }



            if (!stack.isEmpty()) {
                n = stack.pop();
                stack.dump();
                if (n > 1) {
                    stack.push(n);
                    stack.dump();
                    n = n - 2;
                    continue;
                }
                System.out.println(n);
                continue;
            }
        }
    }
}
