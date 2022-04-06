package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/* 4. 후위식 연산(postfix)
후위연산식을 연산하여 출력

입력 예시
352+*9-

출력 예시
12
 */
public class Stack_Queue04 {
    private int solution(String str) {
        int answer = 0;
        Stack<Integer> sta = new Stack<>();
        int tmp = 0;                            //연산식을 결과를 임시로 대입할 변수 생성 및 초기화

        for (char x : str.toCharArray()) {      //문자열로 받은 후위연산식을 문자 배열로 하나씩 반복
            if (x >= '1' && x <= '9') {         //if문을 통해 x가 숫자인지 판단 -> Character.isDigit(x)도 가능
                sta.push(x - 48);          //문자를 숫자로 바꾸기 위해 '0'의 아스키코드 값 빼줌, '0'을 빼도 됨

            } else {                            //x가 숫자가 아니라면
                int post = sta.pop();           //스택 가장 위에 숫자를 post에 대입
                int pre = sta.pop();            //그 다음 숫자를 pre에 대입

                switch (x) {                    //스위치문을 통해 연산자에 따라 계산하고 결과를 tmp에 대입
                    case '+':
                        tmp = pre + post;
                        break;
                    case '-':
                        tmp = pre - post;
                        break;
                    case '*':
                        tmp = pre * post;
                        break;
                    case '/':
                        tmp = pre / post;
                        break;
                }
                sta.push(tmp);                  //계산 결과인 tmp를 스택에 push
            }
        }
        answer = sta.pop();                     //반복문이 완료되면 스택에 계산 결과값만 남으므로
                                                //pop하여 answer에 저장 -> sta.get(0)도 가능
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack_Queue04 s = new Stack_Queue04();
        System.out.println(s.solution(str));
    }
}
