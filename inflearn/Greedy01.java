package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 1. 씨름 선수
씨름 선수 선발에 N명의 지원자가 지원을 했고, 최대 몇 명이 선발되는지 출력하여라
키와 몸무게를 일대일로 비교하여 임의의 지원자 A보다 키, 몸무게 모두 높은 지원자가 존재하면
A는 탈락하고, 그렇지 않으면 선발

첫 줄에는 지원자의 수 N, 두 번째 줄부터 지원자의 키, 몸무게가 각 줄에 주어짐

입력 예시
5
172 67
183 65
180 70
170 72
181 60

출력 예시
3
 */
class Body implements Comparable<Body> {    //Comparable 인터페이스의 구현 클래스 Body
    public int h, w;                //키와 몸무게를 대입할 변수 h, w 선언

    Body(int h, int w) {            //생성자에 h, w 호출
        this.h = h;
        this.w = w;
    }
    @Override                       //기존 compareTo 메서드를 재정의
    public int compareTo(Body b) {  //Body 객체를 매개변수로 받음
        return b.h - this.h;        //몸무게(h)를 내림차순으로 정렬(양수)
    }
}
public class Greedy01 {
    private int solution(ArrayList<Body> arr, int n) {  //arr과 n을 매개변수로 받는 매서드 선언
        int cnt = 0;                //선발될 인원 수를 구할 변수 선언
        Collections.sort(arr);      //compareTo 메서드를 기준, 즉 키(h)의 내림차순으로 정렬
        int max = Integer.MIN_VALUE;//max값에 정수의 최소값을 넣어 초기화

        for (Body o : arr) {        //arr에 저장된 객체의 개수만큼 반복
            if (o.w > max) {        //이미 키의 내림차순으로 정렬됐으므로 몸무게(w) 비교
                max = o.w;          //max보다 o객체의 몸무게(w)가 크다면 max에 대입
                cnt++;              //몸무게가 더 크다면 선발된 것이므로 cnt 증가
            }
        }
        return cnt ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }

        Greedy01 g = new Greedy01();
        System.out.println(g.solution(arr, N));
    }
}
