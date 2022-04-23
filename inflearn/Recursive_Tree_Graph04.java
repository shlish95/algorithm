package inflearn.recursive_tree_graph;

import java.util.Scanner;

/* 4. 피보나치 재귀(메모이제이션)
입력된 N개의 수 만큼 피보나치 수열을 출력하여라

입력 예시
10

출력 예시
1 1 2 3 5 8 13 21 34 55
 */
public class Recursive_Tree_Graph04 {
    static int[] arr;           //정적 배열 arr 선언

    private int DEF(int n) {    //DEF 메서드 선언
        if (arr[n] != 0) {      //원소가 0이 아니라는 것은 이미 같은 n값으로 실행 했다는 의미이므로,
            return arr[n];      //재귀 사용하지 않도 n번째 인덱스 값 반환
        }
        if (n == 1) {           //피보나치 수열의 첫 번째와 두 번째 값은 항상 1
            return arr[n] = 1;
        } else if (n == 2) {
            return arr[n] = 1;
        } else {                //세 번째부터 n 번째 값은 n-2와 n-1의 합이므로
            return arr[n] = DEF(n - 2) + DEF(n - 1);    //재귀함수를 통해 결과를 도출
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N + 1];                   //배열의 1번 인덱스부터 N번까지 사용하므로 크기는 N+1

        Recursive_Tree_Graph04 r = new Recursive_Tree_Graph04();
        r.DEF(N);                               //DEF 메서드에 N을 매개변수로 넣고 실행


        for (int i = 1; i <= N; i++) {          //DEF 메서드 실행 결과로 arr 배열이 채워지고
            System.out.print(arr[i] + " ");     //배열의 1번 인덱스부터 N번까지 출력
        }
    }
}
