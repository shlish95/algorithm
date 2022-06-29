package baekjoon.bronze;

import java.util.Scanner;

/* A+B - 4
두 정수 A와 B를 입력받아 A+B를 출력하여라

입력 예시
1 1
2 3
3 4
9 8
5 2

출력 예시
2
5
7
17
7
 */
public class b10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {   //입력 받은 값이 정수이면 true 반환
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a + b);
        }

        sc.close();                 //더 이상 값을 받지 않게하는 메서드
    }
}
