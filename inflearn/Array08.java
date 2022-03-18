package inflearn.array;

import java.util.Scanner;

/*
입력된 점수의 순서대로 등수를 출력
첫 줄에는 점수의 개수가, 두 번째 줄에는 점수가 입력

입력 예시
5
87 89 92 100 76

출력 예시
4 3 2 1 5
 */
public class Array08 {
    public int[] solution(int num, int[] arr) {
        int[] answer = new int[num];

        for (int i = 0; i < num; i++) {
            int tmp = 1;                        //등수를 표현할 변수 생성

            for (int j = 0; j < num; j++) {     //2중 for문을 통해 i번째 점수와 다른 점수들을 비교
                if (arr[i] < arr[j]) {          //i번째 점수가 작으면 tmp 1씩 증가
                    tmp++;
                }
            answer[i] = tmp;                    //answer에 i번째의 등수 입력
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        Array08 a = new Array08();
        for (int x : a.solution(num, arr)) {
            System.out.print(x + " ");
        }
    }
}
