package inflearn.array;

import java.util.Scanner;

/*
N*N 격자판에 입력된 숫자 중 상하좌우 숫자보다 큰 숫자가 몇 개있는 지 출력
첫 줄에는 자연수 N이, 둘 째줄 부터는 격자판에 들어갈 자연수가 입력
격자의 가장자리는 0으로 초기화 되어있다고 가정

입력 예시
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

출력 예시
10
 */
public class Array10 {
    private int solution(int num, int[][] arr) {
        int answer = 0;
        int[] comC = {-1, 0, 1, 0};                 //arr배열에 각 숫자 위, 오른쪽, 아래, 왼쪽 숫자와 각각 비교를 위해
        int[] comR = {0, 1, 0, -1};                 //각 위치에 해당하는 숫자를 지정하는 comC와 comR 배열을 선언

        for (int i = 0; i < num; i++) {             //arr배열의 행
            for (int j = 0; j < num; j++) {         //arr배열의 열
                boolean boo = true;                 //위, 오른쪽, 아래, 왼쪽 숫자보다 큰지 확인하는 변수

                for (int k = 0; k < 4; k++) {       //각 숫자를 비교하기 위해 k 반복문 추가
                    int comI = i + comC[k];         //각 숫자와 비교할 행 값
                    int comJ = j + comR[k];         //각 숫자와 비교할 열 값

                    if (comI >= 0 && comI < num && comJ >= 0 && comJ < num && //인덱스 범위를 넘어가지 않는 범위 설정
                            arr[i][j] <= arr[comI][comJ]) {                   //arr배열의 숫자가 주변 숫자보다 작거나 같으면
                        boo = false;                                          //boo변수는 false, k 반복문 중단
                        break;
                    }
                }
                if (boo) {                          //비교 후에도 boo가 true면 answer 1씩 증가
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Array10 a = new Array10();
        System.out.println(a.solution(num, arr));
    }
}
