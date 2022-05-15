package inflearn.dfs_bfs;

import java.util.Scanner;

/* 7. 조합의 경우수(메모이제이션)
nCr = n! / (n - r)! * r! 를 재귀를 이용해 조합수를 구하여라
=> nCr = n-1Cr-1 + n-1Cr
n개를 r개 뽑을 때의 조합 수

첫 줄에 n과 r이 주어짐

입력 예시
5 3

출력 예시
10
 */
public class Dfs_Bfs07 {
    static int[][] dy;                  //메모이제이션 배열 dy, 이미 구한 결과를 저장해 놓고 불러와 시간을 절약

    private int DFS(int n, int r) {     //가지 수 n과 뽑는 수 r을 매개변수로 메서드 선언
        if (dy[n][r] != 0) {            //배열 dy의 n, r번째의 값이 0이 아니면, 즉 이미 계산된 결과가 있다면
            return dy[n][r];            //값 반환
        }

        if (n == r || r <= 0) {         //n과 r이 같거나, r이 0일 경우에는 1가지 수밖에 없기 때문에
            return 1;                   //1 반환
        } else {                        //아니라면
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }                               //공식대로 적용, 결과는 배열 dy에 저장
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        dy = new int[n + 1][r + 1];     //0에서부터 n과 r까지 인덱스 값이 주어지므로 배열의 크기는 n+1, r+1

        Dfs_Bfs07 d = new Dfs_Bfs07();
        System.out.println(d.DFS(n, r));
    }
}
