package programmers.lv2;

import java.util.HashMap;

/* 오픈채팅방
오픈채팅방에 누군가 들어오거나 나가면 "[닉네임]님이 들어왔습니다.", "[닉네임]님이 나갔습니다."라고 출력하는 프로그램 작성하여라

배열 record는 채팅방에 들어오거나 나가고, 닉네임을 변경한 기록이고 닉네임이 변경되면 전의 기록들도 바뀐 닉네임으로 출력

입출력 예
record	                    result
["Enter uid1234 Muzi",      ["Prodo님이 들어왔습니다.",
"Enter uid4567 Prodo",      "Ryan님이 들어왔습니다.",
"Leave uid1234",            "Prodo님이 나갔습니다.",
"Enter uid1234 Prodo",      "Prodo님이 들어왔습니다."]
"Change uid4567 Ryan"]
 */
public class lv2_오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                            "Leave uid1234", "Enter uid1234 Prodo",
                            "Change uid4567 Ryan"};
        int cnt = 0, cntC = 0;                          //record 배열 중 Change 개수를 세어줄 배열 cnt, cntC
        String[] answer;                                //정답을 출력할 배열 answer
        HashMap<String, String> name = new HashMap<>(); //아이디와 닉네임을 키와 밸류로 저장할 해쉬맵 name

        for(int i = 0; i < record.length; i++) {        //record 길이만큼 반복
            if(record[i].charAt(0) == 'E') {            //원소의 첫 글자가 'E'라면
                name.put(record[i].substring(6, record[i].indexOf(" ", 6)),
                        record[i].substring(record[i].indexOf(" ", 7) + 1));
                //namd에 아이디와 닉네임을 키와 밸류로 넣어줌


            } else if(record[i].charAt(0) == 'C') {     //원소의 첫 글자가 'C'라면
                name.put(record[i].substring(7, record[i].indexOf(" ", 7)),
                        record[i].substring(record[i].indexOf(" ", 8) + 1));
                //name에 아이디와 닉네임을 키와 밸류로 넣어줌

                cnt++;                                  //cnt 증가
            }
        }


        answer = new String[record.length - cnt];       //answer 배열의 크기를 record의 길이 - cnt로 선언

        for(int i = 0; i < record.length; i++) {        //record 길이만큼 반복
            if(record[i].charAt(0) == 'E') {            //원소의 첫 글자 'E'라면
                answer[i - cntC] = name.get(record[i].substring(6, record[i].indexOf(" ", 6))) + "님이 들어왔습니다.";
                //answer 배열에 아이디를 통해 닉네임 출력 + "님이 들어왔습니다." 대입

            } else if(record[i].charAt(0) == 'L') {     //원소의 첫 글자가 'L'이라면
                answer[i - cntC] = name.get(record[i].substring(6)) + "님이 나갔습니다.";
                //answer 배열에 아이디를 통해 닉네임 출력 + "님이 나갔습니다." 대입

            } else if(record[i].charAt(0) == 'C') {     //원소의 첫 글자가 'C'라면
                cntC++;                                 //cntC 증가
                //Change는 출력을 안하므로 answer 인덱스 번호는 i - cntC
            }
        }

        for (String a : answer) {                       //answer 출력
            System.out.println(a);
        }
    }
}
