package inflearn.recursive_tree_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 13. 그래프 최단거리(BFS)
주어진 방향 그래프 1번 정점에서 각 정점으로 가는 최소 이동 간선 수 출력

첫 줄에는 정점 수 N, 간선 수 M
그 다음부터는 M 줄에 걸쳐 연결 정보가 주어짐

입력 예시
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

출력 예시
2: 3
3: 1
4: 1
5: 2
6: 2
 */
public class Recursive_Tree_Graph13 {
    static int N, M;                            //정적 변수로 N, M 선언
    static ArrayList<ArrayList<Integer>> graph; //각 간선을 표현할 graph 선언
    static int[] ch, dis;                       //방문 여부를 확인해줄 배열 ch(check),
                                                //간선 수를 입력 할 배열 dis(distance) 선언

    private void BFS(int v) {                   //출발할 정점 번호를 매개변수를 받는 BFS 메서드
        Queue<Integer> Q = new LinkedList<>();  //간선 이동 경우의 수를 구하기 위해 큐 선언
        Q.offer(v);                             //큐에 매개변수로 받은 v 입력
        ch[v] = 1;                              //v번 정점에서 시작하므로 방문의 의미 1입력
        dis[v] = 0;                             //v번 정점에서 시작하므로 자기 자신과의 거리 0입력

        while (!Q.isEmpty()) {                  //큐가 비어있지 않으면 반복
            int cv = Q.poll();                  //큐에 원소를 꺼내 변수 cv(current vertex)에 대입

            for (int nv : graph.get(cv)) {      //변수 nv(next vertex)에 cv번 정점과 연결되어있는
                                                //정점의 번호 대입하여 반복
                if (ch[nv] == 0) {              //ch 배열의 nv 값이 0, 즉 방문하지 않았다면,
                    ch[nv] = 1;                 //방문했다는 의미로 1대입
                    Q.offer(nv);                //큐에 nv값 넣어줌
                    dis[nv] = dis[cv] + 1;      //배열 dis의 nv번째 값에 1번 정점부터의 거리인
                }                               //현재 정점의 간선 수 + 1 입력
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {          //0부터 N까지 ArrayList객체 add
            graph.add(new ArrayList<>());
        }
        ch = new int[N + 1];                    //1번부터 N번 인덱스까지 사용하므로 배열 크기는 N+1
        dis = new int[N + 1];                   //1번부터 N번 인덱스까지 사용하므로 배열 크기는 N+1

        for (int i = 0; i < M; i++) {           //반복문을 통해 인접리스트 생성
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        Recursive_Tree_Graph13 r = new Recursive_Tree_Graph13();
        r.BFS(1);

        for (int i = 2; i <= N; i++) {          //1번 정점부터 출발한 간선 수를 2번부터 출력
            System.out.println(i + ": " + dis[i]);
        }
    }
}
