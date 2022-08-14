package programmers.dev_matching_웹_백엔드_개발자_2021상반기;

import java.util.HashMap;

/* 다단계 칫솔 판매
다음 규칙에 따라 이익을 나누는 다단계 칫솔 판매원들의 이익을 구하여라
판매원은 자신의 이익 중 10%를 추천인에게 배분함, 추천인이 없는 경우 center에 이익을 배분
배분받은 이익과 판매하여 얻은 이익에서 10%를 배분해야하며 원 단위까지 절사하여 배분
칫솔은 하나에 100원임

입출력 예시
enroll	            referral	        seller	                amount	    result
["john", "mary",    ["-", "-",          ["young", "john",       [12, 4,     [360, 958,
"edward", "sam",    "mary", "edward",   "tod", "emily",         2, 5,       108, 0,
"emily", "jaimie",  "mary", "mary",     "mary"]                 10]         450, 18,
"tod", "young"]	    "jaimie", "edward"]	      	  	                        180, 1080]

["john", "mary",    ["-", "-",          ["sam", "emily",        [2, 3,      [0, 110,
"edward", "sam",    "mary", "edward",   "jaimie", "edward"]     5, 4]       378, 180,
"emily", "jaimie",  "mary", "mary",                                         270, 450,
"tod", "young"]     "jaimie", "edward"]                                     0, 0]
 */
class Person {          //판매원의 정보를 담을 객체 Person 생성
    String name;        //판매원 이름
    String ref;         //추천인
    int pf;             //이익(profit)

    public Person(String name, String ref, int pf) {    //기본 생성자
        this.name = name;
        this.ref = ref;
        this.pf = pf;
    }
}

public class lv3_다단계_칫솔_판매 {
    static HashMap<String, Person> map;     //판매원과 person객체를 키, 밸류로 담을 정적 해쉬맵 선언

    public static void CalPf(Person person, int profit) {   //(Calculated Profit) 메서드
        int refPf = profit / 10;                //추천인에게 줄 변수 refPf

        if(person.ref != null && refPf != 0) {  //추천인이 있고, refPf가 0이 아니라면
            CalPf(map.get(person.ref), refPf);  //재귀 호출을 통해 center까지 반복
        }
        person.pf += profit - refPf;            //현재 객체의 pf에 이익에서 refPf를 뺀 값 대입
    }
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = new int[enroll.length];      //각 판매원의 이익을 담을 배열 answer
        map = new HashMap<>();                      //map 최기화

        for(int i = 0; i < enroll.length; i ++) {   //map에 판매원 이름별로 객체 생성하여 이름만 담아줌
            map.put(enroll[i], new Person(enroll[i], null, 0));

            if(!referral[i].equals("-")) {          //추천인이 있다면 map에 추천인도 담아줌
                map.get(enroll[i]).ref = referral[i];
            }
        }

        for(int i = 0; i < seller.length; i++) {    //배열 seller에 이름이 있다면
            CalPf(map.get(seller[i]), amount[i] * 100);
        }   //CalPf 메서드에 Person 객체와 판매 이익을 매개변수로 넣어 실행

        for(int i = 0; i < answer.length; i++) {    //CalPf 매서드 실행 후
            answer[i] = map.get(enroll[i]).pf;      //map에 담긴 pf를 배열 answer에 담음
        }

        for (int i : answer) {          //answer 출력
            System.out.print(i + " ");
        }
    }
}
