package inflearn.recursive_tree_graph;

import java.util.ArrayList;
import java.util.Scanner;

/* 12. 경로 탐색(인접리스: ArrayList)
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수 출력

첫 줄에는 정점의 수 N, 간선의 수 M
그 다음부터 M 줄에 걸쳐 연결 정보가 주어짐(출발 정점  도착 정점)

입력 예시
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

출력 예시
6
 */
public class Recursive_Tree_Graph12 {
    static int N, M, answer = 0;                    //정점 수 N, 간선 수 M, 경로의 가지수 answer 선언 및 초기화
    static ArrayList<ArrayList<Integer>> graph;     //각 정점간의 관계를 표현할 graph ArrayList 선언,
                                                    //예를 들어 정점 1에서 정점 2로 가는 간선이 있으면 1 ArrayList 안에 2대입
    static int[] ch;                                //지나온 정점을 표시(check) 해줄 배열 선언

    public void DFS(int v) {                        //출발 정점의 번호 v를 매개변수로 받는 메서드
        if (v == N) {                               //v가 N, 즉 마지막 정점이라면
            answer++;                               //answer 증가
        } else {                                    //그렇지 않다면
            for (int nv : graph.get(v)) {       //graph의 v번 ArrayList의 원소를 nv 변수에 대입해 반복
                if (ch[nv] == 0) {                  //ch 배열의 nv번 원소가 0, 즉 지나오지 않았다면
                    ch[nv] = 1;                     //ch의 i번째 인덱스에 1대입하여 지나온 것을 확인 시켜준 후,
                    DFS(nv);                        //도착 정점의 번호를 매개변수로 DFS메서드 실행(재귀)
                    ch[nv] = 0;                     //메서드 실행 후, 지나온 정점을 표시해 두었던 ch 배열에 0 대입해 주어 초기화
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ch = new int[N + 1];                        //정점이 1부터 N까지이므로 N+1로 크기 지정, 0번 인덱스는 사용하지 않음

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {              //ArrayList는 마지막에 add를 해 주므로, i는 0부터 시작해야 함
            graph.add(new ArrayList<Integer>());    //ArrayList 객체 생성 후 add
        }

        for (int i = 0; i < M; i++) {               //출발 정점을 의미하는 a번 Arraylist에 도착 정점을 의미하는 b 추가(add)
            int a = sc.nextInt();                   //a는 출발 정점
            int b = sc.nextInt();                   //b는 도착 정점
            graph.get(a).add(b);
        }

        Recursive_Tree_Graph12 r = new Recursive_Tree_Graph12();
        ch[1] = 1;                                  //출발 정점이 1이기 때문에 ch의 1번 인덱스는 1 대입
        r.DFS(1);                                //메서드에 출발 정점 번호인 1을 매개변수로 넣고 실행
        System.out.println(answer);
    }
}
