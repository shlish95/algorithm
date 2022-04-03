package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/*
입력된 괄호 쌍이 올바르면 "YES", 올바르지 않으면 "NO" 출력

입력 예시
(()(()))(()

출력 예시
NO
 */
public class Stack_Queue01 {
    private String solution(String str) {
        String answer = "YES";
        Stack<Character> st = new Stack<>();    //stack 선언

        for (char x : str.toCharArray()) {      //문자열을 문자 배열로 변환하여 반복
            if (x == '(') {                     //문자가 '('라면 stack에 넣어줌
                st.push(x);
            } else {                            //아니라면
                if (!st.isEmpty()) {            //stack이 비어있지 않다면
                    st.pop();                   //'('을 꺼내줌
                } else {                        //비어 있다면 괄호 쌍이 안맞는 것 이므로
                    return "NO";                //"NO" 반환
                }
            }
        }
        if (!st.isEmpty()) {                    //반복문 종료 후에 stack이 비어있지 않다면 괄호 쌍이 안맞는 것이므로
            return "NO";                        //"NO" 반환
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack_Queue01 s = new Stack_Queue01();
        System.out.println(s.solution(str));
    }
}
