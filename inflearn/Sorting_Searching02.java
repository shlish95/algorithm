package inflearn.sorting_searching;

import java.util.Scanner;

/* 2. 버블 정렬
N개의 숫자를 오름차순으로 정렬하여 출력, 정렬 방법은 버블정렬
첫 줄에는 자연수 N이, 두 번째 줄에는 자연수가 입력

입력 예시
6
13 5 11 7 23 15

출력 예시
5 7 11 13 15 23
 */
public class Sorting_Searching02 {
    private int[] solution(int n, int[] arr) {
        //버블 정렬은 첫번째와 두번째 숫자를 비교해 작은 숫자를 앞에, 큰 숫자는 뒤에 위치시킨다.
        //두번째와 세번째, 네번째와 다섯번째... 마지막까지 반복하면 가장 큰 수는 맨 뒤에 위치한다.
        //이렇게 두 수를 비교하는 것을 전체 배열의 수 - 1번하면 오름차순으로 정렬이 된다.

        for (int i = 0; i < n - 1; i++) {       //반복할 횟수는 배열의 크기 -1
            for (int j = 1; j < n - i; j++) {   //j를 1부터 시작하고, 맨 뒤는 가장 큰 수가 위치하므로 반복횟수는 n-i까지 해줌
                int tmp = 0;                    //두 원소를 바꿀 때 사용할 변수 선언 및 초기화

                if (arr[j] < arr[j - 1]) {      //j번째와 j-1번째를 비교하여 j-1번째 원소가 크다면
                    tmp = arr[j];               //두 원소를 교체해 줌
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Searching02 s = new Sorting_Searching02();
        for (int x : s.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
