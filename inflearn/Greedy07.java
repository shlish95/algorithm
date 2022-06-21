package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 7. 원더랜드(크루스칼: Union&Find)
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
class Edge07 implements Comparable<Edge07> {    //도시의 정보를 담을 Edge07 클래스,
                                                //정렬을 위해 Comparable 인터페이스 상속
    public int v1, v2, cost;                    //연결된 두 도시 v1과 v2, 유지비용 cost

    public Edge07(int v1, int v2, int cost) {   //생성자 호출
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override                                   //재정의
    public int compareTo(Edge07 ob) {           //cost를 기준으로 오름차순으로 정렬
        return this.cost - ob.cost;
    }
}
public class Greedy07 {
    static int V, E, answer;
    static ArrayList<Edge07>  arr;
    static int[] unf;

    public int Find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();                       //도시의 개수 변수 V
        E = sc.nextInt();                       //도로의 개수 변수 E
        unf = new int[V + 1];                   //연결된 도시를 표시할 배열 unf
        arr = new ArrayList<>();                //Edge07 객체를 저장할 ArrayList arr

        for (int i = 0; i < V + 1; i++) {       //반복문을 통해 인덱스 번호와 값을 맞춰줌
            unf[i] = i;
        }

        for (int i = 0; i < E; i++) {           //Edge07 객체에 값을 넣어 arr에 저장
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            arr.add(new Edge07(v1, v2, cost));
        }

        Collections.sort(arr);                  //arr을 cost 오름차순으로 정렬

        Greedy07 g = new Greedy07();

        for (Edge07 ob : arr) {                 //arr에서 객체를 하나씩 꺼내 반복
            int fv1 = g.Find(ob.v1);            //두 도시 v1, v2를 매개변수로 넣어 Find 메서드 실행
            int fv2 = g.Find(ob.v2);

            if (fv1 != fv2) {                   //fv1과 fv2이 연결되어 있지 않다면
                g.Union(ob.v1, ob.v2);          //v1과 v2를 매개변수로 Union 메서드 실행
                answer += ob.cost;              //answer에 도로 유지비용 cost를 더해줌
            }
        }

        System.out.println(answer);             //answer 출력
    }
}
