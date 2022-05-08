package inflearn.dfs_bfs;

import java.util.Scanner;

/* 1. 합이 같은 부분집합(DFS)
N개의 원소로 구성된 자연수 집합을 두 개로 나누었을 때 서로의 합이 같으면 YES, 틀리면 NO 출력

첫 줄에는 자연수 N, 다음 줄에는 원소 N개가 주어짐

입력 예시
6
1 3 5 6 7 10

출력 예시
YES
 */
public class Dfs_Bfs01 {
    static String answer = "NO";                //결과를 출력할 변수 answer
    static int N, total = 0;                    //입력될 자연수의 개수 변수 N
    boolean flag = false;                       //재귀 호출의 실행 여부를 확인해줄 변수 flag

    private void DFS(int L, int sum, int[] arr) { //레벨 L, 부분 집합의 합 sum, 배열 arr을 매개변수로 DFS 메서드 생성
        if (flag == true || sum > total / 2) {  //flag가 true이고, 부분집합의 합이 전체 집합의 합/2 보다 크면
            return;                             //재귀호출 중단
        }

        if (L == N) {                           //레벨이 N과 같다면 전체 집합의 원소를 한 번씩 호출한 것이므로
            if (total - sum == sum) {           //전체 집합의 합과 부분 집합의 합에 차의 결과가 부분 집합의 합이면
                answer = "YES";                 //answer에 YES 대입
                flag = true;                    //재귀 호출을 멈추기 위해 flag에 true 대입
            }
        } else {                                //레벨이 N과 다르다면, 해당 레벨의 원소를 합할지에 따라 두 가지로 재귀 호출
            DFS(L + 1, sum + arr[L], arr); //레벨은 +1, 해당 레벨에 원소를 더해준다면 sum에 해당 원소를 더해줌
            DFS(L + 1, sum, arr);               //레벨은 +1, 해당 레벨의 원소를 더하지 않는다면 sum 그대로 매개변수 삽입
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];                        //전체 원소의 합
        }

        Dfs_Bfs01 d = new Dfs_Bfs01();
        d.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
