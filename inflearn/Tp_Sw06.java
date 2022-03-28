package inflearn.tp_sw;

import java.util.Scanner;

/*
0과 1로 구성된 N 크기의 수열에서 1로만 구성된 최대길이의 연속 부분 수열의 길이를 출력
이때 0을 1로 k번 바꿀 수 있음
첫 줄에는 수열의 길이 N과 k가, 두 번째 줄에는 0과 1로 구성된 수열이 입력

입력 예시
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1

출력 예시
8
 */
public class Tp_Sw06 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0, lt = 0;                //0을 1로 바꿔주는 횟수를 대입할 변수 cnt, 왼쪽 포인터 lt 선언

        for (int rt = 0; rt < n; rt++) {    //오른쪽 포인터 rt가 n과 같거나 커지기 전까지 반복
            if (arr[rt] == 0) {             //rt 번째 수가 0이면 cnt 증가
                cnt++;
            }

            while (cnt > k) {               //cnt가 k보다 크면
                if (arr[lt] == 0) {         //lt 번째 수가 0이면 cnt 감소;
                    cnt--;
                    }

                lt++;                       //cnt가 k와 같아질 때까지 lt증가
            }
            answer = Math.max(answer, rt - lt + 1);
            // 1로 구성된 수열의 길이, arr[lt]부터 arr[rt]까지의 길이를 answer과 비교해 큰 값을 대입

        }                                   //for문 반복 -> rt 값 증가

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Tp_Sw06 t = new Tp_Sw06();
        System.out.println(t.solution(N, k, arr));
    }
}
