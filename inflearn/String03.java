package inflearn;

import java.util.Scanner;
/*
문자열에서 가장 긴 단어 출력
각 단어는 공백으로 구분, 글자 수가 같을 경우 앞 단어 출력

입력 예시
it is time to study

출력 예시
study
 */
public class String03 {
    public String solution(String str) {
        String answer = "";

      /* 방법1 - split 메서드 사용
        String[] tmp = str.split(" "); //" "을 기준으로 나누어 배열로 만들어 줌

        for (String x : tmp) { //반복문을 통해 문자열의 길이 비교
            if (answer.length() < x.length()) {
                answer = x;
            }
        }
        */

       //방법2 - indexOf(), substring() 메서드 사용
        int num;

        while ((num = str.indexOf(" ")) != -1) { //indexOf에 주어진 문자를 못 찾을 경우 -1 반환
            String tmp = str.substring(0, num); //문자열 첫 단어 추출

            if (tmp.length() > answer.length()) { //단어가 더 길다면 answer에 대입
                answer = tmp;
            }

            str = str.substring(num + 1); //기존 문자열에서 추출한 단어를 제외
        }

        if (str.length() > answer.length()) { //while문에서 마지막 단어는 비교가 안됐으므로
            answer = str;                     //따로 비교해줌
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String03 s = new String03();

        System.out.println(s.solution(str));
    }
}
