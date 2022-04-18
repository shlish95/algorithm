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
    public int count(int[] arr, int capacity) { //DVD의 크기인 mid 값으로 뮤직비디오를 담는다면
                                                //DVD 몇개가 필요한지 알려주는 메서드
        int cnt = 1, sum = 0;                //DVD 개수를 표현하는 cnt와 뮤직비디오 길이들의 합을 대입할 sum

        for (int x : arr) {                 //arr 원소를 x에 대입해 반복
            if (sum + x > capacity) {       //sum+x가 DVD 용량보다 더 크다면
                cnt++;                      //DVD 개수 증가
                sum = x;                    //sum에 x 대입하여 새로운 DVD에 추가
            } else {                        //sum+x가 DVD 용량보다 작다면 sum에 더해줌
                sum += x;
            }
        }
        return cnt;                         //cnt 반환
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); //arr 배열에서 가장 큰 값을 lt에 대입
                                                      //getAsInt()메서드로 정수형으로 바꿔줘야 함
        int rt = Arrays.stream(arr).sum();      //arr 배열의 원소들을 합한 결과를 rt에 대입

        while (lt <= rt) {                      //lt가 rt보다 커지기 전까지 반복
            int mid = (lt + rt) / 2;            //lt와 rt의 중간값 mid 생성

            if (count(arr, mid) <= m) {         //count 메서드의 결과가 m보다 작거나 같다면
                answer = mid;                   //answer에 mid 대입
                rt = mid - 1;                   //최소값을 찾아야 하기 때문에 mid를 작게 만들어 다시 반복
            } else {
                lt = mid + 1;                   //count 메서드의 결과가 m보다 크다면 DVD크기가 작아
            }                                   //다 넣을 수 없기 때문에 lt 값을 키워줌
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
