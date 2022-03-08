package inflearn.string;

import java.util.Scanner;

/*
문자열str과 문자ch가 주어지면, 문자열의 각 문자와 ch와의 떨어진 최소거리를 출력

입력 예시
teachermode e

출력 예시
1 0 1 2 1 0 1 2 2 1 0
 */
public class String10 {
    public int[] solution(String str, char ch) { //숫자 배열로 리턴
        int[] answer = new int[str.length()]; //문자열 길이만큼의 배열 생성
        char[] tmp = str.toCharArray(); //문자열을 문자 배열로 바꿔주기
        int num = 99; //문자와의 거리를 나타낼 정수 변수 생성, 임의의 큰 숫자로 초기화

        for (int i = 0; i < str.length(); i++) { //문자 배열을 0번부터 순차적으로 비교
            if (tmp[i] == ch) { //i번째 문자와 ch와 같다면 0, 아니라면 1씩 증가 후 answer에 넣어줌
                num = 0;
            } else {
                num += 1;
            }
            answer[i] = num;
        }

        num = 99; //임의의 큰 숫자로 초기화
        for (int i = str.length() - 1; i >= 0; i--) { //문자 배열 맨 뒤부터 역순으로 비교
            if (tmp[i] == ch) { //i번째 문자와 ch와 같다면 0, 아니라면 1씩 증가 후 answer에 넣어줌
                num = 0;
            } else {
                num += 1;

                //순차적으로 비교한 값과 역순으로 비교한 값 중 작은 값을 answer에 넣어줌
                if (answer[i] > num) { //조건절 대신 answer[i] = Math.min(answer[i], num)도 가능
                    answer[i] = num;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next(); //첫 문자열을 가지고 오기위해 nextLine이 아닌 next메서드 사용
        char ch = scanner.next().charAt(0); //next메서드는 문자열을 가져오기 때문에 문자 하나를 가져오기 위해선 chatAt메서드 사용

        String10 s = new String10();
        for (int x : s.solution(str, ch)) { //배열을 출력하기 위해 for문 사용
            System.out.print(x + " ");
        }

    }
}
