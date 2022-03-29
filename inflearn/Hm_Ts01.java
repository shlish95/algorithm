package inflearn.hm_ts;

import java.util.HashMap;
import java.util.Scanner;

/*
A, B, C, D, E 중 가장 많이 입력된 알파벳의 횟수를 출력
첫 줄에는 알파벳의 수 N이, 두 번째 줄에는 알파벳 문자열이 입력

입력 예시
15
BACBACCACCBDEDE

출력 예시
C
 */
public class Hm_Ts01 {
    public char solution(int n, String stu) {
        char answer = ' ';
        int max = Integer.MIN_VALUE;            //가장 많이 입력된 횟수를 대입할 변수 선언 및 초기화
        HashMap<Character, Integer> map = new HashMap<>();
        //문자형 키, 정수형 밸류를 갖는 HashMap map 생성

        for (char x : stu.toCharArray()) {      //입력받은 문자열을 map에 대입
            map.put(x, map.getOrDefault(x, 0) + 1); //put 메서드를 통해 키와 밸류를 입력
        }   // getOrDefault 메서드는 주어진 키에 대한 밸류를 출력하는데, 밸류가 없다면 주어진 기본값(Default) 출력
            //x가 반복될 때 각 알파벳의 개수를 구하기 위해 밸류에 +1을 해줌

        for (char x : map.keySet()) {           //keySet 메서드를 통해 map을 탐색
            if (max < map.get(x)) {             //x에 해당하는 밸류가 max보다 크다면
                max = map.get(x);               //max에 대입 후, x값을 answer에 대입
                answer = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String stu = sc.next();

        Hm_Ts01 h = new Hm_Ts01();
        System.out.println(h.solution(N, stu));
    }
}
