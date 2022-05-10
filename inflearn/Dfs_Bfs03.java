package inflearn.dfs_bfs;

import java.util.Scanner;

/* 최대점수 구하기(DFS)
각 문제는 점수와 푸는데 걸리는 시간이 주어지고, 제한시간 동안 얻을 수 있는 최대 점수 출력

첫 줄에는 문제의 개수 N과 제한시간 M, 두 번째 줄부터 N줄에 걸쳐 점수와 걸리는 시간이 주어짐

입력 예시
5 20
10 5
25 12
15 8
6 3
7 4

출력 예시
41
 */
public class Dfs_Bfs03 {
    static int N, M, answer = 0;                //총 문제 수 N, 제한시간 M, 최대 점수 answer

    private void DFS(int L, int sumN, int sumM, int[][] arr) {
                 //레벨 L, 점수의 합 sumN, 시간의 합 sumM, 각 문제별 점수와 걸리는 시간 배열 arr
        if (sumM > M) {                         //시간의 합이 제한시간보다 크면 메서드 중단
            return;
        }

        if (L == N) {                           //레벨과 총 문제 수가 같다면, 즉 모든 경우의 수를 구했다면
            answer = Math.max(answer, sumN);    //sumN 값 중 제일 큰 값을 answer에 넣어줌
        } else {
            DFS(L + 1, sumN + arr[L][0], sumM + arr[L][1], arr); //해당 레벨의 문제를 풀었을 경우
            DFS(L + 1, sumN, sumM, arr);                                      //풀지 않았을 경우
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][2];            //2차원 배열에 각 문제당 점수와 걸리는 시간을 대입
        for (int i = 0; i < N; i++) {           //강의에서는 1차원 배열 2개를 생성
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Dfs_Bfs03 d = new Dfs_Bfs03();
        d.DFS(0, 0, 0, arr);
        System.out.println(answer);
    }
}
