package inflearn.d_p;

import java.util.Arrays;
import java.util.Scanner;

/* 5. 동전교환(냅색 알고리즘)
주어진 여러 단위의 동전들로 거스름돈을 줄 때, 동전의 수가 가장 적을 때의 개수를 구하여라

첫 줄에는 동전 종류의 개수 N, 두 번째 줄에는 N개의 동전 종류가 주어지고
그 다음줄에 거슬러 줄 금액 M이 주어짐

입력 예시
3
1 2 5
15

출력 예시
3
 */
public class D_P05 {
    static int[] coin;                          //동전 종류를 넣을 배열 coin 선언

    private int solution(int n, int m, int[] dy) {
        Arrays.fill(dy, Integer.MAX_VALUE);     //최소값을 구하기 때문에 정수의 최대 값으로 초기화
        dy[0] = 0;                              //거스름돈이 0이면 동전도 0개이므로 0 대입

        for (int i = 0; i < n; i++) {           //동전 종류별로 적용해야 하므로 동전 종류 개수만큼 반복
            for (int j = coin[i]; j <= m; j++) {    //해당 동전 단위 이상의 거스름돈부터 반복 시작
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }                                   //현재 동전 가격(coin[i])을 뺀 거스름돈의 최소 개수(dy[j-coin(i)]에
        }                                       //1을 더한 것이 현재 거스름돈(dy[j])의 최소값이면 대입
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] dy = new int[M + 1];              //배열 dy(dynamic table) 선언,
                                                //거스름돈과 인덱스 번호를 맞춰주기 위해 크기를 +1 해줌
        D_P05 d = new D_P05();
        System.out.println(d.solution(N, M, dy));
    }
}
