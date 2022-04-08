package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 6. 공주 구하기
왕자 N명 중 괴물에게 잡혀간 공주를 구하러 갈 왕자 번호 출력
1번부터 N번까지 동그랗게 앉아 K번째 왕자를 제외하고, 그 다음 왕자부터 K번째 왕자 또한 제외한다.
이렇게 반복 했을 때 마지막 남은 왕자가 공주를 구하러 갈 수 있다.

N과 K가 입력된다.

입력 예시
8 3

출력 예시
7
 */
public class Stack_Queue06 {
    private int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();    //1부터 N명의 왕자들을 입력할 큐 선언

        for (int i = 1; i <= n; i++) {              //큐에 한명씩 입력
            que.offer(i);
        }

        while (que.size() > 1) {                    //큐의 크기가 1보다 크면 반복
            for (int i = 0; i < k - 1; i++) {       //큐에서 K - 1개만큼을 poll한 후, 다시 offer
                que.offer(que.poll());
            }
            que.poll();                             //그리고 K번째 원소(K번째 왕자) 제거

        }                                           //큐의 크기가 1이면 반복문 중단
        answer = que.poll();                        //큐에 남아있는 원소 answer에 대입

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Stack_Queue06 s = new Stack_Queue06();
        System.out.println(s.solution(N, K));
    }
}
