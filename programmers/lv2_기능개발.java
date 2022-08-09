package programmers.lv2;

import java.util.*;

/* 기능개발
각 기능이 100%일 때 서비스에 반영할 수 있으며, 뒤의 기능이 먼저 개발 되면 앞의 기능이 개발된 후 같이 배포할 수 있다.
작업의 진도 progresses와 하루동안의 개발속도 speeds가 주어질 때, 각 배포마다 몇 개의 기능이 배포되는지를 출력하여라

입출력의 예
progresses	                speeds	            return
[93, 30, 55]	            [1, 30, 5]	        [2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
public class lv2_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        ArrayList<Integer> answer = new ArrayList<>();      //정답을 담을 ArrayList answer
        int day = 1;                                        //개발 일수를 나타낼 변수 day
        Stack<Integer> pr = new Stack<>();                  //progresses와 speeds를 스택에 넣어줌
        Stack<Integer> sp = new Stack<>();

        for(int i = progresses.length - 1; i >= 0; i--) {   //뒤부터 넣어주어 앞의 기능이
            pr.push(progresses[i]);                         //맨 위로 올라오게 해줌
            sp.push(speeds[i]);
        }

        while(!pr.isEmpty()) {                  //스택이 비어있지 않다면 반복
            int cnt = 0;                        //배포될 기능의 개수를 세어줄 변수 cnt

            while(!pr.isEmpty()) {              //스택이 비어있지 않다면 반복
                int tmpPr = pr.pop();           //스택 pr에서 꺼내 변수 tmpPr에 대입
                int tmpSp = sp.pop();           //스택 sp에서 꺼내 변수 tmpSp에 대입

                int cmp = tmpPr + tmpSp * day;  //기능의 완성도를 계산할 변수 cmp(complete)에
                                                //진도 + (개발 속도 * 개발 일수)
                if(cmp <= 100) {        //cmp가 100이 안됐다면
                    pr.push(tmpPr);     //tmpPr과 tmpSp를 각각 다시 넣어줌
                    sp.push(tmpSp);

                    break;              //반복 중단하여 밖깥 while 문 반복
                } else {                //cmp가 100이 넘었다면
                    cnt++;              //cnt 증가
                }
            }

            if(cnt > 0) {           //cnt가 0보다 크다면
                answer.add(cnt);    //answer에 add 해줌
            }
            day++;                  //개발 일수 증가
        }

        for (Integer i : answer) {  //answer 출력
            System.out.print(i + " ");
        }
    }
}
