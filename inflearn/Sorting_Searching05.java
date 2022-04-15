package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

/* 5. 중복 확인
1부터 10,000,000까지의 자연수 N개 중 중복된 숫자가 있으면 D(Duplication)를 출력, 없으면 U(Unique) 출력
첫 줄에는 자연수 N, 두 번째 줄에는 N개의 자연수가 입력

입력 예시
8
20 25 52 30 39 33 43 33

출력 예시
D
 */
public class Sorting_Searching05 {
    private char solution(int n, int[] arr) {
        char answer = 'U';                  //리턴해줄 answer 변수 선언 및 'U' 대입

        Arrays.sort(arr);                   //배열 arr을 오름차순으로 정렬

        for (int i = 0; i < n; i++) {       //정렬되어있기 때문에 같은 숫자라면 연속되어 있으므로
            if (arr[i] == arr[i + 1]) {     //i번과 바로 다음 인덱스 번호의 원소 비교 후,
                return 'D';                 //같으면 'D' 리턴
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Searching05 s = new Sorting_Searching05();
        System.out.println(s.solution(N, arr));
    }
}
