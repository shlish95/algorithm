package baekjoon.bronze;

import java.util.Scanner;

/* 큰 수 A+B
두 정수 A와 B를 더한 값을 출력하여라
0 < A, B < 10^10000

입력 예시
9223372036854775807 9223372036854775808

출력 예시
18446744073709551615
 */
public class b10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String A, B;
        int max, num = 1;

        if (a.length() >= b.length()) {
            max = a.length() + 1;
            A = a;
            B = b;
        } else {
            max = b.length() + 1;
            A = b;
            B = a;
        }

        int[] arrA = new int[max];
        int[] arrB = new int[max];
        int[] arr = new int[max];
        int[] over10 = new int[max];

        int chai = A.length() - B.length();

        for (int i = max - 1; i >= 1; i--) {
            arrA[i] = A.charAt(i - 1) - '0';
        }
        for (int i = max - 1; i >= chai + 1; i--) {
            arrB[i] = B.charAt(i - 1 - chai) - 48;
        }

        for (int i = max - 1; i >= 1; i--) {
            arr[i] = arrA[i] + arrB[i];
        }

        for (int i = max - 1; i >= 1; i--) {
            if (arr[i] >= 10) {
                arr[i] %= 10;
                arr[i - 1]++;
            }
        }

        if (arr[0] > 0) {
            num = 0;
        }

        for (int i = num; i < max; i++) {
            System.out.print(arr[i]);
        }
    }
}
