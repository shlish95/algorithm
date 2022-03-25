package inflearn.tp_sw;

import java.util.Scanner;

/*
N일 동안의 매출 기록 중 연속된 K일 동안의 최대 매출액을 출력
첫 줄에는 N과 K가, 두 번째 줄에는 N개의 숫자가 주어짐

입력 예시
10 3
12 15 11 20 25 10 20 19 13 15

출력 예시
56
 */
public class Tp_Sw03 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;                            //k일 수만큼의 매출 합계를 구해줄 변수 sum

        for (int i = 0; i < k; i++) {           //1일부터 k일간의 합계를 sum과 answer에 대입
            sum += arr[i];
        }
        answer = sum;

        for (int i = k; i < n; i++) {           //2일부터 n일까지 각 합계를 구해 sum에 대입 후 answer과 비교
            sum = sum - arr[i - k] + arr[i];

            if (sum > answer) {                 //비교해서 sum이 더 크면 answer에 sum 대입
                answer = sum;                   //if문은 answer = Math.max(answer, sum) 으로 대체 가능
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                   //총 일 수 N
        int K = sc.nextInt();                   //연속된 일 수 K
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Tp_Sw03 t = new Tp_Sw03();
        System.out.println(t.solution(N, K, arr));
    }
}
