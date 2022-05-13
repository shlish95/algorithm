package inflearn.sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 7. 좌표 정렬
N개의 평면상 좌표가 주어지면 모든 좌표를 오름차순으로 정렬하여라
정렬 기준은 x값에 의해 정렬하고, x값이 같을 경우 y값으로 정렬

첫 줄에는 좌표의 개수 N, 두 번째 줄부터 N개의 x, y순으로 주어짐

입력 예시
5
2 7
1 3
1 2
2 5
3 6

출력 예시
1 2
1 3
2 5
2 7
3 6
 */
class Point implements Comparable<Point> {  //Comparable 인터페이스의 구현 클래스 Point
    public int x, y;                    //좌표값 넣은 변수 x, y 생성

    Point(int x, int y) {               //생성자에서 x, y 호출
        this.x = x;
        this.y = y;
    }

    @Override                           //정의된 compareTo 메서드 재정의
    public int compareTo(Point o) {     //Point 객체를 매개변수로 받아옴
        if (this.x == o.x) {            //현재 객체와 매개변수로 입력된 객체의 x값이 같다면
            return this.y - o.y;        //오름차순이 되기 위해 음수가 리턴되도록 y식을 구성
        } else {                        //같지 않다면
            return this.x - o.x;        //오름차순이 되기 위해 음수고 리턴되도록 x식을 구성
        }
    }
}

public class Sorting_Searching07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();   //ArrayList에 Point 객체를 저장
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);                      //compareTo메서드를 기준으로 정렬해줌
        for (Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}