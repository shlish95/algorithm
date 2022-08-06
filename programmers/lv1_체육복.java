package programmers.lv1;

import java.util.Arrays;

/* 체육복
체육복을 도난당한 학생들에게 여분의 체육복을 빌려줄 때, 체육복을 입고 수업을 들을 수 잇는 학생의 최댓값을 구하여라
전체 n명의 학생과 체육복을 잃어버린 학생 번호가 주어지고, 여분의 체육복이 있는 학생 번호가 주어짐
학생 번호는 체격 순으로 매겨져 있어 바로 앞번호나 뒷번호 학생에게만 체육복을 빌려줄 수 있음
여벌의 체육복이 있는 학생이 도난 당했을 경우, 다른 학생에게 빌려줄 수 없음

입출력 예시
n	lost	reserve	    return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	        4
3	[3]	    [1]	        2
 */
public class lv1_체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};            //도난당한 학생 번호를 표시한 배열 lost
        int[] reserve = {1, 3, 5};      //여분의 체육복이 있는 학생 번호를 표시한 배열 reserve
        int answer = 0;                 //수업 참여 가능한 학생 수 answer

        for(int i = 0; i < lost.length; i++) {          //여벌의 체육복이 있는 학생 중
            for(int j = 0; j < reserve.length; j++) {   //도난 당한 학생이 있는 지 확인
                if(lost[i] == reserve[j]) {             //있다면, -1로 표시
                    lost[i] = reserve[j] = -1;
                    answer++;                           //체육복이 있으므로 answer 증가
                    break;
                }
            }
        }
        Arrays.sort(lost);              //lost와 reserve를 오름차순으로 정렬
        Arrays.sort(reserve);

        for(int i = answer; i < lost.length; i++) {         //answer번 이전은 -1로 표시되어 있으므로
            for(int j = answer; j < reserve.length; j++) {  //answer번부터 반복하여
                if(lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    answer++;                               //앞, 뒤 번호의 학생에게 빌려줄 수 있는지 확인
                    reserve[j] = -1;                        //빌려줄 수 있다면 answer 증가 후
                    break;                                  //reserve의 j번째에 -1 대입
                }
            }
        }

        System.out.println(answer += (n - lost.length));    //빌린 학생만큼 증가된 answer에
    }                                                       //도난당하지 않은 학생 수를 더해 줌
}
