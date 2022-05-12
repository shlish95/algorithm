package inflearn.dfs_bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 5. 동전교환(DFS)
여러 단위의 동전으로 거스름돈을 줄 때 가장 적은 수의 동전의 개수를 출력

첫 줄에는 동전 종류의 개수 N, 두 번째 줄에는 동전의 단위 N개가 주어지고 그 다음줄에는 거슬러 줄 금액 M이 주어짐

입력 예시
3
1 2 5
15

출력 예시
3
 */
public class Dfs_Bfs05 {
    static int N, M, answer = Integer.MAX_VALUE;    //answer에는 최소 값이 들어가야하므로 정수의 max값 대입
    static int[] kind;                              //동전의 종류를 kind 배열에 대입

    private void DFS(int L, int sum) {              //매개변수로 동전의 개수인 레벨 L, 동전의 합 sum
        if (L >= answer || sum > M) {               //최소값을 찾는 거기 때문에
            return;                                 //동전의 개수가 answer보다 크면 중단, sum이 M보다 커도 중단
        }

        if (sum == M) {                             //sum이 M과 같다면
            answer = Math.min(answer, L);           //L과 answer에 대입된 값과 비교 후 작은 값 answer에 대입
        } else {                                    //같지 않다면
            for (int i = 0; i < N; i++) {           //동전의 종류만큼 반복
                DFS(L + 1, sum + kind[i]);  //L증가, sum에 해당 동전을 더해주고 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        kind = new int[N];
        for (int i = N - 1; i >= 0; i--) {          //연산 시간 단축을 위해 큰 단위의 동전부터 대입
            kind[i] = sc.nextInt();
        }
//        Arrays.sort(kind, Collections.reverseOrder()); //배열을 역순으로 만들어 주는 함수
        M = sc.nextInt();                           //일반 정수(int)가 아닌 객체형 정수 타입(Integer) 이어야함

        Dfs_Bfs05 d = new Dfs_Bfs05();
        d.DFS(0, 0);
        System.out.println(answer);
    }
}
