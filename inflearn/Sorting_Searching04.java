package inflearn.sorting_searching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/* 4. Least Recently Used
캐시메모리에 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램 작성
작업 순으로 캐시메모리에 맨 앞부터 차례로 저장
해야할 작업이 캐시에 없는 상태(Cache Miss)면 마지막 작업이 뒤로 밀리고 새로운 작업이 맨 앞에 입력
해야할 작업이 캐시에 있는 상태(Cache Hit)면 기존 캐시 위치의 작업은 삭제되고 그 앞 작업들이 뒤로 밀린 후 맨 앞에 입력

입력 예시
5 9
1 2 3 2 6 2 3 5 7

출력 예시
7 5 3 2 6
 */
public class Sorting_Searching04 {
    private int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];

        /* 방법1_큐 사용
        Queue<Integer> que = new LinkedList<>();    //캐시메모리와 성질이 비슷한 큐 사용(FIFO)

        for (int x : arr) {                         //작업 횟수만큼 반복
            if (que.size() < s) {                   //큐의 크기가 5 미만이라면 offer
                que.offer(x);
            } else {                                //큐의 크기가 5 이상이고
                if (que.contains(x)) {              //큐에 x가 존재하면
                    que.remove(x);                  //x를 제거 후
                    que.offer(x);                   //새로 offer해 주어 마지막으로 위치 시킴
                } else {                            //큐에 x가 없다면
                    que.poll();                     //poll을 사용해 처음 들어온 원소 제거 후
                    que.offer(x);                   //x 추가
                }
            }
        }
        for (int i = s - 1; i >= 0; i--) {          //큐를 배열의 뒷 부분부터 대입시켜주어 차례를 반대로 해줌
            cache[i] = que.poll();
        }
         */

        //방법2_배열만 사용
        for (int x : arr) {                     //강화된 for문을 통해 작업번호(x)를 하나씩 반복
            int pos = -1;                       //위치를 나타낼 변수에 -1을 대입하여 초기화

            for (int i = 0; i < s; i++) {       //배열 cache의 원소를 반복하여
                if (x == cache[i]) {            //x와 비교하여 같은 것이 있으면
                    pos = i;                    //그 위치를 pos에 대입
                }
            }
            if (pos == -1) {                    //pos가 -1, 즉 cache에 x와 같은 원소가 없다면
                for (int i = cache.length - 1; i > 0; i--) {    //반복문을 사용하여
                    cache[i] = cache[i - 1];                    //cache의 원소들을 한 칸씩 이동
                }
            } else {
                for (int i = pos; i > 0; i--) { //pos가 -1이 아니라면, pos에는 x와 같은 작업번호의 위치가 대입되었으므로
                    cache[i] = cache[i - 1];    //i 이후 원소들을 한칸씩 이동
                }
            }
            cache[0] = x;                       //이동 후에 0번 인덱스에 x 입력
        }
        return cache;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Searching04 s = new Sorting_Searching04();
        for (int x : s.solution(S, N, arr)) {
            System.out.print(x + " ");
        }
    }
}
