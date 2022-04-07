package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/* 5. 쇠막대기
여러 개의 쇠막대기를 레이저로 절단하려 한다.
쇠막대기를 아래 위로 겹쳐놓고 레이저를 수직으로 발사해 자를 때 막대 조각의 개수를 출력하여라

이때 쇠막대기는 자신보다 긴 막대 위에만 놓일 수 있고, 위에 놓인 경우 긴 막대에 완전히 포함되도록 놓아야 한다.
각 쇠막대기를 자르는 레이저는 적어도 하나 존재하고, 쇠막대기의 양 끝과 겹치지 않는다.

레이저는 인접된 괄호의 쌍 '()'으로 표현되며, 쇠막대기의 끝은 여는 괄호 '('와 닫힌 괄호 ')'로 표현된다.

입력 예시
()(((()())(())()))(())

출력 예시
17
 */
public class Stack_Queue05 {
    private int solution(String str) {
        int answer = 0;
        Stack<Character> sta = new Stack<>();       //괄호를 넣을 스택 생성

        for (int i = 0; i < str.length(); i++) {    //문자열에 있는 괄호들을 하나씩 확인
            if (str.charAt(i) == '(') {             //열린 괄호 '(' 라면
                sta.push(str.charAt(i));            //스택에 넣어줌

            } else {                                //닫힌 괄호 ')' 라면
                if (str.charAt(i - 1) == '(') {     //이전 괄호(i - 1) 확인하고, 이전 괄호가 열린 괄호라면
                    sta.pop();                      //괄호 쌍이되어 레이저를 나타내므로
                    answer += sta.size();           //pop 후 열린 괄호의 개수(.size())만큼 answer 증가

                } else {                            //이전 괄호가 닫힌 괄호라면
                    sta.pop();                      //가장 상단에 있는 가장 짧은 쇠막대기의 끝이므로
                    answer++;                       //스택에서 괄호 하나를 제거(.pop())한 후 answer 1 증가
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack_Queue05 s = new Stack_Queue05();
        System.out.println(s.solution(str));
    }
}
