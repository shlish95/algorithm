package programmers.lv2;

import java.util.HashMap;
/* 전화번호 목록
전화번호가 담긴 배열 phone_book에서 어떤 번호가 다른 번호의 접두어인 경우 false, 그렇지 않으면 true를 출력하여라
전화번호는 중복해서 들어있지 않음

입출력 예시
phone_book	                        return
["119", "97674223", "1195524421"]	false
["123","456","789"]	                true
["12","123","1235","567","88"]	    false
 */
public class lv2_전화번호_목록 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "114", "112", "123223123", "1231231234"};
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {   //해쉬맵에 전화번호를 넣어줌
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {           //반복문을 통해 각 번호의 j길이 만큼의 번호가
            for (int j = 0; j < phone_book[i].length(); j++) {  //존재하는지 확인
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;                             //존재한다면 answer에 false 대입
                }
            }
        }

        System.out.println(answer);
    }
}
