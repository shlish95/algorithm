package inflearn.dfs_bfs;

import java.util.Scanner;

/* 10. 미로탐색(DFS)
7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하여라
출발점은 격자의 (1, 1) 좌표이고, 도착점은 (7, 7) 좌표
1은 벽이고, 0은 통로

7*7 격자판의 정보가 주어짐

입력 예시
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

출력 예시
8
 */
public class Dfs_Bfs10 {
    static int[] dx = {-1, 0, 1, 0};        //위, 오른쪽, 아래, 왼쪽으로 움직일 시 x 좌표의 변화
    static int[] dy = {0, 1, 0, -1};        //위, 오른쪽, 아래, 왼쪽으로 움직일 시 y 좌표의 변화
    static int[][] board;                   //격자판 board
    static int answer = 0;

    private void DFS(int x, int y) {        //x 좌표와 y 좌표를 매개변수로 받는 메서드 DFS
        if (x == 7 && y == 7) {             //x와 y가 7이라면, 즉 도착 지점에 도달했다면
            answer++;                       //answer 증가
        } else {                            //도착하지 않았다면
            for (int i = 0; i < 4; i++) {   //네 방향이기 때문에 i는 0부터 4까지 반복
                int nx = x + dx[i];         //x의 다음 좌표를 나태낼 변수 nx(next x)
                int ny = y + dy[i];         //y의 다음 좌표를 나타낼 변수 ny(next y)

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7    //nx와 ny가 1에서 7 사이이고 board배열의 값이 0이면,
                        && board[nx][ny] == 0) {                //즉 다음 칸으로 이동이 가능하다면
                    board[nx][ny] = 1;      //1을 대입해 되돌아가지 않게 표시
                    DFS(nx, ny);            //nx와 ny를 매개변수로 재귀 호출
                    board[nx][ny] = 0;      //메서드가 끝나면 다시 0을 대입해 다른 경로로 이용할 수 있게 해줌
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];              //각 0번째 배열은 사용하지 않기 때문에 배열의 크기는 8*8
        for (int i = 1; i <= 7; i++) {      //배열 board에 격자판의 정보 입력
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;                    //출발 지점은 1로 초기화
        Dfs_Bfs10 d = new Dfs_Bfs10();
        d.DFS(1, 1);
        System.out.println(answer);
    }
}
