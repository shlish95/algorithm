package inflearn.array;

import java.util.Scanner;

/*
맞으면 1, 틀리면 0으로 표시된 채점 결과를 받아 점수를 계산해 출력
정답이면 1점, 연속으로 답이 맞는 경우 연속된 만큼 점수를 부여
첫째 줄에는 문제의 개수가, 둘째 줄에는 문제의 채점 결과가 주어짐

입력 예시
10
1 0 1 1 1 0 0 1 1 0

출력 예시
10
 */
public class Array07 {
    public int solution(int num, int[] arr) {
        int answer = 0;
        int tmp = 0; //연속된 만큼의 점수를 계산할 변수 생성

        for (int i = 0; i < num; i++) {
            if (arr[i] == 1) { //채점 결과가 정답이면
                tmp++;         //1씩 증가하여 연속된 만큼의 값이 주어짐
                answer += tmp; //연속된 만큼의 값을 answer에 더해 줌
            } else {
                tmp = 0;       //채점 결과가 틀리면 tmp를 0으로 초기화
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

        Array07 a = new Array07();
        System.out.println(a.solution(num, arr));
    }
}
