package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 2. 회의실 배정
각 회의에 대한 시작 시간과 끝나는 시간이 주어질 때, 한 개의 회의실을 사용할 수 있는 최대 수를 찾아라

첫 줄에 회의 수 N, 둘째 줄부터 각 회의의 시작 시간과 끝나는 시간이 주어짐

입력 예시
5
1 4
2 3
3 5
4 6
5 7

출력 예시
3
 */
class Room implements Comparable<Room> {    //인터페이스 Comparable을 상속할 Room 클래스
    public int s, e;                        //시작 시간 s, 끝나는 시간 e 변수 선언

    Room(int s, int e) {                    //Room 클래스의 생성자
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Room r) {          //Comparable의 compareTo 메서드 재정의
        if(this.e == r.e) {                 //끝나는 시간끼리 같다면
            return this.s - r.s;            //시작 시간으로 오름차순 정렬
        } else {                            //같지 않다면
            return this.e - r.e;}           //끝나는 시간으로 오름차순 정렬
    }
}
public class Greedy02 {
    private int solution(int n, ArrayList<Room> arr) {
        int cnt = 0;                        //회의 수를 세 줄 변수 cnt(count)
        Collections.sort(arr);              //arr을 정의된 순서대로 정렬

        int et = 0;                         //끝나는 시간을 대입할 변수 et(end time)
        for (Room ob : arr) {               //arr의 원소를 ob에 대입해 각각 반복
            if (ob.s >= et) {               //해당 객체의 시작 시간이 et보다 크거나 같으면(늦거나 같으면)
                et = ob.e;                  //et에 해당 객체의 끝나는 시간 대입
                cnt++;                      //회의실 사용이 가능하므로 cnt 증가
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Room> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Room(s, e));
        }

        Greedy02 g = new Greedy02();
        System.out.println(g.solution(N, arr));
    }
}
