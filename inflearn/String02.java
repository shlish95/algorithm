package inflearn;

import java.util.Scanner;


//문자열을 입력받아 대문자는 소문나로, 소문자는 대문자로 변환하여 출력
public class String02 {
    public String solution(String str) {
        String answer = "";

        for (char x : str.toCharArray()) { //향상된 for문에 문자열을 문자 배열로 넣음
            if (Character.isUpperCase(x)) { //대문자일 경우 소문자로 바꿔 줌
                answer += Character.toLowerCase(x);
            } else if (Character.isLowerCase(x)) { //소문자일 경우 대문자로 바꿔 줌
                answer += Character.toUpperCase(x);
            } //대소문자 구분할 때, 메서드 대신 아스키코드 값으로 구분할 수 있음
        }     //아스키코드 대문자(65 ~ 90), 소문자(97 ~ 122)
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String02 s = new String02();

        System.out.println(s.solution(str));
    }
}
