package inflearn.sorting_searching;

import java.util.Scanner;

/* 1.선택 정렬
N개의 숫자를 오름차순으로 정렬하여 출력, 정렬 방법은 선택정렬
첫 줄에는 자연수 N이, 두 번째 줄에는 자연수가 입력

입력 예시
6
13 5 11 7 23 15

출력 예시
5 7 11 13 15 23
 */
public class Sorting_Searching01 {
    public int[] solution(int n, int[] arr) {
        //선택정렬은 첫번째 숫자와 나머지 숫자를 비교해 가장 작은 숫자와 바꿔주고,
        //두번째 숫자와 첫번째를 제외한 나머지 숫자를 비교해 가장 작은 숫자와 바꿔준다.
        //이런식으로 반복해 주는 것이 선택정렬을 통해 오름차순으로 정렬하는 것이다.

        for (int i = 0; i < n - 1; i++) {       //i번째 원소와 j번째 원소를 비교하므로 n-1번 반복(n까지 반복해도 상관 없음)
            int tmp = 0;                        //원소들을 서로 바꿀 때 사용할 tmp 변수 생성 및 초기화

            for (int j = i + 1; j < n; j++) {   //i 다음 원소부터 반복문 시작
                if (arr[i] > arr[j]) {          //i번째와 j번째 원소 비교 후, i가 더 크다면
                    tmp = arr[i];               //서로 교환
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;                             //정렬된 arr 배열 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Searching01 s = new Sorting_Searching01();
        for (int x : s.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
