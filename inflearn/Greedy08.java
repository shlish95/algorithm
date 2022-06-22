package inflearn.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 8. 원더랜드(프림: PriorityQueue)
원더랜드의 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로를 폐쇄할 때
유지 비용의 최소 값을 구하여라

첫 줄에 도시의 개수 V와 도로의 개수 E, 다음 E개의 줄에는 각 도로에 대한 정보가 주어짐
도로에 대한 정보는 연결된 두 도시 번호 A와 B, 유지비용인 C가 주어짐

입력 예시
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

출력 예시
196
 */
class Edge08 implements Comparable<Edge08> {//도시의 정보를 담을 Edge07 클래스,
                                            //정렬을 위해 Comparable 인터페이스 상속
    public int vex, cost;                   //연결된 정점 vex(vertex), 유지 비용 cost

    public Edge08(int vex, int cost) {      //생성자 호출
        this.vex = vex;
        this.cost = cost;
    }

    @Override                               //메서드 재정의
    public int compareTo(Edge08 ob) {       //유지 비용을 기준으로 오름차순 정렬
        return this.cost - ob.cost;
    }
}
public class Greedy08 {
    static int[] ch;
    static ArrayList<ArrayList<Edge08>> graph;
    static int answer;

    private void solution(int ar, int cost) {
        PriorityQueue<Edge08> pQ = new PriorityQueue<Edge08>();     //cost의 오름차순으로 정렬되어 작은 수 부터 poll
        pQ.offer(new Edge08(ar, cost));                 //출발 도시 번호와 비용을
                                                        // Edge08 객체에 넣어 pQ에 넣어 줌

        while (!pQ.isEmpty()) {                         //pQ가 비어있지 않다면 반복
            Edge08 tmp = pQ.poll();                     //Edge08 형 변수 tmp에 객체 꺼내서 대입

            if (ch[tmp.vex] == 0) {                     //출발 도시 번호의 ch 값이 0이면 연결이 안되어 있는 것이므로
                ch[tmp.vex] = 1;                        //연결했다는 표시로 1 대입
                answer += tmp.cost;                     //연결 됐으므로 유지 비용인 cost answer에 더해 줌

                for (Edge08 ob : graph.get(tmp.vex)) {  //출발 도시와 기존에 연결된 모든 도시 반복
                    if (ch[ob.vex] == 0) {              //기존 연결된 도시와 연결이 되어있지 않다면
                        pQ.offer(new Edge08(ob.vex, ob.cost));
                    }                                   //연결된 도시의 정보를 객체에 담아 pQ에 넣어줌
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();                   //도시의 개수 변수 V
        int E = sc.nextInt();                   //도로의 개수 변수 E
        ch = new int[V + 1];                    //도시가 연결 되었는지 확인해줄 배열 ch
        answer = 0;                             //최소 도로 유지 비용 변수 answer

        graph = new ArrayList<>();              //현재 모든 도로와 유지 비용의 정보를 담을
                                                // 인접리스트 graph

        for (int i = 0; i <= E; i++) {          //graph에 각 객체 생성
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {           //두 도시 a와 b의 연결 정보와 유지 비용 입력
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge08(b, c)); //양방향 그래프이기 때문에
            graph.get(b).add(new Edge08(a, c)); //a에서 b, b에서 a 두 가지 다 입력
        }

        Greedy08 g = new Greedy08();
        g.solution(1, 0);              //임의의 출발을 1번 도시에서 하기로 하고
                                                //solution 메서드 실행

        System.out.println(answer);             //answer 출력
    }
}
