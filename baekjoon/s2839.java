package baekjoon.yet;

import java.util.Scanner;

/* 설탕 배달
설탕 봉지의 종류가 3키로그램, 5킬로그램있다. N킬로그램의 설탕을 배달할 때 최소 봉지 개수를 구하여라
정확하게 N킬로그램을 만들 수 없다면 -1 출력
3 <= N <= 5000

입력 예시
18

출력 예시
4   ->  5킬로그램 3개, 3킬로그램 1개

동전 교환 문제를 풀 때 사용하는 냅색 알고리즘을 사용하려 했으나 설탕 봉지 1키로그램짜리도 없고, 종류가 2개밖에 없어서 실패했다.
오히려 간단히 생각하니 금방 해결되었다.
최소한의 개수를 구하는 것이므로 더 무거운 5키로로 N을 나누고 계산을 시작하였다.
 */
public class s2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int div5 = N / 5, div3;                 //N을 각각 5와 3으로 나눈 값을 변수 div5와 div3에 대입
        int tmp = 0, answer = -1;               //tmp는 5키로짜리 봉지를 뺄 때마다 5씩 증가
                                                // N키로를 못 만들 경우를 위해 answer는 -1로 초기화

        while(div5 >= 0) {                      //div5가 0보다 크다면 반복
            if (((N % 5) + tmp) % 3 == 0) {     //N을 5로 나눈 나머지에 tmp를 더해준 값이 3으로 나눠떨어지면
                div3 = ((N % 5) + tmp) / 3;     //div3에 N을 5로 나눈 나머지에 tmp를 더해준 값에 3을 나눈 값 대입
                answer = div5 + div3;           //즉 5키로 봉지 개수와 3키로 봉지 개수를 더해주어 answer에 대입
                break;                          //반복 종료

            } else {                            //3으로 나눠 떨어지지 않는다면
                div5--;                         //5키로짜리 봉지를 하나 줄이고
                tmp += 5;                       //tmp를 5 증가

            }                                   //반복
        }

        System.out.println(answer);             //answer 출력
    }
}