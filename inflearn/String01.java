package inflearn;

import java.util.*;

//입력된 문자열 중 입력된 문자의 개수 출력 (대소문자 구분 X, 문자열 길이는 100 넘지 않음)
public class String01 {
    public int solution(String str, char ch) {
        int answer = 0;

        str = str.toUpperCase(); //대소문자를 구분하지 않기 때문에 대문자로 맞춰줌
        ch = Character.toUpperCase(ch); //문자의 경우 Chracter클래스의 toUpperCase메소드를 사용

        for (char x : str.toCharArray()) { //문자열을 문자 배열로 바꿔주고 향상된 for문에 넣어 줌
            if (x == ch) { //입력된 문자와 같을 경우 answer 1씩 증가
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); //첫 줄은 문자열이기 때문에 문자열 타입으로 받고, 두번째 줄로 넘기기 위해 nextLine메서드 사용
        char ch = scanner.nextLine().charAt(0); //문자의 경우 문자열로 받고, 0번째 인덱스를 추출

        String01 c = new String01();

        System.out.println(c.solution(str, ch));
    }
}
