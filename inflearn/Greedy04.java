package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
N개의 기업에서 D일 안에 강연을 해주면 M 만큼의 강연료를 주기로 했을 때 최대로 벌 수 있는 수입을 구하여라

첫 줄에 자연수 N, 두 번째 줄부터 각 M과 D가 주어짐

입력 예시
6
50 2
20 1
40 2
60 3
30 3
30 1

출력 예시
150
 */
class lecture implements Comparable<lecture> {  //lecture 클래스 생성
    public int money, date;                     //M과 D를 받을 변수 money와 date

    lecture(int money, int date) {              //생성자 호출
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(lecture o) {           //compareTo 메서드를 재정의
        return o.date - this.date;              //date를 기준으로 내림차순 정렬
    }
}
public class Greedy04 {
    static int N, max = Integer.MIN_VALUE;      //강연 요청 수를 나타낼 변수 N, D의 최대값을 넣을 변수 max 선언 및 초기화

    private int solution(ArrayList<lecture> arr) {
        int answer = 0;
        Collections.sort(arr);                  //compareTo 메서드 기준으로 정렬
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
                                                //PriorityQueue는 가장 작은 수를 먼저 poll 해줌,
                                                //하지만 Collections.reverseOrder()를 입력하면 가장 큰 수를 먼저 poll 함

        int j = 0;                              //i값이 바뀔 때마다 j값이 0부터 시작하지 않기 위해 for문 밖에 선언
        for (int i = max; i >= 1; i--) {        //i는 max부터 1까지 반복
            for (; j < N; j++) {                //j는 N까지 반복
                if (arr.get(j).date < i) {      //arr의 j번째 date가 i보다 작다면
                    break;                      //반복 중단
                }

                pQ.offer(arr.get(j).money);     //pQ에 j번째 money 넣어줌
            }
            if (!pQ.isEmpty()) {                //pQ가 비어있지 않다면
                answer += pQ.poll();            //꺼내서 answer에 더해줌
            }
        }
        return answer;                          //answer 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ArrayList<lecture> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new lecture(m, d));
            if (max < d) {                      //date의 최대값을 넣어줌
                max = d;
            }
        }

        Greedy04 g = new Greedy04();
        System.out.println(g.solution(arr));
    }
}
