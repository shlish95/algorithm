package inflearn;

import java.util.Scanner;

/*
앞에서 읽을 때나 뒤에서 읽을 때 같은 문자열을 펠린드롬이라고 함
입력된 문자열이 팰린드롬이면 "YES", 아니면 "NO"출력
단 알파벳 이외 문자는 무시하고, 대소문자 구분하지 않음

입력 예시
found7, time: study; Yduts; emit, 7Dnuof

출력 예시
YES
 */
public class String08 {
    public String solution(String str) {
        String answer = "NO";

        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        //replaceAll메서드에 정규식 사용해서 대문자 알파벳 이외의 문자는 공백으로 바꿔줌

        String tmp = new StringBuilder(str).reverse().toString(); //str문자열을 뒤집은 문자열을 생성

        if (str.equals(tmp)) { //두 문자열이 같다면 "YES" 출력
            answer = "YES";
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String08 s = new String08();

        System.out.println(s.solution(str));
    }
}
