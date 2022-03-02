package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/*
첫 줄에 정수(단어의 개수)를 주고 두 번째 줄부터 각 줄에 단어가 하나씩 주어지면 단어를 뒤집어 출력

입력 예시
3
good
Time
Big

출력 예시
doog
emiT
giB
 */
public class String04 {
    public ArrayList<String> solution(int num, String[] str) { //배열 크기가 자유로운 ArrayList로 반환
        ArrayList<String> answer = new ArrayList<>();

        /* 방법1 - 직접 바꿔주기
        for (String x : str) {
            char[] ch = x.toCharArray();
            int lt = 0, rt = x.length() - 1;

            while (lt != ch.length / 2) { //while문 조건에 (lt > rt)도 가능
                char tmp = ch[lt]; //양쪽 끝 문자 위치 바꿔 줌
                ch[lt] = ch[rt];
                ch[rt] = tmp;

                lt++;
                rt--;
            }
            String tmp = String.valueOf(ch); //문자 배열을 문자열로 바꿔 줌
            answer.add(tmp); //ArrayList에 추가할 때는 add메서드 사용
        }
         */

        //방법2 - StringBuilder클래스의 reverse메서드
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString(); //StringBuilder클래스로 타입을 변경해준 후,
                                                                    //reverse메서드를 사용해 문자열 순서를 뒤집음
            answer.add(tmp);                                        //그 후 다시 문자열로 타입 변경 후 add메서드로 추가
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] str = new String[num];

        for (int i = 0; i < num; i++) {
            str[i] = scanner.next(); //nextLine으로 받으면 엔터친 곳까지만 받으므로 두 줄만 받음
        }

        String04 s = new String04();

        for (String x : s.solution(num, str)) {
            System.out.println(x); //배열 출력은 반복문을 통해 한다.
        }
    }
}
