package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 3. 결혼식
피로연에 참석하는 친구 N명의 참석 시간이 주어질 때, 피로연 장에 동시에 존재하는 최대 인원을 구하여라
친구들은 가는 시간 정각에는 존재하지 않는다고 가정

첫 줄에는 참석 인원 N명, 두 번재 줄부터 각 인원의 오는 시간과 가는 시간이 주어짐

입력 예시
5
14 18
12 15
15 20
20 30
5 14

출력 예시
2
 */
class Time implements Comparable<Time> {    //시간 정보를 입력 후 정렬 할 Time 클래스
    public int t;                           //시간을 대입 할 정수형 변수 t(time)
    public char s;                          //그 시간의 상태를 표시 할 문자형 변수 s(state)

    Time(int t, char s) {                   //생성자 호출
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Time o) {          //정렬 기준 compareTo 메서드 재정의
        if (this.t != o.t) {                //t가 같지 않다면
            return this.t - o.t;            //t를 기준으로 오름차순 정렬
        } else {                            //t가 같다면
            return o.s - this .s;           //s를 기준으로 내림차순 정렬(가는 시간이 먼저 오도록 하기 위해)
        }                                   //여기서는 오는 시간이 a, 가는 시간이 l이므로 내림차순이어야 l이 먼저 오게 됨
    }
}
public class Greedy03 {
    private int solution(int n, ArrayList<Time> arr) {
        int answer = 0, cnt = 0;            //정답 answer와 인원을 셀 변수 cnt(count)
        Collections.sort(arr);              //compareTo 메서드를 기준으로 정렬

        for (Time o : arr) {                //arr에 저장된 객체 수 만큼 반복
            if (o.s == 'a') {               //o.s가 a라면 즉, 한 사람이 도착했다면
                cnt++;                      //cnt 증가
            } else {                        //a가 아니라 l이라면, 즉 사람이 떠났다면
                cnt--;                      //cnt 감소
            }
            answer = Math.max(answer, cnt); //answer와 cnt 비교 후 더 큰 값 대입
        }
        return answer;                      //answer 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int l = sc.nextInt();
            arr.add(new Time(a, 'a'));      //오는 시간에는 a(arrival) 입력
            arr.add(new Time(l, 'l'));      //가는 시간에는 l(leave) 입력
        }
        Greedy03 g = new Greedy03();
        System.out.println(g.solution(N, arr));
    }
}
