package inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 5. 다익스트라 알고리즘
가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리 비용을 출력하여라
경로가 없으면 Impossible을 출력

첫 줄에는 정점의 수 N, 간선의 수 M, 그 다음 줄부터 연결 정보와 거리 비용이 주어짐
(1번 정점에서 2번 정점으로 가는데 12의 비용이 듬)

입력 예시
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

출력 예시
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
 */
class Edge implements Comparable<Edge> {    //정점과 거리 비용의 정보를 담고 순서를 정렬해줄 클래스 Edge
    public int vtx, cost;                   //정점 vtx(vertext), 거리 비용 cost

    Edge(int vtx, int cost) {               //생성자 선언
        this.vtx = vtx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {          //compareTo 메서드를 재정이하여 cost 오름차순으로 정렬
        return this.cost - o.cost;
    }
}
public class Greedy05 {
    static int N, M;                        //정점 개수 N, 간선 수 M
    static ArrayList<ArrayList<Edge>> graph;//Edge 객체를 담고있는 ArrayList 형을 담은 ArrayList graph
    static int[] dis;                       //1번 정점부터의 거리 정보를 담을 배열 dis(distance)

    private void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(); //우선순위 큐 pQ 선언(cost 으름차순)
        pQ.offer(new Edge(v, 0));      //1번 정점은 이동을 안했으므로 거리 비용 0의 Edge 객체 pQ에 넣어줌
        dis[v] = 0;                         //dis 배열의 1번에도 0 입력

        while (!pQ.isEmpty()) {             //pQ가 비어있지 않으면 반복
            Edge tmp = pQ.poll();           //pQ에서 cost가 가장 작은 원소를 변수 tmp에 대입
            int now = tmp.vtx;              //변수 now에 tmp의 정점 번호 대입
            int nowCost = tmp.cost;         //변수 nowCost에 tmp의 거리 비용 대입

            if (nowCost > dis[now]) {       //만일 nowCost보다 dis[now] 값이 작다면 반복문 처음부터 시작
                continue;                   //최소값을 찾기 때문에 굳이 아래 코드를 실행할 필요 없음
            }

            for (Edge ob : graph.get(now)) {//cost의 오름차순으로 정렬된 graph의 now번째 객체를 ob에 대입
                if (dis[ob.vtx] > nowCost + ob.cost) {  //dis[ob.vtx]가 nowCost와 ob.cost를 합한 것 보다 크다면
                    dis[ob.vtx] = nowCost + ob.cost;    //dis[ob.vtx]에 대입
                    pQ.offer(new Edge(ob.vtx, nowCost + ob.cost));  //pQ에 offer
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        
        for (int i = 0; i <= N; i++) {          //graph에 ArrayList<Edge> 객체 생성
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[N + 1];                   //인덱스 번호가 정점 번호이므로 N+1 크기로 선언
        Arrays.fill(dis, Integer.MAX_VALUE);    //최소값을 구하므로 MAX_VALUE로 초기화
        
        for (int i = 0; i < M; i++) {           //graph에 가중치 방향 그래프 정보 입력
            int l = sc.nextInt();
            int a = sc.nextInt();
            int c = sc.nextInt();

            graph.get(l).add(new Edge(a, c));
        }

        Greedy05 g = new Greedy05();

        g.solution(1);                       //1번 정점을 매개변수로 메서드 실행
        for (int i = 2; i <= N; i++) {          //1번 정점으로부터 거리를 구하는 것이므로 2부터 N까지 반복
            if (dis[i] != Integer.MAX_VALUE) {  //dis의 i값이 MAX_VALUE가 아니라면, 즉 입력된 값이 있으면
                System.out.println(i + " : " + dis[i]);     //dis[i] 값 출력
            } else {                            //dis의 i값이 MAX_VLAUE라면
                System.out.println(i + " : Impossible");    //"Impossible" 출력
            }
        }
    }
}
