package inflearn.tp_sw;

import java.util.Scanner;

/*
입력된 자연수 N을 2개 이상의 연속된 자연수의 합으로 표현하는 방법의 가짓수를 출력
만약 N=15면 7+8, 4+5+6, 1+2+3+4+5 세가지가 존재

입력 예시
15

출력 예시
3
 */
public class Tp_Sw05 {
    public int solution(int n) {
        int answer = 0;
        /* 방법1_배열 생성 후 포인터와 슬라이스 윈도우 사용
        int[] arr = new int[n - 1];             //주어진 자연수보다 작은 수를 넣을 배열 생성
        int sum = 0, lt = 0;                    //합계와 왼쪽 포인터 변수 생성

        for (int i = 0; i < n - 1; i++) {       //배열에 값 대입
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < n - 1; rt++) {    //오른쪽 포인터를 생성 후 반복
            sum += arr[rt];                     //sum값이 n보다 작으면 rt번 인덱스의 배열 원소를 더해줌

            if (sum == n) {                     //sum 값이 n과 같으면 answer 증가
                answer++;
            }

            while (sum >= n) {                  //sum값이 크거나 같으면
                sum -= arr[lt++];               //lt번 인덱스의 배열 원소를 빼주고, lt값 증가

                if (sum == n) {                 //sum값이 n과 같으면 answer 증가
                    answer++;
                }
            }                                   //반복문 종료
        }
        */

        /*방법2_수학적 법칙 사용
        자연수를 1부터 연속된 수를 빼고, 뺀 횟수만큼 나눠서 경우의 수를 구할 수 있다.
        예를 들어 15에서 1과 2를 빼면 12가 남는다. 남은 수를 뺀 수의 개수, 즉 1과 2의 개수로 나눈다.
        2로 나누어 각각에 더해주면 7과 8이 된다. 7과 8의 합은 15가 된다.

        이번에는 1과 2, 3을 빼주고, 남은 수에 3으로 나누면 나머지가 0이다.
        나눈 값을 1, 2, 3에 더해주면 4, 5, 6이 되고 이 값들의 합은 15가 된다.

        결국 연속된 수를 빼고, 뺀 횟수만큼 나누었을 때 나머지가 0이면 N을 표현하는 연속된 자연수의 가짓수를 구할 수 있다.
        */

        int cnt = 0;                //연속된 수의 합을 대입할 변수

        while (n > 0) {
            cnt++;                  //cnt를 증가시켜 임의의 연속된 수의 합을 대신함
            n -= cnt;               //자연수에서 임의의 연속된 수의 합을 빼줌

            if (n % cnt == 0) {     //빼준 값을 나누었을 때 나머지가 0이면 N을 표현하는 연속된 자연수가 있다는 의미이므로
                answer++;           //answer 증가
            }
        }
        return answer - 1;          //자기 자신은 연속된 자연수가 아니기 때문에 가짓수 1개를 빼줌
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Tp_Sw05 t = new Tp_Sw05();
        System.out.println(t.solution(N));
    }
}
