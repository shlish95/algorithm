package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* DFS와 BFS
DFS와 BFS로 탐색한 결과를 출력하여라

첫 줄에는 정점의 개수 N, 간선의 개수 M, 탐색 시작할 번호 V가 주어지고
다음 줄 부터 간선을 양방향으로 연결하는 두 정점의 번호가 주어짐

입력 예시
5 5 3
5 4
5 2
1 2
3 4
3 1

출력 예시
3 1 2 5 4
3 1 4 2 5
 */
public class s1260 {
    static int[][] graph;               //간선을 표시하는 이차원 배열 graph
    static boolean[] chD, chB;          //DSF와 BFS에서 해당 인덱스 번호의 정점을 지났는지 체크하는 배열 chD, chB
    static int N, M;                    //정점 개수 N, 간선 개수 M

    private static void DFS(int s) {        //시작 정점 번호를 입력받아 메서드 실행
        if (chD[s]) {                       //배열 chD의 s번 값이 true 이면 이미 탐색한 것이므로 재귀 종료
            return;
        }

        chD[s] = true;                      //탐색을 했다는 표시로 chD의 s 값을 true 대입
        System.out.print(s + " ");          //해당 정점 번호 출력

        for (int i = 1; i <= N; i++) {      //i가 s번 정점과 연결되어있고, chD의 i 값이 false라면(탐색이 아직 안됐다면)
            if (graph[s][i] == 1 && chD[i] == false) {
                DFS(i);                     //i를 매개변수로 DFS메서드 호출(재귀)
            }
        }
    }

    private static void BFS(int s) {        //시작 정점 번호를 입력받아 메서드 실행
        Queue<Integer> q = new LinkedList<>();  //정점 번호를 입력해 줄 큐 q
        q.offer(s);                         //q에 시작 정점의 번호 넣어줌
        chB[s] = true;                      //탐색했다는 표시로 chB의 s번 인덱스에 true 대입

        while (!q.isEmpty()) {              //q가 비어있지 않다면 반복
            int x = q.poll();               //q에 가장 먼저 들어간 값을 꺼내어 x에 대입
            System.out.print(x + " ");      //x 출력

            for (int i = 1; i <= N; i++) {  //i가 s번 정점과 연결되어있고, chB의 i 값이 false라면(탐색이 아직 안됐다면)
                if (graph[x][i] == 1 && chB[i] == false) {
                    chB[i] = true;          //탐색했다는 표시로 chB의 s번 인덱스에 true 대입
                    q.offer(i);             //i를 q에 입력하여 다음 반복때 차래로 탐색
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int start = sc.nextInt();           //탐색 시작 정점을 지정해주는 변수 start

        chD = new boolean[N + 1];           //인덱스 번호가 정점 번호여야하므로 배열 크기는 정점 개수 + 1
        chB = new boolean[N + 1];

        graph = new int[N + 1][N + 1];      //정점간의 간선을 표현하므로 행과 열 각각의 크기는 정점의 개수 + 1

        for (int i = 0; i < M; i++) {       //반복문을 통해 graph에 간선을 표시
            int a = sc.nextInt();           //정점 a와 정점 b의 번호를 입력받아 해당 graph에 1 대입
            int b = sc.nextInt();

            graph[a][b] = 1;                //간선은 양방향이므로 [a][b]와 [b][a]에 각각 1대입
            graph[b][a] = 1;
        }

        s1260.DFS(start);                   //DFS 메서드 실행
        System.out.println();
        s1260.BFS(start);                   //BFS 메서드 실행
    }
}
