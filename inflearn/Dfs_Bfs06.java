package inflearn.dfs_bfs;

import java.util.Scanner;

/* 6. 순열 구하기
10이하 N개의 자연수가 주어지면, 이 중 M개를 뽑아 나열하여 출력

첫 줄에는 자연수 N과 M, 두 번째 줄에는 N개의 자연수가 오름차순으로 주어짐

입력 예시
3 2
3 6 9

출력 예시
3 6
3 9
6 3
6 9
9 3
9 6
 */
public class Dfs_Bfs06 {
    static int N, M;
    static int[] pm, arr, ch;           //뽑은 M개의 수 pm, N개의 수 종류 arr, 중복 확인 해줄 ch 정적 배열 선언

    private void DFS(int L) {           //뽑은 횟수인 레벨을 매개변수로 받는 메서드
        if (L == M) {                   //L과 M이 같으면, 즉 M번 다 뽑았으면 출력
            for (int i = 0; i < M; i++) {
                    System.out.print(pm[i] + " ");
            }
            System.out.println();
        } else {                        //같지 않다면
            for (int i = 0; i < N; i++) {   //종류가 N개니까 N번 반복
                if (ch[i] == 0) {       //배열 ch의 i번 값이 0이면, 즉 중복되지 않는 숫자이면
                    ch[i] = 1;          //중복되지 않도록 1 대입
                    pm[L] = arr[i];     //배열 pm L번째에 배열 arr의 i번째 대입
                    DFS(L + 1);      //L 증가시켜 매개변주로 넣고 재귀 호출
                    ch[i] = 0;          //메서드 종료 후 다시 0 대입해 줌
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pm = new int[M];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        ch = new int[N];

        Dfs_Bfs06 d = new Dfs_Bfs06();
        d.DFS(0);
    }
}
