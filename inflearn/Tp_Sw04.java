package inflearn.tp_sw;

import java.util.Scanner;

/*
N개로 이루어진 수열에서 연속된 부분의 합이 M이 되는 경우의 수를 구하여 출력
첫 줄에는 N과 M이, 둘째줄에는 수열이 주어짐

입력 예시
8 6
1 2 1 3 1 1 1 2

출력 예시
3
 */
public class Tp_Sw04 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0, lt = 0;                //임의의 연속된 수열의 합을 대입할 변수 sum, 배열의 왼쪽 포인터 인덱스 값을 대입할 변수 lt

        for (int rt = 0; rt < n; rt++) {    //처음에는 왼쪽, 오른쪽 포인터 둘다 0부터 시작하고,
            sum += arr[rt];                 //rt의 값, 즉 반복 횟수가 n보다 작아야 함
                                            //sum값이 m보다 작을 경우 rt를 하나씩 늘려 다음 수를 더해줌
            if (sum == m) {                 //sum과 m이 같아지면 answer 증가
                answer++;
            }

            while (sum >= m) {              //sum이 m보다 크거나 같을 경우 sum이 더 작아질 때까지 왼쪽 포인터 값을 빼줌
                sum -= arr[lt++];

                if (sum == m) {             //왼쪽 포인터 값을 뺀 후, m과 같아진다면 answer 증가
                    answer++;
                }
            }                               //rt값은 for문이 종료된 후, 반복될 때 증가함
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Tp_Sw04 t = new Tp_Sw04();
        System.out.println(t.solution(N, M, arr));
    }
}
