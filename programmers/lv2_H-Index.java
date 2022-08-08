package programmers.lv2;

import java.util.Arrays;

/* H-Index
발표한 논문의 인용 횟수가 배열 citations에 주어질 때, 과학자의 생산성과 영향력을 나타내는 H-Index를 구하여라
발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이라면 h의 최댓값이 이 과학자의 h-Index

입출력 예시
citations	        return
[3, 0, 6, 1, 5]	    3
 */
public class lv2_H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;

        Arrays.sort(citations);     //주어진 배열을 오름차순으로 정렬

        for (int i = 0; i < citations.length; i++) {        //논문의 개수만큼 반복
            if (citations[i] >= citations.length - i) {     //i번째 논문의 인용횟수가 전체 - i 보다 크거나 같다면
                answer = citations.length - i;              //그 값을 answer에 대입
                break;                                      //최초로 구한 값이 최댓값이므로 반복 중단
            }
        }

        System.out.println(answer);
    }
}
