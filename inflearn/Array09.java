package inflearn.array;

import java.util.Scanner;
/*
입력된 자연수 N*N 크기의 격자판에서 각 행의 합, 열의 합, 대각선의 합 중 가장 큰 값 출력
첫 줄에는 자연수 N이 주어지고, 두 번째 줄부터 격자판에 크기에 맞는 자연수가 입력

입력 예시
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

출력 예시
155
 */
public class Array09 {
    public int solution(int num, int[][] arr) {
        int answer = 0;
        int sumR, sumC, sumX, sumY;         //각 행의 합, 열의 합, 대각선의 합을 구할 변수 선언

        for (int i = 0; i < num; i++) {     //먼저 각 행과, 열의 합을 구함
            sumR = sumC = 0;                //각 행, 열의 합이 구해질 때 마다 0으로 초기화

            for (int j = 0; j < num; j++) {
                sumR += arr[i][j];          //각 행의 합
                sumC += arr[j][i];          //각 열의 합
            }
            answer = Math.max(answer, sumR);//각 행의 합과 answer변수 중 큰 값이 answer에 저장
            answer = Math.max(answer, sumC);//각 열의 합과 answer변수 중 큰 값이 answer에 저장
        }

        sumX = sumY = 0;                    //대각선의 합을 구할 변수 0으로 초기화
        for (int i = 0; i < num; i++) {
            sumX += arr[i][i];              //왼쪽에서 오른쪽으로 내려오는 대각선의 합
            sumY += arr[i][num - 1 - i];    //오른쪽에서 왼쪽으로 내려오는 대각선의 합
        }
        answer = Math.max(answer, sumX);    //각 대각선의 합과 answer의 값 중 큰 값이 answer에 저장
        answer = Math.max(answer, sumY);

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] arr = new int[num][num];    //2차원 배열 선언
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();   //2차원이기 때문에 i와 j를 반복하여 입력된 값을 배열에 넣어줌
            }
        }

        Array09 a = new Array09();
        System.out.println(a.solution(num, arr));
    }
}
