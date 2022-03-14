package inflearn.array;

import java.util.Scanner;

/*
피보나치 수열 출력
입력된 정수만큼의 개수 출력

입력 예시
10

출력 예시 1 1 2 3 5 8 13 21 34 55
 */
public class Array04 {
    public int[] solution(int num) {
        int[] answer = new int[num];
        /* 내가 한 방법
        int a = 1, b = 1, tmp = 0; //처음에 1, 1이 필요하므로 변수 생성
        answer[0] = a; //배열 첫번째에 1을 넣어줌, 두번째는 임의로 넣지 않아도 되므로 생략

        for (int i = 1; i < num; i++) {
            answer[i] = b;
            tmp = b; //세 변수를 통해 값들을 바꿔준다.
            b = a + b;
            a = tmp;
        }
        */

        //더 간단한 풀이
        answer[0] = 1; //처음에는 1, 1이 필요하므로 배열에 입력
        answer[1] = 1;

        for (int i = 2; i < num; i++) { //배열에 0, 1번째에 값이 들어갔으므로 i는 2부터 시작
            answer[i] = answer[i-1] + answer[i-2]; //
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Array04 a = new Array04();
        for (int x : a.solution(num)) {
            System.out.print(x + " ");
        }

    }
}
