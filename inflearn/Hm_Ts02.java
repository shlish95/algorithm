package inflearn.hm_ts;

import java.util.HashMap;
import java.util.Scanner;

/*
Anagram이란 두 알파벳 문자열의 나열 순서는 다르지만 구성이 일치하는 두 단어를 의미
입력된 두 문자열이 아나그램인지 판별

입력 예시
AbaAeCe
baeeACA

출력 예시
YES
 */
public class Hm_Ts02 {
    public String solution(String a, String b) {
        String answer = "YES";

        /*방법1_각각의 해시맵 비교
        HashMap<Character, Integer> Ha = new HashMap<>();   //A해시맵 생성
        HashMap<Character, Integer> Hb = new HashMap<>();   //B해시맵 생성

        for (char x : a.toCharArray()) {                    //A해시맵 문자열 대입
            Ha.put(x, Ha.getOrDefault(x, 0) + 1);
        }
        for (char x : b.toCharArray()) {                    //B해시맵 문자열 대입
            Hb.put(x, Hb.getOrDefault(x, 0) + 1);
        }

        for (char x : Ha.keySet()) {                        //반복문을 통해 각 해시맵 비교
            if (Ha.get(x) != Hb.get(x)) {                   //하나라도 다르다면 NO 출력 후 break
                answer = "NO";
                break;
            }
        }
        */

        //방법2_해시맵 생성 후, 비교해서 차감하기
        HashMap<Character, Integer> map = new HashMap<>();      //해시맵 생성

        for (char x : a.toCharArray()) {                        //해시맵에 A 문자열의 각 알파벳 개수를 밸류에 대입
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : b.toCharArray()) {                        //해시맵과 B 문자열 비교
            if (!map.containsKey(x) || map.get(x) == 0) {       //해시맵과 비교후 없는 알파벳(키)이 있던가
                return "NO";                                    //알파벳의 개수(밸류)가 없다면 "NO" 리턴
            }

            map.put(x, map.get(x) - 1);                         //비교 후 공통된 알파벳이 있다면 밸류 감소
        }                                                       //감소되기 때문에 서로 다르다면 if문의 조건이 위배되므로 "NO"리턴

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        Hm_Ts02 h = new Hm_Ts02();
        System.out.println(h.solution(A, B));
    }
}
