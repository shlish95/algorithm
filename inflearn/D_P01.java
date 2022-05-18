package inflearn.d_p;

import java.util.Scanner;

/* 1. 계단오르기
계단을 한 번에 한 계단 또는 두 계단씩 올라갈 때, N 계단을 올라갈 수 있는 방법의 수를 구하여라
계단의 개수인 자연수 N이 주어짐

입력 예시
7

출력 예시
21
 */
public class D_P01 {
    static int[] dy;                    //방법의 수를 저장할 정적 배열 dy 선언

    private int solution(int n) {
        dy[1] = 1;                      //한 계단을 올라가는 방법은 1가지
        dy[2] = 2;                      //두 계단을 올라가는 방법은 2가지

        for (int i = 3; i <= n; i++) {  //세 번째 계단부터 계산하면 되므로 i는 3부터 반복 시작
            dy[i] = dy[i - 2] + dy[i - 1];
        }                               //두 계단 전에서 두 칸 오르는 방법과
                                        //한 계단 전에서 한 칸 오르는 방법을 합하면 됨
        return dy[n];                   //n 계단 오르는 방법 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dy = new int[N + 1];                //인덱스 번호와 계단의 개수를 맞춰주기 위해 N+1 크기로 선언

        D_P01 d = new D_P01();
        System.out.println(d.solution(N));
    }
}
