package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/*
입력된 문자열에서 괄호 사이에 존재하는 문자를 제거하고 남은 문자만 출력

입력 예시
(A(BC)D)EF(G(H)(IJ)K)LM(N)

출력 예시
EFLM
 */
public class Stack_Queue02 {
    private String solution(String str) {
        String answer = "";
        Stack<Character> st = new Stack<>();
        /*방법1_괄호일 경우 push, pop 해주고 알바벳일 경우 스택이 비엇는지 확인 후 문자열에 추가
        for (char x : str.toCharArray()) {
            if (x == '(') {
                st.push(x);
            } else if (x == ')') {
                st.pop();
            } else {
                if (st.isEmpty()) {
                    answer += x;
                }
            }
        }*/

        //방법2_')'가 입력되면 '('까지 pop하고 남은 알파벳 answer에 추가
        for (char x : str.toCharArray()) {
            if (x != ')') {
                st.push(x);
            } else {
                while (st.pop() != '(') {
                }
            }
        }
        for (int i = 0; i < st.size(); i++) {
            answer += st.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack_Queue02 s = new Stack_Queue02();
        System.out.println(s.solution(str));
    }
}
