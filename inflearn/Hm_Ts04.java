package inflearn.hm_ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
S문자열에서 T문자열과 아나그램이 되는 부분문자열의 개수를 구하여 출력
첫 줄에는 S문자열이, 두 번째 줄에는 T문자열이 입력

입력 예시
bacaAacba
abc

출력 예시
3
 */
public class Hm_Ts04 {
    private int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> Hs = new HashMap<>();       //S문자열을 대입할 해시맵 생성
        HashMap<Character, Integer> Ht = new HashMap<>();       //T문자열을 대입할 해시맵 생성
        int lt = 0;                                             //왼쪽 포인터 변수 선언 및 초기화

        for (char x : t.toCharArray()) {                        //T문자열을 받아 Hs에 대입
            Ht.put(x, Ht.getOrDefault(x, 0) + 1);
        }

        int l = t.length() - 1;                                 //T문자열 크기의 변수 생성
        for (int i = 0; i < l; i++) {                           //T문자열보다 한 칸 작은 sliding window 생성
            Hs.put(s.charAt(i), Hs.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = l; rt < s.length(); rt++) {               //sliding window에 오른쪽 포인터에 해당하는 알파벳 넣고 비교
            Hs.put(s.charAt(rt), Hs.getOrDefault(s.charAt(rt), 0) + 1);

            if (Hs.equals(Ht)) {                                //Hs와 Ht가 같다면 answer 증가
                answer++;
            }

            Hs.put(s.charAt(lt), Hs.get(s.charAt(lt)) - 1);     //sliding window를 옮기기 위해 왼쪽 포인터 해당 알파벳 제거
            if (Hs.get(s.charAt(lt)) == 0) {                    //제거된 알파벳의 남은 개수가 0이라면 키도 제거
                Hs.remove(s.charAt(lt));
            }

            lt++;                                               //왼쪽 포인터 증가
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();               //S문자열
        String T = sc.nextLine();               //T문자열

        Hm_Ts04 h = new Hm_Ts04();
        System.out.println(h.solution(S, T));
    }
}
