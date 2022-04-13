package inflearn.sorting_searching;

import java.util.Scanner;

/* 3. 삽입 정렬
N개의 숫자를 오름차순으로 정렬하여 출력, 정렬 방법은 삽입정렬
첫 줄에는 자연수 N이, 두 번째 줄에는 자연수가 입력

입력 예시
6
11 7 5 6 10 9

출력 예시
5 6 7 9 10 11
 */
public class Sorting_Searching03 {
    private int[] solution(int n, int[] arr) {

        //2번째 인덱스부터 시작하여 그 앞과 비교하여 정렬
        //앞의 수보다 더 크면 비교를 멈추고 다음 인덱스로 넘어가고, 더 작으면 자리를 바꾼 후 그 앞에 수와 비교를 반복
        for (int i = 1; i < n; i++) {       //비교할 i번째 원소
            int tmp = 0;                    //두 원소를 교환할 때 사용할 변수 선언 및 초기화

            for (int j = i; j > 0; j--) {   //j번 원소는 i번부터 시작해서 0번까지 비교
                if (arr[j - 1] > arr[j]) {  //j번과 j-1과 비교하여 뒤에있는 j번 원소가 작으면 서로 교환
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                } else {                    //j번 원소가 크면 반복 중지
                    break;                  //어차피 앞 원소들은 정렬이 되어있기 떼문에 else문이 없어도 결과는 같지만
                                            //불필요한 계산을 하지 않기위해 적용

                }                           //j가 0이될 때 까지 반복
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

        Sorting_Searching03 s = new Sorting_Searching03();
        for (int x : s.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
