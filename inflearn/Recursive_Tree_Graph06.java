package inflearn.recursive_tree_graph;

import java.util.Scanner;

/* 6. 부분집합 구하기(DFS)
자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력
단 공집합은 출력하지 않음

입력 예시
3

출력 예시
1 2 3
1 2
1 3
1
2 3
2
3
 */
public class Recursive_Tree_Graph06 {
    static int N;                               //입력될 수를 대입할 정적 변수 N 선언
    static int[] ch;                            //부분집합 사용 여부를 check해 줄 정적 배열 선언

    private void DFS(int L) {                   //재귀호출 할 메서드 DFS, 매개변수로 몇 Level인지 받음
        if (L == N + 1) {                       //L이 N+1일 경우 재귀호출이 중단되고
            String tmp = "";                    //부분집합들 출력해줄 tmp 매서드 생성 및 초기화

            for (int i = 1; i <= N; i++) {      //ch 배열에서 인덱스 1부터 N까지 사용하므로 i는 1 ~ N까지 반복
                if (ch[i] == 1) {               //i번째 값이 1이라는 것은 i를 부분집합으로 사용한다는 의미
                    tmp += i + " ";             //tmp에 i + " "를 더해주면 문자열로 덧붙혀짐
                }
            }
            if (tmp.length() > 0) {             //공집합의 경우 출력하지 않기 때문에 tmp의 길이가 0보다 클 경우에만 출력
                System.out.println(tmp);
            }
        } else {                                //L이 N+1 보다 작은 경우
            ch[L] = 1;                          //L번째 원소에 1 대입하는 것은 부분집합으로 쓰이는 경우를 의미
            DFS(L + 1);                      //부분집합으로 사용하는 L+1을 매개변수로 한 재귀호출

            ch[L] = 0;                          //L번째 원소에 0 대입하는 것은 부분집합으로 쓰이지 않는 경우를 의미
            DFS(L + 1);                      //부분집합으로 사용하지 않는 L+1을 매개변수로 한 재귀호출
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ch = new int[N + 1];                    //인덱스 값을 가지고 부분집합을 만들어 주기 위해 크기를 N+1로 지정
                                                //1 ~ N까지만 사용
        Recursive_Tree_Graph06 r = new Recursive_Tree_Graph06();
        r.DFS(1);                            //DFS에 1대입하면, 1부터 N+1까지 수행
    }
}
