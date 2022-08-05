package programmers.lv2;

import java.util.*;

/* 게임 맵 최단거리
주어진 5*5 배열 maps에서 (0, 0)부터 (5, 5)까지의 최단 거리를 구하여라
maps의 값이 0인 곳은 벽이 있고 1인 곳은 벽이 없는 곳이며, 이동은 상, 하, 좌, 우로만 할 수 있음
만약 도착이 불가능 한 maps이라면 -1 출력

입출력 예
maps	                                                        answer
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
 */
class Point {                       //좌표를 입력할 객체 Point 클래스
    public int x, y;                //x와 y를 변수로 가지고 있음

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class lv2_게임_맵_최단거리 {
    static int[] moveX = {-1, 0, 1, 0};     //상, 우, 하, 좌로 이동 시 x값의 변화
    static int[] moveY = {0, 1, 0, -1};     //상, 우, 하, 좌로 이동 시 y값의 변화

    public int Bfs(int x, int y, int lenX, int lenY, int[][] maps, int[][] dis) {
        Queue<Point> que = new LinkedList<>();      //이동 후의 좌표를 넣어 줄 큐 que
        que.offer(new Point(x, y));                 //큐에 시작 좌표를 Point 객체로 넣어 줌
        int ans = 0;                                //결과 값을 대입 할 변수 ans

        while(!que.isEmpty()) {                     //que가 비어 있지 않다면 반복
            Point tmp = que.poll();                 //que에서 Point 객체 꺼내 변수 tmp에 대입

            for(int i = 0; i < 4; i++) {            //이동 방향인 상, 우, 하, 좌 각각 반복
                int nx = moveX[i] + tmp.x;          //이동 후 x 좌표 값
                int ny = moveY[i] + tmp.y;          //이동 후 y 좌표 값

                //이동 후 좌표가 maps 안에 위치하며, 벽이 아닐 시
                if(nx >= 0 && nx < lenX && ny >= 0 && ny < lenY && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0;                       //지나왔다는 표시해주고
                    que.offer(new Point(nx, ny));           //이동 후 좌표(x, y) 큐에 넣어줌
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;    //현재 좌표까지의 이동 거리를 dis 배열에 대입
                }
            }
        }

        if(dis[lenX - 1][lenY - 1] == 0) {              //만약 도착지점의 dis 값이 0이라면
            return ans = -1;                            //도착하지 못했으므로 ans는 -1
        } else {                                        //값이 있으면
            return ans = dis[lenX - 1][lenY - 1] + 1;   //도착했으므로 ans에 dis 값 대입
        }
    }
    public static void main(String[] args) {
        //게임 맵을 표시할 2차원 배열 maps
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        //출발 지점부터 현재 좌표까지의 거리를 표시할 2차원 배열 dis
        int[][] dis = new int[maps.length][maps[0].length];

        lv2_게임_맵_최단거리 s = new lv2_게임_맵_최단거리();
        System.out.println(s.Bfs(0, 0, maps.length, maps[0].length, maps, dis));

    }
}
