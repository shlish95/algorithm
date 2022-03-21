package inflearn.array;

import java.util.Scanner;

/*
6학년 1반 임시반장을 뽑기 위해 한번이라 같은 반이었던 사람 수를 구해 가장 많은 학생을 임시반장으로 정하려함
첫 줄에는 학생 수 N이 입력되고, 둘째 줄부터 각 학생들의 1학년부터 5학년까지 반을 나타내는 정수가 입력

입력 예시
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

출력 예시
4
 */
public class Array11 {
    public int solution(int num, int[][] arr) {
        int answer = 0;
        int cnt = 0;                                //한 번이라도 같은 반을 한 학생 수 중 가장 큰 수를 넣어줄 변수

        for (int i = 0; i < num; i++) {
            int tmp = 0;                            //각 학생 별 한 번이라도 같은 반을 한 학생 수를 구하는 변수

            for (int j = 0; j < num; j++) {
                for (int k = 0; k < 5; k++) {       //1~5학년까지의 반을 구하므로 0~5까지만 반복
                    if (arr[i][k] == arr[j][k]) {   //i번째 학생과 k학년 때 같은 반이라면
                        tmp++;                      //tmp 증가
                        break;                      //한 번이라도 같은 반을 한 학생 수를 구하기 때문에
                    }                               //j번째 학생이 한 번 같은 반이라면 반복문 중단
                }
            }
            if (cnt < tmp) {                        //cnt 보다 i번째 학생의 tmp가 크면
                cnt = tmp;                          //cnt는 tmp가 되고
                answer = i + 1;                     //answer에는 i번째 학생의 순서, i + 1이 삽입
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][5];              //1~5학년까지의 반을 구하므로 열을 5로 지정

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {           //1~5학년까지의 반을 구하므로 0~5까지만 반복
                arr[i][j] = sc.nextInt();
            }
        }

        Array11 a = new Array11();
        System.out.println(a.solution(num, arr));
    }
}
