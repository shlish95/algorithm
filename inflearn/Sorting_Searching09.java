package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

/* 9. 뮤직비디오(결정알고리즘)
N곡의 뮤직비디오를 M개의 DVD에 나눠 담으려 할 때, DVD의 최소 크기를 출력하는 프로그램 작성
N곡의 뮤직비디오는 순서 그대로 유지되어야 하며 M개의 DVD는 모두 같은 크기여야 함

첫 줄에는 자연수 N과 M이, 다음 줄에는 곡의 길이가 분 단위로 주어짐

입력 예시
9 3
1 2 3 4 5 6 7 8 9

출력 예시
17

설명
3개의 DVD의 용량이 17분 (1, 2, 3, 4, 5), (6, 7), (8, 9)
 */
public class Sorting_Searching09 {
    public int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;

        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
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

        Sorting_Searching09 s = new Sorting_Searching09();
        System.out.println(s.solution(N, M, arr));
    }
}
