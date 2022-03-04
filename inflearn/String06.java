package inflearn;

import java.util.Scanner;

/*
입력된 문자열에서 중복된 문자를 제거

입력 예시
ksekkset

출력 예시
kset
 */
public class String06 {
    public String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            int num = str.indexOf(str.charAt(i)); //i번째 문자와 같은 문자의 위치를 확인
            //charAt메서드는 문자열 중 주어진 문자의 가장 먼저 오는 단어의 인덱스 번호를 출력
            //그렇기 때문에 i값과 num의 값이 다르다는 것은 중복된 문자라는 의미
            if (num == i) { //i번째 문자와 num이 같다면 answer에 문자 추가
                answer += str.charAt(i);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String06 s = new String06();
        System.out.println(s.solution(str));
    }
}
