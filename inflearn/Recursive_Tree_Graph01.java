package inflearn.recursive_tree_graph;

import java.util.Scanner;

/* 1. 재귀함수
자연수 N이 주어지 1부터 N까지 출력

입력 예시
3

출력 예시
1 2 3
 */
public class Recursive_Tree_Graph01 {
    private static void DEF(int n) {        //반환 값이 없는 메서드 생성(Depth-First Search)
        if (n == 0) {                       //재귀함수의 경우 종료 조건을 걸어주지 않으면 무한 반복 함
            return;                         //void 형의 경우 return이 메서드의 종료를 의미하기도 함
        } else {                            //n이 0이 아닐경우
            DEF(n - 1);                  //DEF 메서드 호출
            System.out.print(n + " ");      //n을 출력, 만약 출력 메서드가 DEF메서드 위에 있다면
        }                                   //1 2 3이 아닌 3 2 1이 출력되었을 것
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DEF(N);
    }
}
