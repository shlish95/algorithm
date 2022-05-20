package inflearn.d_p;

import java.util.Scanner;

/* 2. 돌다리 건너기
N개의 돌로 다리가 만들어진 개울을 건널 때, 한 칸 또는 두 칸씩 건널 수 있다면 개울을 건너는 방법은 몇가지인가?
돌의 개수 N이 주어짐

입력 예시
7

출력 예시
34
 */
public class D_P02 {
    static int[] dy;                        //방법의 수를 저장할 정적 배열 dy 선언

    private int solution(int n) {
        dy[0] = 1;                          //N개의 돌을 건너 반대로 넘어가야 하므로
        dy[1] = 2;                          //돌 0개의 개울을 건너는 방법은 1, 1개의 개울은 2가지 방법이 있음

        for (int i = 2; i <= n; i++) {      //돌 2개부터 구하면 되므로 i는 2부터 반복
            dy[i] = dy[i - 2] + dy[i - 1];  //두 칸 전에서 두 칸씩 건너는 방법과
        }                                   //한 칸 전에서 한 칸씩 건너는 방법을 합하면 됨
        return dy[n];                       //돌 N개일 때 방법의 수 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dy = new int[N + 1];                //인덱스 번호와 돌의 개수를 맞추기 위해 N+1로 크기 선언
        D_P02 d = new D_P02();
        System.out.println(d.solution(N));
    }
}
