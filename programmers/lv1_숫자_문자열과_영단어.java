package programmers.lv1;

import java.util.HashMap;

/* 숫자 문자열과 영단어
숫자와 숫자 영단어로 이루어진 문자열을 보고 정수형으로 반환하여라

입출력 예시
s	                    result
"one4seveneight"	    1478
"23four5six7"	        234567
"2three45sixseven"	    234567
"123"	                123
*/
public class lv1_숫자_문자열과_영단어 {
    public static void main(String[] args) {
            String s = "one4seveneight";
            int answer = 0;
            HashMap<String, Integer> map = new HashMap<>(); //숫자 영단어와 해당 숫자를 키, 밸류로 담을 해쉬맵
            map.put("zer", 0);      //영단어를 판단하는 최소 글자 수가 3개이기 때문에
            map.put("one", 1);      //3단어씩만 넣는다
            map.put("two", 2);
            map.put("thr", 3);
            map.put("fou", 4);
            map.put("fiv", 5);
            map.put("six", 6);
            map.put("sev", 7);
            map.put("eig", 8);
            map.put("nin", 9);

            for(int i = 0; i < s.length() - 2; i++) {   //주어진 문자열의 길이 -2 만큼 반복
                                                        //map의 키값(3글자)을 통해 영단어를 판단하므로 길이 -2
                if(Character.isDigit(s.charAt(i))) {    //i번째 문자가 숫자라면 answer에
                    answer *= 10;                       //answer에 10을 곱해준 후 더해줌
                    answer += s.charAt(i) - '0';        //아스키 값이 들어가지 않게 하기 위해 0의 아스키 값을 빼줌

                } else {                                //i번째 문자가 숫자가 아니라면
                    String tmp = String.valueOf(s.charAt(i)) + s.charAt(i + 1) + s.charAt(i + 2);
                                                        //i번부터 i+2번까지 3글자를 변수 tmp에 넣어주고
                    if(map.containsKey(tmp)) {          //map에서 찾아 해당하는 밸류를
                        answer *= 10;                   //answer에 10을 곱한 후 더해줌
                        answer += map.get(tmp);
                    }
                }
            }

            for(int i = s.length() - 2; i < s.length(); i++) {  //문자열에서 마지막 2글자만 따로 반복
                if(Character.isDigit(s.charAt(i))) {            //i번째 문자가 숫자라면
                    answer *= 10;                               //answer에 10을 곱해준 후 더해줌
                    answer += s.charAt(i) - '0';                //0의 아스키 값을 빼주고 더해야 함
                }
            }
            System.out.println(answer);                         //answer 출력
    }
}
