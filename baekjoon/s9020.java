package baekjoon.silver;

import java.util.Scanner;

/* 골드바흐의 추측
골드바흐의 추측은 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다.
이러한 수를 골드바흐 수라고 하고, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.

2보다 큰 짝수 n이 주어졌을 때 n의 골드바흐 파티션을 출력하는 프로그램을 출력

첫 줄에 테스트 케이스의 개수 T가 주어지고 각 줄에는 짝수 n이 주어짐
골드바흐 파티션이 여러가지인 경우 두 소수의 차가 가장 작은 것을 출력

입력 예시
3
8
10
16

출력 예시
3 5
5 5
5 11
 */
public class s9020 {
    private static boolean check(int i) {                   //주어진 수가 소수인지 구하는 메서드 check
        for (int j = 2; j <= (int)Math.sqrt(i); j++) {      //주어진 수의 제곱근이하의 수로 나눴을 때
            if (i % j == 0) {                               //나머지가 0인 경우가 있다면 소수가 아니므로
                return false;                               //false 리턴
            }
        }
        return true;                                        //0인 경우가 없다면 true 리턴
    }

    private static void solution(int n) {
        int[] che = new int[n + 1];                 //파티션을 구하기 위해 에라토스테네스의 체 배열 che
        int min = 0;                                //파티션의 작은 값을 표시할 변수 min

        che[1] = 1;                                 //che의 1번 인덱스 값에 1 대입
        for (int i = 2; i < n + 1; i++) {           //n번 인덱스까지 반복
            if (che[i] == 0) {                      //i번 인덱스 값이 0이라면 소수이므로
                if (s9020.check(n - i)) {        //check 메서드를 통해 n-i가 소수인지 확인
                    if (i <= n - i) {               //i가 소수이면서 n-i보다 작거나 같다면 min에 i대입
                        min = i;
                    } else {                        //n-i가 i보다 크면 출력 순서가 달라지므로 반복을 멈춰줌
                        break;
                    }
                }

                for (int j = i; j < n + 1; j += i) { //i의 배수는 소수가 아니므로
                    che[j] = 1;                      //i의 배수에 1 대입
                }
            }
        }
        System.out.println(min + " " + (n - min));  //i와 n-i 출력
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                       //테스트 케이스의 개수 T

        for (int i = 0; i < T; i++) {               //T번 반복하여
            int n = sc.nextInt();                   //짝수 n을 입력 받아

            s9020.solution(n);                      //solution 메서드 실행
        }
    }
}