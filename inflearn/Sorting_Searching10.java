package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

/* 10. 마구간 정하기(결정알고리즘)
수직선 상에 있는 N개의 마구간에 C 마리의 말을 넣고 가장 가까운 두 말의 거리가 최대가 되는 값 출력
각 마구간에는 한 마리의 말만 넣을 수 있고, 서로 붙어있는 것을 좋아하지 않음

첫 줄에는 자연수 N과 C가, 두 번째 줄에는 마구간의 좌표가 주어짐

입력 예시
5 3
1 2 8 4 9

출력 예시
3
 */
public class Sorting_Searching10 {
    private int solution(int n, int c, int[] pos) {
        int answer = 0;
        Arrays.sort(pos);                   //pos 오름차순으로 정렬
        int lt = 1;                         //좌표값이 아닌 마구간 사이의 거리를 구하므로 lt는 1 대입
        int rt = pos[n - 1];                //각 마구간 사이의 최대 길이는 좌표의 가장 큰 값이므로 lt에 대입

        while (lt <= rt) {                  //결정알고리즘의 반복 조건은 거의 이렇게 주면 된다고 함
            int mid = (lt + rt) / 2;        //mid 선언 및 대입

            if (count(pos, mid) >= c) {     //count의 결과가 말 마리수 c보다 크거나 같으면
                answer = mid;               //조건에 성립하는 것이므로 일단 answer에 mid 대입
                lt = mid + 1;               //더 조건에 부합한 값을 찾기 위해 lt 값 수정

            } else {                        //count의 결과가 말 마리수 c보다 작다면
                rt = mid - 1;               //조건에 성립하지 않으므로 rt 값 수정
            }
        }
        return answer;
    }
    private int count(int[] pos, int mid) { //주어진 mid로 몇 마리의 말이 들어갈 수 있는지 확인하는 메서드
        int cnt = 1;                        //좌표 0번 인덱스에 한 마리는 무조건 들어가므로 1 대입
        int ep = pos[0];                    //End Position, 마지막 말의 좌표를 나타내는 변수

        for (int i = 1; i < pos.length; i++) {  //1번 인덱스부터 끝까지 반복
            if (ep + mid <= pos[i]) {       //두 말의 사이 거리를 나타내는 mid를 ep에 더한 값이
                                            //다음 좌표값보다 작으면 조건에 성립하는 것이므로
                cnt++;                      //말의 마리수를 표현하는 cnt 증가
                ep = pos[i];                //마지막 말의 위치인 ep에 i번째 좌표값 대입
            }
        }
        return cnt;                         //cnt 출력
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[i] = sc.nextInt();
        }

        Sorting_Searching10 s = new Sorting_Searching10();
        System.out.println(s.solution(N, C, pos));
    }
}
