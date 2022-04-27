package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 8. 송아지 찾기1(BFS: 상태트리탐색)
현수가 스카이 콩콩을 타고 최소 몇번의 점프로 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성
수직선상 좌표 점으로 현수와 송아지의 위치가 주어지고,
현수는 스카이 콩콩을 타고 앞으로 1칸 or 뒤로 1칸 or 앞으로 5칸 이동 가능

첫 줄에는 현수의 위치 S, 송아지 위치 E가 주어짐

입력 예시
5 14

출력 예시
3
 */
public class Recursive_Tree_Graph08 {
    int[] dis = {1, -1, 5};                 //한 번에 이동 가능한 거리(앞으로 1칸, 뒤로 1칸, 앞으로 5칸)
    int[] ch;                               //수직선 좌표, 문제상 1부터 10,000까지 길이
    Queue<Integer> Q = new LinkedList<>();  //

    private void BFS(int s, int e) {        //현수와 송아지의 좌표를 받는 메서드 생성
        ch = new int[10001];                //좌표가 1부터 10,000이므로 배열의 크기는 10,001로 초기화
        ch[s] = 1;                          //현재 현수의 위치인 ch[s]에 1 대입해서 갔던 곳 표시
        Q.offer(s);                         //큐에 혀재 현수의 위치 offer
        int L = 0;                          //Level을 표시하는 L 변수는 0으로 초기화(0번 이동)

        while (!Q.isEmpty()) {              //큐가 빌 때까지 반복
            int len = Q.size();             //큐의 사이즈를 len 변수에 대입

            for (int i = 0; i < len; i++) { //큐의 사이즈만큼 반복
                int x = Q.poll();           //x에 큐에 삽입된 현재 위치를 꺼내 대입

                for (int j = 0; j < dis.length; j++) { //반복문을 통해 각각 이동 거리를 더해줌
                    int nx = x + dis[j];    //문제에선 현재위치 5에 각각 +1, -1, +5를 nx에 대입

                    if (nx == e) {          //nx가 송아지 위치인 e와 같다면
                        System.out.println(L + 1); //현재 위치에서 한 번 더 이동했으므로 L + 1
                        return;             //메서드 종료
                   }

                    if (nx >= 1 && nx <= 10000 && //nx가 좌표상에 위치해 있고
                            ch[nx] == 0) {        //ch[nx]가 0, 즉 이미 지나친 거리가 아니라면
                        ch[nx] = 1;         //1대입
                        Q.offer(nx);        //큐에 각각의 nx를 offer
                    }                       //이 if문을 통해 시간 복잡도를 줄일 수 있음
                }
            }
            L++;                            //반복문 종료 후 L 증가, 한 번 더 이동 했음을 의미
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();

        Recursive_Tree_Graph08 r = new Recursive_Tree_Graph08();
        r.BFS(S, E);
    }
}
