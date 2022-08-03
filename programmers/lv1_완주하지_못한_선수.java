package programmers.lv1;

import java.util.*;
/* 완주하지 못한 선수

 */
public class lv1_완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        for(String str : map.keySet()) {
            if(map.get(str) != 0) {
                answer = str;
            }
        }

        System.out.println(answer);
    }
}
