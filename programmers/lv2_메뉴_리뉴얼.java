package programmers.kakao_blind_recruitment2021;

import java.util.*;

/* 메뉴 리뉴얼
각 손님이 가장 많이 주문한 단품 메뉴를 코스요리 메뉴로 구성하여라
알파벳은 메뉴를 의미하며 각 손님이 주문한 음식은 배열 orders에 담겨있다.
코스요리의 가지 수의 종류는 배열 course에 담겨있고 2가지 이상만 출력한다.

입출력 예시
orders	                    course	    result
["ABCFG", "AC", "CDE",      [2,3,4]     ["AC", "ACDE",
"ACDE", "BCFG", "ACDEH"]		         "BCFG", "CDE"]

["ABCDE", "AB", "CD",       [2,3,5]     ["ACD", "AD",
"ADE", "XYZ", "XYZ",                    "ADE", "CD",
"ACD"]		                            "XYZ"]

["XYZ", "XWY", "WXA"]	    [2,3,4]	    ["WX", "XY"]


 */
public class lv2_메뉴_리뉴얼 {
    static HashMap<String, Integer> map;
    static HashMap<Integer, Integer> max;

    public static void DBS(String str, int len, int L, String mix) {
        if (mix.length() == len) {      //조합된 메뉴의 길이가 코스요리 메뉴 수와 같다면
            map.put(mix, map.getOrDefault(mix, 0) + 1);
            //map에 조합된 메뉴와 주문된 횟수를 키, 밸류로 입력

            max.put(len, Math.max(max.get(len), map.get(mix)));
            //같은 코스요리 메뉴 수 중에서 가장 주문이 많이 된 횟수를 max의 밸류로 대입

            return;

        } else {                        //조합된 메뉴의 길이가 코스요리 메뉴 수와 다르다면
            if (L < str.length()) {     //DBS 메서드의 반복 횟수가 주문한 메뉴보다 적다면
                DBS(str, len, L + 1, mix);       //현재 조합 그대로, L번째 메뉴를 조합하여
                                                    //각각 재귀호출
                mix += String.valueOf(str.charAt(L));
                DBS(str, len, L + 1, mix);
            }
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        ArrayList<String> answer = new ArrayList<>();
        map = new HashMap<>();          //코스요리 메뉴 모든 경우의 수를 담을 해쉬맵 map
        max = new HashMap<>();          //가능한 코스요리 메뉴 중 가장 많이 주문 된 횟수를 담을 해쉬맵 max

        for (int i = 0; i < course.length; i++) {   //max에 코스요리 가지 수를 키로 밸류는 0으로 담아 줌
            max.put(course[i], 0);
        }

        for (int i = 0; i < orders.length; i++) {   //주문된 메뉴들을 모두 오름차순으로 정렬
            char[] arr = orders[i].toCharArray();   //문자열인 주문을 문자 배열로 바꿔 배열 arr에 대입

            Arrays.sort(arr);                       //배열 arr을 오름차순으로 정렬

            orders[i] = String.valueOf(arr);        //정렬된 arr을 문자열로 바꿔 다시 orders에 대입
        }

        for (int i = 0; i < course.length; i++) {       //코스요리 가지 수의 종류 별 반복
            for (int j = 0; j < orders.length; j++) {   //손님 별 주문한 메뉴들 반복
                DBS(orders[j], course[i], 0, "");
            }  //손님이 주문한 메뉴들, 코스요리 가지 수, 반복 횟수(깊이), 조합된 문자열을 매개변수로 DBS 메서드 실행
        }

        //손님이 주문한 메뉴들을 가지고 만들 수 있는 모든 코스요리 메뉴 조합을 다 만든 상태
        //여기서 각 코스요리 가지 수 중 손님이 주문을 많이 한, 조합이 1가지 이상의 코스요리 메뉴를 answer에 추가
        for (int cnt : max.keySet()) {
            for (String str : map.keySet()) {
                if (max.get(cnt) == map.get(str) && str.length() == cnt && max.get(cnt) > 1) {
                    answer.add(str);
                }
            }
        }

        Collections.sort(answer);       //answer를 오름차순으로 정렬

        for (String s : answer) {       //answer 출력
            System.out.print(s + " ");
        }
    }
}
