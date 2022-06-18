package inflearn.dfs_bfs;

import java.util.Scanner;

/* 13. 섬나라 아일랜드(DFS)
N*N의 섬나라 아일랜드의 지도가 격자판 정보로 주어질 때, 각 섬의 개수를 구하여라
각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다

첫 줄에 자연수 N, 두 번째 줄 부터 격자판의 정보가 주어짐

입력 예시
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

출력 예시
5
 */
public class Dfs_Bfs13 {
    static int N, answer = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};  //상하좌우와 대각선으로 움직일 때 x 좌표의 변화
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};  //상하좌우와 대각선으로 움직일 때 y 좌표의 변화
    static int[][] board;

    private void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {               //상하좌우와 대각선으로 이동할 수 있는 방향 8가지
            int nx = x + dx[i];                     //이동 후 x의 좌표 nx
            int ny = y + dy[i];                     //이동 후 y의 좌표 ny

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 1) {
                //nx와 ny가 격자판 내에 있고, board의 좌표 값이 1이라면, 즉 섬이라면

                board[nx][ny] = 0;                  //지나온 표시로 0 대입
                DFS(nx, ny);                        //nx와 ny를 매개 변수로 재귀 호출
            }                                       //해당 섬이 0으로 바뀌면 재귀 호출 종료
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];                      //N*N 크기의 격자판 board

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();         //board에 섬나라 아일랜드의 정보 대입
            }
        }

        Dfs_Bfs13 d = new Dfs_Bfs13();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {             //board의 원소가 1이라면
                    board[i][j] = 0;                //지나온 표시로 0 대입
                    answer++;                       //섬의 개수를 표시하는 변수 answer 증가
                    d.DFS(i, j);                    //x, y 좌표를 매개변수로 DFS 메서드 호출
                }                                   //재귀 호출이 종료되면 반복문이 다시 시작
            }
        }

        System.out.println(answer);                 //answer 출력
    }
}
