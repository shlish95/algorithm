package inflearn.dfs_bfs;

import java.util.Scanner;
/* 9. 조합 구하기
1부터 N까지 적힌 구슬을 중복 없이 M번 뽑을 때 경우의 수를 구하여라

N과 M이 주어짐

입력 예시
4 2

출력 예시
1 2
1 3
1 4
2 3
2 4
3 4
 */
public class Dfs_Bfs09 {
    static int N, M;
    static int[] combi;                         //M번 뽑은 구슬의 번호를 저장할 배열 combi(combination)

    private void DFS(int L, int s) {            //L(Level)과 같은 번호의 구슬을 뽑지 않기 위해 s를 매개변수로 받음
        if (L == M) {                           //M번 뽑았다면
            for (int i : combi) {               //combi 배열을 출력
                System.out.print(i + " ");
            }
            System.out.println();
        } else {                                //아직 덜 뽑았다면
            for (int i = s; i <= N; i++) {      //s부터 N번까지 반복
                combi[L] = i;                   //배열 combi의 L번째에는 i입력
                DFS(L + 1, i + 1);        //L과 i를 증가시켜 재귀호출, L번째에 i가 들어갔으므로 중복을 피하기 위해 i 증가
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];

        Dfs_Bfs09 d = new Dfs_Bfs09();
        d.DFS(0, 1);
    }
}
