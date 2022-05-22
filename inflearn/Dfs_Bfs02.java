package inflearn.dfs_bfs;

import java.util.Scanner;

/* 2.바둑이 승차(DFS)
최대 C킬로그램까지 태울 수 있는 트럭에 바둑이들을 최대한 실으려 할 때, 최대 무게를 구하기

첫 줄에는 자연수 C와 바둑이들의 마리 수 N, 두 번째 줄부터 각 바둑이의 무게가 주어짐

입력예시
259 5
81
58
42
33
61

출력 예시
242
 */
public class Dfs_Bfs02 {
    static int C, N, answer = 0;                    //트럭의 최대 무게 C, 바둑이 마리 수 N, 가장 무거운 무게 answer

    private void DFS(int L, int sum, int[] arr) {   //레벨 L, 바둑이들 합계 sum, 배열 arr을 매개변수로 받는 DFS 메서드
        if (sum > C) {                              //바둑이의 합이 트럭 최대 무게보다 무거우면
            return;                                 //메서드를 중단
        }
        if (L == N) {                               //레벨이 바둑이 마리수와 같다면, 즉 모든 경우의 수를 다 구했다면
            answer = Math.max(answer, sum);         //각 sum과 answer을 비교 후 더 큰 값을 answer에 대입

        } else {                                    //같지 않다면
            DFS(L + 1, sum + arr[L], arr);  //sum에 현재 레벨의 바둑이 무게를 더한 경우의 수와
            DFS(L + 1, sum, arr);                //바둑이 무게를 더하지 않은 경우의 수 두 가지로 재귀 호출
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Dfs_Bfs02 d = new Dfs_Bfs02();
        d.DFS(0, 0, arr);
        System.out.println(answer);                 //각 sum 값 중 가장 큰 값인 answer 출력
    }
}
