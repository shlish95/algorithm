package inflearn.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

/* 15. 피자 배달 거리(DFS 활용)
N*N 크기의 도시에서 배달 거리가 최소가 되는 M개의 피자집만 남겨두려 할 때, 도시의 최소 피자 배달 거리를 출력하여라
격자칸에는 빈칸 0, 집 1, 피자집 2로 표현되어 있고, 도시의 피자 배달 거리는 각 집들의 피자 배덜 거리를 합한 것으로
예를 들어 (1, 2)와 (2, 3)의 피자 배달 거리는 |x1 - x2| + |y1 - y2| = 2

입력 예시
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

출력 예시
6
 */
class Point15 {                                 //각 지점을 표시할 클래스 Point15
    public int x, y;

    public Point15(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Dfs_Bfs15 {
    static int N, M, answer;
    static int[] combi;
    static ArrayList<Point15> hs, pz;

    private void DFS(int L, int s) {
        if (L == M) {                           //M개의 피자집이 정해지면
            int sum = 0;                        //배달 거리의 합을 구할 변수 sum 선언 및 초기환

            for (Point15 h : hs) {              //hs의 객체를 반복
                int dis = Integer.MAX_VALUE;    //h로부터 피자집의 거리를 구할 변수 dis

                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                    //h로부터 배달 거리가 가장 짧은 값을 dis에 대입
                }
                sum += dis;                     //h별 dis값을 sum에 합산
            }
            answer = Math.min(answer, sum);     //모든 경우의 수에서 sum 값 중 가장 작은 값 answer에 대입

        } else {                                //M개의 피자집이 정해지지 않았다면
            for (int i = s; i < pz.size(); i++) {   //s부터 pz의 크기까지 반복
                combi[L] = i;                       //combi의 L에 i 대입
                DFS(L + 1, i + 1);            //L과 s 1씩 증가시켜 DFS 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();                       //도시의 크기 N*N
        M = sc.nextInt();                       //남겨질 피자집의 개수 M
        answer = Integer.MAX_VALUE;             //도시의 최소 피자 배달 거리
        combi = new int[M];                     //남겨질 M개 피자집의 모든 경우를 대입할 배열 combi

        hs = new ArrayList<>();                 //Point15 객체를 담아 집(1)과 피자집(2)을 담을
        pz = new ArrayList<>();                 //ArrayList hs(house), pz(pizza)

        for (int i = 0; i < N; i++) {           //2차원 격자판의 정보를 2중 for 문으로 tmp에 대입
            for (int j = 0; j < N; j++) {
                int tmp = sc.nextInt();

                if (tmp == 1) {                 //tmp가 1(집)이면
                    hs.add(new Point15(i, j));  //hs에 Point15 객체로 x, y 좌표 입력
                } else if (tmp == 2) {          //tmp가 2(피자집)이면
                    pz.add(new Point15(i, j));  //pz에 Point15 객체로 x, y 좌표 입력
                }
            }
        }
        Dfs_Bfs15 d = new Dfs_Bfs15();
        d.DFS(0, 0);                      //L(Level)과 s(start value)를 매개변수로
                                                //DFS메서드 실행
        System.out.println(answer);             //answer 출력
    }
}
