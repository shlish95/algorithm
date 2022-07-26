package programmers.lv1;

import java.util.HashMap;

/* 숫자 문자열과 영단어

*/
public class lv1_숫자_문자열과_영단어 {
    public static void main(String[] args) {
            String s = "one4seveneight";
            int answer = 0;
            HashMap<String, Integer> map = new HashMap<>();
            map.put("zer", 0);
            map.put("one", 1);
            map.put("two", 2);
            map.put("thr", 3);
            map.put("fou", 4);
            map.put("fiv", 5);
            map.put("six", 6);
            map.put("sev", 7);
            map.put("eig", 8);
            map.put("nin", 9);

            for(int i = 0; i < s.length() - 2; i++) {
                if(Character.isDigit(s.charAt(i))) {
                    answer *= 10;
                    answer += s.charAt(i) - '0';

                } else {
                    String tmp = String.valueOf(s.charAt(i)) + s.charAt(i + 1) + s.charAt(i + 2);

                    if(map.containsKey(tmp)) {
                        answer *= 10;
                        answer += map.get(tmp);

                    }
                }
            }

            for(int i = s.length() - 2; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))) {
                    answer *= 10;
                    answer += s.charAt(i) - '0';
                }
            }
            System.out.println(answer);
    }
}
