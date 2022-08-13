package programmers.lv2;

import java.util.*;

/* 프린터
중요도가 높은 문서를 먼저 인쇄하는 프린터에서 내가 요청한 문서 location의 인쇄 순서를 출력하여라
인쇄 방식은 대기목록 priorities 가장 앞에 있는 문서를 꺼내 나머지 대기목록과 비교하여,
중요도가 더 높은 문서가 존재하면 꺼낸 문서를 가장 마지막에 넣음
그렇지 않으면 가장 앞에 있는 문서를 인쇄

입출력 예시
priorities	            location	return
[2, 1, 3, 2]	        2	        1
[1, 1, 9, 1, 1, 1]	    0	        5
 */
public class lv2_프린터 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();        //대기목록을 담을 큐 que
        int cnt = 1;                                    //출력 순서를 나타낼 변수 cnt
        ArrayList<Integer> max = new ArrayList<>();     //문서의 중요도를 표시할 어레이리스트 max


        for (int i = 0; i < priorities.length; i++) {   //que와 max에 대기목록을 각각 넣어줌
            que.offer(priorities[i]);
            max.add(priorities[i]);
        }

        Collections.sort(max, Comparator.reverseOrder());   //max를 내림차순으로 정렬

        while (!que.isEmpty()) {                //que가 비어있지 않다면 반복
            int tmp = que.poll();               //que에서 꺼내 변수 tmp에 대입

            if (tmp == max.get(0)) {            //tmp의 중요도가 제일 높다면
                max.remove(0);            //max에서 제거

                if (location == 0) {            //tmp가 내 문서라면
                    answer = cnt;               //answer에 tmp 대입하고
                    break;                      //반복 중단

                } else if (location > 0) {      //location이 0보다 크다면
                    location--;                 //que의 앞 문서가 제거되었으므로 location 감소
                }
                cnt++;                          //문서가 출력 되었으므로 cnt 증가

            } else {                            //tmp의 중요도가 제일 높지 않다면
                que.offer(tmp);                 //큐에 마지막에 넣고

                if (location > 0) {             //location이 0보다 크다면
                    location--;                 //location 감소
                } else {                        //location이 0이라면, tmp가 내 문서라면
                    location = que.size() - 1;  //맨 뒤로 갔으므로 que 사이즈 -1 대입
                }
            }
        }

        System.out.println(answer);             //answer 출력
    }
}
