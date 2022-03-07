package inflearn.string;

import java.util.Scanner;

/*
문자와 숫자가 섞여있는 문자열 중 숫자만 자연수 형태로 출력

입력 예시
g0en2T0s8eSoft

출력 예시
208
 */
public class String09 {
    public int solution(String str) {
        int answer = 0;

        /* 방법1_isAlphabetic메서드 or isDigit메서드 사용 (둘다 Character클래스의 메서드)
        String tmp = "";

        for (char x : str.toCharArray()) {
            if (!(Character.isAlphabetic(x))) { //if절 조건이 (Character.isDigit(x))도 가능
                tmp += x; //문자열에 정수 추가
            }
        }
        answer = Integer.parseInt(tmp); //문자열 상태의 숫자를 정수로 바꿔 줌 -> 문자열 맨 앞이 0이라면 사라지게 됨
        */

        //방법2_아스키 코드 이용
        for (char x : str.toCharArray()) {
            if (x >= '0' && x <= '9') { //문자의 아스키 값을 0~9사이의 아스키 값과 비교('0'과 '9'의 아스키 값인 48과 59도 가능)
                answer = answer * 10 + (x - '0'); //0~9사이의 아스키 값이라면 answer에 추가
                //(x - '0')을 하는 이유는 문자인 x를 정수로 표현하기 위해서
                //answer * 10을 하는 이유는 문자 배열 중 앞 문자는 정수에서 10을 곱해준 것과 같기 때문
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String09 s = new String09();
        System.out.println(s.solution(str));
    }
}
