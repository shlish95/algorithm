package programmers.dev_matching_웹_백엔드_개발자_2021상반기;

import java.util.*;

/* 로또의 최고 순위와 최저 순위
일부를 알아볼 수 없는 로또 예상 번호와 당첨 번호를 비교하여 예상 최고 등수와 최저 등수를 출력하여라
알아볼 수 없는 번호는 0으로 표시되어 있음
6개 번호가 모두 일치하면 1등, 5개 번호가 일치하면 2등, ... 2개 번호가 일치하면 5등, 그 외는 6등(낙첨)

입력 예시
lottos	                win_nums	                result
[44, 1, 0, 0, 31, 25]   [31, 10, 45, 1, 6, 19]	    [3, 5]
[0, 0, 0, 0, 0, 0]      [38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	    [1, 1]


 */
public class lv1_로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};       //로또 예상 번호 배열 lottos
        int[] win_nums = {31, 10, 45, 1, 6, 19};    //당첨 번호 배열 win_nums

        int[] answer = new int[2];                  //최고 등수와 최저 등수를 담을 배열 answer
        ArrayList<Integer> lot = new ArrayList<>(); //알아볼 수 없는 번호의 수가 몇개인지 모르고 정렬하기 위해
        ArrayList<Integer> win = new ArrayList<>(); //예상 번호와 당첨번호를 ArrayList에 담아줌
        int cnt0 = 0, match = 0;                    //0의 개수를 담을 변수 cnt0, 맞춘 개술를 담아줄 변수 match

        for(int i = 0; i < 6; i++) {                //로또 번호의 개수는 6개이므로 6번 반복
            lot.add(lottos[i]);                     //ArrayList에 담아줌
            win.add(win_nums[i]);

            if(lottos[i] == 0) {                    //알아볼 수 없는 숫자의 개수를 세어줌
                cnt0++;
            }
        }

        Collections.sort(lot);                      //예상 번호와 당첨 번호를 오름차순으로 정렬해줌
        Collections.sort(win);

        for(int i = cnt0; i < 6; i++) {             //정렬상 0은 맨 앞에 있기 때문에 0이 아닌 인덱스 번호부터 반복 시작
            for(int j = 0; j < win.size(); j++) {   //당첨번호는 0번째부터 반복 시작
                if(lot.get(i) == win.get(j)) {      //예상 번호와 당첨 번호가 같다면
                    match++;                        //match 증가
                    win.remove(j);                  //당첨 번호와 같은 예상 번호는 지워 반복 횟수를 줄음
                }
            }
        }

        answer[0] = (match + cnt0) > 1 ? 7 - (match + cnt0) : 6;    //맞춘 개수가 2개 이상이라면 해당 등수를 표현하고,
        answer[1] = (match) > 1 ? 7 - (match) : 6;                  //1개 이하라면 6등으로 표시해줌

        System.out.println(answer[0] + ", " + answer[1]);           //최고 등수와 최저 등수를 출력
    }
}

