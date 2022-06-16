package inflearn.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 12. 토마토(BFS 활용)
한 칸에 토마토 하나씩 넣어 N*M 크기의 상자에 넣었을 때,
잘 익은 토마토에 영향을 받아 덜 익은 토마토가 다 익게되는 최소 날짜를 구하여라

익은 토마토 인접한 곳에 있는 덜 익은 토마토는 하루가 지나면 익게됨
잘 익은 토마토는 인접한 앞, 오른쪽, 뒤, 왼쪽 네 방향에 있는 토마토에 영향을 주며, 상자 일부 칸은 비어있음

첫 줄에는 상자의 세로 칸 N과 가로 칸 M이 주어지고, 다음 줄부터 상자에 담긴 토마토 정보가 주어짐
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 빈 칸

입력 예시
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1

출력 예시
4
 */
class Point12 {                             //각 지점을 표시할 클래스 Point12
    public int x, y;

    public Point12(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Dfs_Bfs12 {
    static int N, M;
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};        //주변에 영향을 줄 수 있는 방향 앞, 오른쪽, 뒤, 왼쪽
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point12> Q = new LinkedList<>();

    private void BFS() {
        while (!Q.isEmpty()) {              //Q가 비어있지 않다면 반복
            Point12 tmp = Q.poll();         //tmp에 Q에서 꺼낸 Point12 객체 대입

            for (int i = 0; i < 4; i++) {   //주변에 영향을 줄 수 있는 4방향 전부 반복
                int nx = tmp.x + dx[i];     //이동 후 x 좌표 변수 nx에 대입
                int ny = tmp.y + dy[i];     //이동 후 y 좌표 변수 ny에 대입

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                    //nx, ny가 board 내에 있고, board[nx][ny]의 값이 0이라면
                    
                    board[nx][ny] = 1;      //1 대입해 익은 토마토로 바뀌었다는 표시
                    Q.offer(new Point12(nx, ny));   //이동 후 좌표 Q에 넣어 줌
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;    //하루가 지났으므로 이동 전 좌표 값에 +1
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        board = new int[N][M];                  //상자의 정보 board, 크기는 가로 칸 N * 세로 칸 M
        dis = new int [N][M];                   //익은 토마토부터의 거리(날짜)를 대입할 배열 dis

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();     //상자에 들어있는 토마토 정보 입력

                if (board[i][j] == 1) {         //익은 토마토가 들어있다면 큐 Q에
                    Q.offer(new Point12(i, j)); //좌표 정보를 넣어 줌
                }
            }
        }

        Dfs_Bfs12 d = new Dfs_Bfs12();
        d.BFS();                                //BFS 메서드 실행

        boolean flag = true;                    //토마토가 다 익었는지 확인할 변수 flag
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {         //상자에 덜 익은 토마토가 있다면
                    flag = false;               //flag에 false 대입
                }
            }
        }

        int answer = Integer.MIN_VALUE;         //최소 날짜를 대입 할 변수 answer
        if (flag) {                             //flag가 true라면
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    answer = Math.max(answer, dis[i][j]);   //dis 원소 중 가장 큰 값을 answer에 대입
                }
            }
            System.out.println(answer);         //answer 출력
        } else {
            System.out.println(-1);             //flag가 false라면 -1 출력
        }
    }
}