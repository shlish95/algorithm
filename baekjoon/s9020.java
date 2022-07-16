package baekjoon.silver;

import java.util.Scanner;

public class s9020 {
    private static boolean check(int i) {
        for (int j = 2; j <= (int)Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static void solution(int n) {
        int[] che = new int[n + 1];
        int min = 0;

        che[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (che[i] == 0) {
                if (s9020.check(n - i)) {
                    if (i <= n - i) {
                        min = i;
                    } else {
                        break;
                    }
                }

                for (int j = i; j < n + 1; j += i) {
                    che[j] = 1;
                }
            }
        }
        System.out.println(min + " " + (n - min));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            s9020.solution(n);
        }
    }
}