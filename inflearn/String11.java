package inflearn.string;

import java.util.Scanner;

/*
대문자 문자열에서 같은 문자가 연속될 경우 횟수를 표기하여 출력

입력 예시
KKHSSSSSSSE

출력 예시
K2HS7E
 */
public class String11 {
    public String solution(String str) {
        String answer = "";
        str = str + 'a'; //여기서는 대문자의 문자열이기 때문에 소문자 임의의 문자 추가
        char[] tmp = str.toCharArray(); //문자 배열로 바꿔주어 비교
        int num = 1; //연속된 문자의 개수 표현할 변수 선언, 문자는 항상 1개 이상이기 때문에 1로 초기화

        for (int i = 0; i < str.length() - 1; i++) { //임의의 문자가 추가됐기 때문에 반복 횟수를 -1 해줌
            if (tmp[i] == tmp[i + 1]) { //i번째와 i+1번째를 비교해서 같으면 num++
                num++;
            } else {
                answer += tmp[i]; //틀리면 i번째 문자를 answer에 추가

                if (num > 1) { //반복 횟수가 1보다 크다면 answer에 추가
                    answer += num;

                    num = 1; //반복 횟수 초기화
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String11 s = new String11();
        System.out.println(s.solution(str));
    }
}
