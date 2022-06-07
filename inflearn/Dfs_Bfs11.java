package inflearn.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 11. 미로의 최단거리 통로(BFS)
7*7 격자판 미로를 탈출하는 경로의 최단 거리를 출력하여라
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
12
 */
class Point {                           //각 지점을 표시할 클래스 Point
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Dfs_Bfs11 {
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};            //위, 오른쪽, 아래, 왼쪽으로 움직일 시 x 좌표의 변화
    static int[] dy = {0, 1, 0, -1};            //위, 오른쪽, 아래, 왼쪽으로 움직일 시 y 좌표의 변화

    private void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();    //Point 객체를 저장할 큐 Q
        Q.offer(new Point(x, y));               //Q에 x, y 좌표를 넣은 Point 객체 넣어줌

        while (!Q.isEmpty()) {                  //Q가 비지 않았다면 반복
            Point tmp = Q.poll();               //tmp에 Q에서 꺼낸 Point 객체 대입

            for (int i = 0; i < 4; i++) {       //위, 오른쪽, 아래, 왼쪽 네 방향으로 이동
                int nx = tmp.x + dx[i];         //이동 후 좌표 변수 nx(next x)에 대입
                int ny = tmp.y + dy[i];         //이동 후 좌표 변수 ny(next y)에 대입

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7    //nx, ny가 격자판 내에 있고
                        && board[nx][ny] == 0) {                //해당 좌표 board 값이 0이라면
                    board[nx][ny] = 1;                          //지나갔다는 의미로 1 표시
                    Q.offer(new Point(nx, ny));                 //이동 후 좌표로 Q의 Point 객체 넣어줌
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;        //한 칸 이동했으므로 dis 배열에 이전 좌표 값 + 1 대입
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];                  //격자판 x, y의 각 0번은 사용하지 않는 7*7이므로 크기는 8, 8
        dis = new int[8][8];                    //출발지부터 각 위치의 거리를 입력할 배열 dis(distance)
        for (int i = 1; i <= 7; i++) {          //격자판에 정보 입력
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;                        //출발 지점에 1 대입하여 지나왔다는 것을 표시

        Dfs_Bfs11 d = new Dfs_Bfs11();
        d.BFS(1, 1);                      //출발 지점의 좌표로 BFS 메서드 실행

        if (dis[7][7] == 0) {                   //dis 배열의 도착 지점의 값이 0이라면
            System.out.println(-1);             //즉 도착할 수 있는 경로가 없다면 -1 출력
        } else {                                //0이 아니라면
            System.out.println(dis[7][7]);      //dis 배열의 도착 지점 값 출력
        }
    }
}
