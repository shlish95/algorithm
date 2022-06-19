package inflearn.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 14. 섬나라 아일랜드(BFS)
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
class Point14 {                                     //각 지점 x와 y 지점을 표시할 클래스
    int x, y;

    public Point14(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Dfs_Bfs14 {
    static int N, answer;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};  //상하좌우와 대각선으로 움직일 때 x 좌표의 변화
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};  //상하좌우와 대각선으로 움직일 때 y 좌표의 변화
    static int[][] board;
    static Queue<Point14> Q = new LinkedList<>();   //Point14 객체를 저장할 큐 Q

    private void BFS(int x, int y) {
        Q.offer(new Point14(x, y));                 //BFS 메서드 매개변수로 받은 x, y를
                                                    //Point14 객체에 넣어 Q에 저장

        while (!Q.isEmpty()) {                      //Q가 비어있지 않으면 반복
            Point14 tmp = Q.poll();                 //Q에서 꺼낸 객체를 변수 tmp에 대입

            for (int i = 0; i < 8; i++) {           //상하좌우, 대각선 8방향으로 반복
                int nx = tmp.x + dx[i];             //이동 후 x 좌표 위치를 나타낼 변수 nx
                int ny = tmp.y + dy[i];             //이동 후 y 좌표 위치를 나타낼 변수 ny

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 1) {
                    //nx와 ny가 격자판 안에 있고, 해당 격자판 값이 1이라면, 즉 섬이라면

                    board[nx][ny] = 0;              //지나온 표시로 board 좌표 값에 0 대입
                    Q.offer(new Point14(nx, ny));   //nx, ny를 Point14 객체에 넣어 Q에 저장
                }
            }
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

        Dfs_Bfs14 d = new Dfs_Bfs14();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {             //board의 원소가 1이라면
                    board[i][j] = 0;                //지나온 표시로 0 대입
                    answer++;                       //섬의 개수를 표시하는 변수 answer 증가
                    d.BFS(i, j);                    //x, y 좌표를 매개변수로 DFS 메서드 호출
                }                                   //재귀 호출이 종료되면 반복문이 다시 시작
            }
        }

        System.out.println(answer);                 //answer 출력
    }
}
