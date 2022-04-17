package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

/* 8. 이분검색
임의의 N개의 숫자를 오름차순으로 정렬한 후, M이 몇 번째에 있는지 출력
첫 줄에는 자연수 N과 M이, 두 번째 줄에는 N개의 수가 주어짐

입력 예시
8 32
23 87 65 12 57 32 99 81

출력 예시
3
 */
public class Sorting_Searching08 {
    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt = n - 1;         //arr의 양쪽 끝 값을 지정할 변수 선언 및 초기화

        Arrays.sort(arr);               //arr을 오름차순으로 정리

        while (rt >= lt) {              //오른쪽 끝 인덱스가 왼쪽 끝 인덱스보다 작아지면 반복 중단
            int mid = (rt + lt) / 2;    //가운데 인덱스 지정

            if (arr[mid] == m) {        //arr의 가운데 값이 m이면 answer mid + 1 값 대입
                answer = mid + 1;       //인덱스 번호는 0부터 시작이기 때문에 +1 해줌
                break;                  //반복문 중단
            }

            if (arr[mid] > m) {         //arr 가운데 값이 m보다 크면 rt를 mid - 1로 바꿔줌
                rt = mid - 1;           //mid까지 제외시키기 위해 -1 해주지만 안해줘도 무방
            } else {                    //반대의 경우
                lt = mid + 1;           //lt를 mid + 1로 바꾸줌, 같은 이유로 +1 안해줘도 무방
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Searching08 s = new Sorting_Searching08();
        System.out.println(s.solution(N, M, arr));
    }
}
