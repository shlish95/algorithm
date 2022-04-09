package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 7. 교육과정 설계
A, B, C, D, E, F, G 과목 중 필수 과목을 순차적으로 이수하는 계획이 맞는지 확인하는 프로그램 작성
계획이 잘 짜여지면 "YES", 잘못되어 있으면 "NO" 출력

첫 줄에는 필수과목 순서가, 두 번째 줄에는 수업 설계가 입력

입력 예시
CBA
CBDAGE

출력 예시
YES
*/
public class Stack_Queue07 {
    private String solution(String n, String c) {
        String answer = "YES";
        Queue<Character> que = new LinkedList<>();

        /* 방법1_수업 설계를 큐에 입력
        for (char x : c.toCharArray()) {    //큐에 수업 설계 과목 입력
            que.offer(x);
        }

        for (char x : n.toCharArray()) {    //반복문을 통해 필수 과목 문자 하나씩 비교
            if (que.contains(x)) {          //contains() 메서드를 통해 큐에 필수 과목의 존재 여부 확인
                while (que.poll() != x) {   //존재하지 않으면 다음 문자와 비교, 존재한다면 반복문 실행
                                            //poll()메서드를 통해 하나씩 꺼내며 필수 과목과 같을 때까지 반복

                    if (que.size() < 1) {   //큐의 크기가 1보다 작아지면 필수 과목이 전부 존재하는 것이 아니기 때문에
                        return "NO";        //"NO" 반환
                    }
                }
            } else {                        //큐에 필수 과목 문자가 없다면 "NO" 반환
                return "NO";
            }
        }
        */

        //방법2_필수 과목을 큐에 입력_강의 설명
        for (char x : n.toCharArray()) {    //큐에 필수 과목 입력
            que.offer(x);
        }

        for (char x : c.toCharArray()) {    //반복문을 통해 설계 과목 문자 하나씩 비교
            if (que.contains(x)) {          //contains() 메서드를 통해 큐에 설계 과목의 존재 여부 확인
                if (que.poll() != x) {      //존재하지 않는 다면 다음 문자와 비교,
                    return "NO";            //존재한다면 poll() 메서드를 통해 큐에서 꺼내어 비교
                }                           //같지 않다면 "NO" 반환
            }
        }
        if (!que.isEmpty()) {               //설계 과목과 poll() 메서드를 통해 비교했는데
            return "NO";                    //큐가 비어있지 않다면 계획이 잘못된 것이므로 "NO" 반환
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        String C = sc.nextLine();

        Stack_Queue07 s = new Stack_Queue07();
        System.out.println(s.solution(N, C));
    }
}
