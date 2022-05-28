package inflearn.d_p;

import java.util.Scanner;

/* 6. 최대 점수 구하기(냅색 알고리즘)
각 문제의 점수와 푸는데 걸리는 시간이 주어지고, 제한 시간 안에 얻을 수 있는 최대 점수를 구하여라

첫 줄에 문제의 개수 N과 제한 시간 M, 두 번째 줄부터 각 문제의 점수와 푸는데 걸리는 시간이 주어짐

입력 예시
5 20
10 5
25 12
15 8
6 3
7 4

출력 예시
41
 */
public class D_P06 {
    static int[] dy;

    private int solution(int n, int m, int[] ps, int[] pt) {
        dy = new int[m + 1];                //배열 dy(dynamic table)에 m시간까지 포함되어야 하므로 크기가 m+1
                                            //또한 문제 수가 제한적이기 때문에 큰 수부터 작아지므로 MAX_VALUE로 초기화 X

        for (int i = 0; i < n; i++) {       //문제 수 n만큼 반복
            for (int j = m; j >= pt[i]; j--) {      //D_P05와 다르게 문제 수가 제한적이기 때문에
                                                    // j는 m부터 작아져야함

                dy[j] = Math.max(dy[j], dy[j - pt[i]] + ps[i]);     //dy에 대입된 값과 비교하여 더 큰 수 대입
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] ps = new int[N];              //각 문제의 점수를 대입할 배열 ps(problem score)
        int[] pt = new int[N];              //각 문제의 걸리는 시간을 대입할 배열 pt(problem time)

        for (int i = 0; i < N; i++) {
            ps[i] = sc.nextInt();
            pt[i] = sc.nextInt();
        }

        D_P06 d = new D_P06();
        System.out.println(d.solution(N, M, ps, pt));
    }
}
