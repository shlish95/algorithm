package inflearn.d_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 4. 가장 높은 탑 쌓기
조건을 만족하면서 가장 높이 쌓을 수 있는 탑의 높이를 출력하여라
1) 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
2) 밑면 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
3) 벽돌들의 높이는 같을 수도 있다.
4) 좁은 벽돌 위에 넓은 벽돌은 놓을 수 없고, 가벼운 벽돌 위에 무거운 벽돌을 놓을 수 없다.

첫 줄에는 벽돌의 수 N, 두 번째 줄 부터 각 줄에 벽돌의 밑면 넓이, 높이, 무게가 주어짐

입력 예시
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

출력 예시
10
 */
class Brick implements Comparable<Brick> {  //각 벽돌을 표현할 Brick 클래스
    public int s, h, w;                     //넓이 s(space), 높이 h(height), 무게 w(weight) 변수

    Brick(int s, int h, int w) {            //Brick 생성자
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {         //객체 정렬 기준 compareTo 메서드 재정의
        return o.s - this.s;                //s(넓이)를 기준으로 내림차순
    }
}
public class D_P04 {
    static int[] dy;                        //각 벽돌까지의 최대 높이를 대입할 배열 dy

    private int solution(int n, ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);              //s(넓이)를 기준으로 내림차순 정렬
        dy = new int[n];                    //dy는 벽돌 개수크기 n으로 초기화
        dy[0] = arr.get(0).h;               //넓이가 가장 넓은 0번째 벽돌의 높이 값을 dy[0]에 대입
        answer = dy[0];                     //현재 벽돌의 최대 높이인 dy[0] 대입

        for (int i = 1; i < n; i++) {       //0번째 벽돌은 이미 대입했으므로 1번부터 시작
             int max_h = 0;                 //가장 큰 높이값을 넣어 줄 변수 max_h 선언

            for (int j = i - 1; j >= 0; j--) {  //i 이전의 벽돌들과 비교
                if (arr.get(i).w < arr.get(j).w //i 보다 넓이가 넓고,
                        && dy[j] > max_h) {     //max_h 보다 j번까지의 높이가 높다면
                    max_h = dy[j];              //max_h에 j번째 높이 값 대입
                }
            }
            dy[i] = max_h + arr.get(i).h;       //현재 벽돌 번호인 i번에 max_h 값과 현재 벽돌 높이 값 합하여 대입
            answer = Math.max(answer, dy[i]);   //answer 와 dy의 i번 비교 후 더 큰 값 대입
        }
        return answer;                          //answer 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }

        D_P04 n = new D_P04();
        System.out.println(n.solution(N, arr));
    }
}
