package inflearn.recursive_tree_graph;

import java.util.Scanner;

/* 2. 이진수 출력(재귀)
10진수 N을 2진수로 출력

입력 예시
11

출력 예시
1011
 */
public class Recursive_Tree_Graph02 {
    private static void DEF(int n) {
        if (n == 0) {                   //재귀함수 중단 조건 설정
            return;
        } else {
            DEF(n / 2);              //2진수로 바꿔 주려면 몫이 0이 될 때까지 2로 나누고,
                                        //나머지를 역순으로 읽으면 됨
            System.out.print(n%2);      //나머지를 역순으로 출력
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DEF(N);
    }
}
