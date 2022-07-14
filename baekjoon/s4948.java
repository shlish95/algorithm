package baekjoon.silver;

import java.util.Scanner;

/* 베르트랑 공준
베르트랑 공준은 임의의 자연수 N에 대하여 N보다 크고 2N보다 작거나 같은 소수는 하나 이상 존재한다는 내용이다.
자연수 N이 주어졌을 때 N보다 크고, 2N보다 작거나 같은 소수의 개수를 구하여라

여러개의 테스트 케이스가 각 줄에 주어지고, 입력 마지막에는 0이 주어짐

입력 예시
1
10
13
100
1000
10000
100000
0

출력 예시
1
4
3
21
135
1033
8392
 */
public class s4948 {
    private static void solution(int n) {       //solution 메서드 실행
        int answer = 0;
        int[] che = new int[2 * n + 1];         //인덱스 번호가 2n까지이므로 배열 che의 크기는 2n + 1 

        che[1] = 1;                             //1은 소수가 아니므로 1대입
        for (int i = 2; i <= 2 * n; i++) {      //소수를 찾기 위해 2부터 2n까지 반복 (1부터 시작하면 무한 대기 걸릴 수 있음)
            if (che[i] == 0) {                  //che[i]가 0이라면 약수가 없었다는 의미이므로 소수
                if (i > n && i <= 2 * n) {      //또한 주어진 범위 내라면  
                    answer++;                   //answer 증가
                }

                for (int j = i; j <= 2 * n; j += i) {   //i의 배수는 소수가 아니므로
                    che[j] = 1;                         //che[j] = 1
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {                          //0이 주어질 때까지 반복
            int N = sc.nextInt();

            if (N == 0) {                       //입력된 값이 0이면 반복 중단
                break;
            }

            s4948.solution(N);                   //solution 메서드에 N을 넣어 실행
        }
    }
}