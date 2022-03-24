package inflearn.tp_sw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
두 집합의 공통 원소를 추출하여 오름차순으로 출력
첫 줄에는 집합 A의 크기 N, 두 번째 줄에는 중복되지 않은 N개의 원소가 주어짐
세 번째 줄에는 집합 B의 크기 M, 네 번째 줄에는 중복되지 않은 M개의 원소가 주어짐

입력 예시
5
1 3 9 5 2
5
3 2 5 7 8

출력 예시
2 3 5
 */
public class Tp_Sw02 {
    public ArrayList<Integer> solution(int n, int[] a, int m, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);                 //배열을 오른차순으로 정렬
        Arrays.sort(b);
        int pa = 0, pb = 0;             //각 배열의 포인터 선언 후 초기화

        while (pa < n && pb < m) {      //두 포인터 모두 각 배열의 크기 보다 작을 때 반복
            if (a[pa] < b[pb]) {        //a배열의 pa번 원소가 b배열의 pb번 원소보다 작으면
                pa++;                   //pa 증가

            } else if (a[pa] > b[pb]) { //b배열의 pb번 원소가 작으면 pb증가
                pb++;                   //오른차순으로 정렬되어 있기 때문에
                                        //작은 숫자를 기준으로 비교해야 생략하는 원소 없음

            } else {                    //지정된 원소가 같다면 원소값을 answer에 추가
                answer.add(a[pa]);
                pa++;                   //각 배열의 포인터 증가
                pb++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();           //집합 A의 크기
        int[] A = new int[N];           //집합 A 선언 후 원소 대입
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();           //집합 B의 크기
        int[] B = new int[M];           //집합 B 선언 후 원소 대입
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        Tp_Sw02 t = new Tp_Sw02();
        for (int x : t.solution(N, A, M, B)) {
            System.out.print(x + " ");
        }
    }
}
