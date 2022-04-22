package inflearn.recursive_tree_graph;

import java.util.Scanner;

/* 3. 팩토리얼
자연수 N이 입력되면 N! 출력

입력 예시
5

출력 예시
120
 */
public class Recursive_Tree_Graph03 {
    private int DEF(int n) {
        int sum = 0;                    //팩토리얼의 값을 대입할 변수 선언 및 초기화

        if (n == 0) {                   //재귀함수 종료 조건
            return 1;                   //1을 리턴하면 sum에 1을 곱해주는데, 1을 곱해도 값 변화가 없음
        } else {
            sum = n * DEF(n - 1);    //팩토리얼은 N까지의 모든 수를 곱해주는 것이므로
        }                               //-1씩 한 N을 곱해줌
        return sum;                     //sum 변수 없이 재귀함수 식을 바로 리턴해 줄 수도 있음
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Recursive_Tree_Graph03 r = new Recursive_Tree_Graph03();
        System.out.println(r.DEF(N));
    }
}
