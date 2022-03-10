package inflearn.string;

import java.util.*;


//1은 #, 0은 *로 표현된 7자의 2진수 암호를 알파벳 대문자로 해석해서 출력
//입력 첫 줄은 문자의 개수(10보다 적음), 다음 줄에는 암호가 입력
public class String12 {
    public String solution(int n, String str) {
        String answer = "";
        str = str.replace('#', '1').replace('*', '0');
        //'#'과 '*'을 '1'과 '0'으로 변환(문자형)

        for (int i = 0; i < n; i++) { //입력된 정수만큼 반복
            String tmp = str.substring(0, 7); //7자만 분리
            int num = 0; //분리한 2진수를 10진수로 받을 변수 생성

            num = Integer.parseInt(tmp, 2); //2진수 tmp를 10진수로 변환

            answer += (char) num; //10진수 num을 문자로 변환 후, 문자열에 추가

            str = str.substring(7); //입력받은 문자열 중 앞 7자를 제외한 나머지를 다시 str에 넣어줌

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //첫 줄은 정수
        String str = scanner.next(); //다음 줄은 문자열

        String12 m = new String12();

        System.out.print(m.solution(n, str));

    }
}