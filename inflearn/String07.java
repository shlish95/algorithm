package inflearn;

import java.util.Scanner;

/*
앞에서 읽거나 뒤에서 부터 읽을 때 같은 문자열을 회문 문자열이라고 함
입력된 문자열이 회문 문자열일 경우 "YES", 아닐 경우 "NO" 출력(대소문자 구분 안함)

입력 예시
gooG

출력 예시
YES
 */
public class String07 {
    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase(); //대소문자 구분하지 않도록 하나로 맞춰줌

        /* 방법1 - StringBuilder 클래스의 reverse메서드 사용
        String tmp = new StringBuilder(str).reverse().toString();
        //StringBuilder 클래스의 reverse메서드 사용하여
        //원래 문자열과 뒤집은 문자열이 같은지 확인

        if (!str.equals(tmp)) { //equalsIgnoreCase메서드를 사용하면 str의 대소문자를 맞춰줄 필요가 없음
            answer = "NO"; //같다면 "YES" 출력
        }
        */

        //방법2 - 맨 앞 문자와 맨 뒤 문자부터 차례로 비교
        for (int i = 0; i < str.length() / 2; i++) { //맨 앞 문자와 맨 뒤 문자부터 두 문자씩 비교하므로
                                                     // 문자열 길이의 절반의 횟수만 비교
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) { //i번째 문자와 맨 뒤에서 i번째 문자를 비교
                answer = "NO"; //틀리다면 "NO"출력
                //주의!! answer의 기본값을 "YES"로 해놓고 앞, 뒤 문자를 비교 후 하나라도 틀리면 "NO"를 출력해야함
            }   //기본값 "NO"로 해놓으면 문자를 비교한 뒤 하나라도 같으면 "YES"가 출력 됨
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String07 s = new String07();
        System.out.println(s.solution(str));

    }
}
