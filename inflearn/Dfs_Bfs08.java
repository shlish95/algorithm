package inflearn.dfs_bfs;

import java.util.Scanner;

/* 8. 수열 추측하기
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀있고,
두 번재 줄부터 차례로 파스칼의 삼각형처럼 위에서 두개를 더한 값이 저장된다.
3 1 2 4
 4 3 6
  7 9
   16

이때 N과 가장 밑에 있는 숫자 F가 주어져 있을 때 가장 윗 줄을 구하는 프로그램을 작성하여라

입력 예시
4 16

출력 예시
3 1 2 4
 */
public class Dfs_Bfs08 {
    static int[] b, p, ch;
    static int N, F;
    boolean flag = false;                   //원하는 결과를 도출한 후 재귀 호출을 멈춰 줄 불린 타입 변수 flag
    int[][] dy = new int[N + 1][N + 1];     //메모제이션 배열 dy

    private int combi(int n, int r) {       //nCr의 결과를 반환하는 메서드 combi
        if (dy[n][r] > 0) {                 //dy가 0보다 크다면 nCr의 결과를 이미 계산한 것이므로
            return dy[n][r];                //dy[n][r] 값 반환
        }

        if (n == r || r == 0) {             //nCr에서 n과 r이 같거나 r이 0이라면 무조건 1이므로
            return 1;                       //1 반환
        } else {                            //아니라면
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }                                   //nCr을 재귀 호출로 구하는 공식인 n-1Cr-1 + n-1Cr
    }

    private void DFS(int L, int sum) {
        if (flag) {                         //flag가 참이면 반환을 통해 재귀 호출을 멈춤
            return;
        }

        if (L == N) {                       //L과 N이 같다면, 즉 수열을 구했다면
            if (sum == F) {                 //sum과 F가 같다면 수열 출력
                for (int i : p) {
                    System.out.print(i + " ");
                }
                flag = true;                //재귀 호출을 멈추기 위해 flag에 ture 대입
            }
        } else {                            //L과 N이 같지 않다면
            for (int i = 1; i <= N; i++) {  //i는 인덱스 번호이자 수열이므로 1부터 N까지 반복
                if (ch[i] == 0) {           //ch[i]가 0이라면, 즉 1~N까지 숫자 중 아직 사용되지 않은 숫자라면
                    ch[i] = 1;              //1대입하여 사용했다는 표시 한 후
                    p[L] = i;               //배열 p의 L 번째에 i 대입
                    DFS(L + 1, sum + (b[L] * p[L]));    //매개 변수로 다음 레벨값과
                    ch[i] = 0;                                  //sum 값에 b의 L 번째와 p의 L 번째 값을 곱하여 더해준 값을 줌
                }   //ch[i]에 0을 넣어 주어 사용 했다는 표시를 줌
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = sc.nextInt();
        b = new int[N];                         //순열의 결과를 저장할 배열 b
        p = new int[N];                         //1~N의 수열을 대입할 배열 p(progression)
        ch = new int[N + 1];                    //인덱스 번호가 1~N까지의 수열이므로 배열 ch의 크기는 N+1

        Dfs_Bfs08 d = new Dfs_Bfs08();
        for (int i = 0; i < N; i++) {           //순열을 구하기 위해 combi 메서드 반복
            b[i] = d.combi(N - 1, i);        //n-1C0 ~ n-1Cn-1을 배열 b에 대입
        }
        d.DFS(0, 0);                    //L(Level)과 F와 비교할 sum을 매개 변수로 DFS 메서드 실행
    }
}
