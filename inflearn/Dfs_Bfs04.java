package inflearn.dfs_bfs;

import java.util.Scanner;

/* 4. 중복순열 구하기
1부터 N까지 번호가 적힌 구슬을 중복을 허락하여, M번 뽑아 나온 결과를 일렬로 나열하는 방법을 모두 출력

자연수 N과 M이 주어짐

입력 예시
3 2

출력 예시
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */
public class Dfs_Bfs04 {
    static int N, M;                        //구슬의 끝 번호 N, 뽑는 횟수 M
    static int[] pm;                        //구슬을 뽑았을 경우 나오는 번호 저장할 배열 pm(permutation)

    private void DFS(int L) {
        if (L == M) {                       //레벨이 M과 같다, 즉 M번 구슬을 뽑았다면
            for (int i : pm) {              //pm의 원소 수만큼, M번 반복하여
                System.out.print(i + " ");  //각 원소를 출력
            }
            System.out.println();           //개행
        } else {                            //구슬을 M번 뽑지 않았다면
            for (int i = 1; i <= N; i++) {  //N번 만큼 반복하여
                pm[L] = i;                  //pm의 L번 인덱스에 i를 대입
                DFS(L + 1);              //레벨을 1증가 시켜 매개변수로 넣어주고 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pm = new int[M];

        Dfs_Bfs04 d = new Dfs_Bfs04();
        d.DFS(0);
    }
}
