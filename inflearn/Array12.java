package inflearn.array;

import java.util.Scanner;
/*
N명의 학생의 테스트 등수를 가지고 멘토와 멘티를 정하려고 할 때, M번의 테스트에서 멘토는 멘티보다 등수가 앞서야 한다.
이때 멘토와 멘티가 짝이되는 경우의 수를 출력하시오.
첫 줄에는 학생수와 테스트 횟수가, 두 번째 줄에는 등수별 학생 번호가 주어진다.

입력 예시
4 3
3 4 1 2
4 3 2 1
3 1 4 2

출력 예시
3
 */
public class Array12 {
    public int solution(int std, int test, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= std; i++) {            //1~4번 학생들이 각각 멘토와 멘티가 될 경우의 수를 이중 for문으로 구함
            for (int j = 1; j <= std; j++) {        //i학생은 멘토, j학생은 멘티일 경우

                int cnt = 0;                        //각 시험별 멘토가 멘티보다 등수가 높으면 증가시킬 변수 초기화

                for (int k = 0; k < test; k++) {    //시험 횟수만큼 반복
                    int Ri = 0, Rj = 0;             //i번째 학생과 j번째 학생을 각각 멘토와 멘티로 지정되었을 경우
                                                    //k번째 시험에서 해당 학생의 등수를 나타낼 변수

                    for (int l = 0; l < std; l++) { //학생 수만큼 반복
                        if (arr[k][l] == i) {       //k번째 시험에서 i학생(멘토)의 등수를 구해 Ri에 대입
                            Ri = l;
                        }
                        if (arr[k][l] == j) {       //k번째 시험에서 j학생(멘티)의 등수를 구해 Rj에 대입
                            Rj = l;
                        }
                    }
                    if (Ri < Rj) {                  //i학생(멘토)의 등수가 j학생(멘티)의 등수보다 높으면 cnt증가
                        cnt++;
                    }
                }
                if (cnt == test) {                  //cnt가 시험 횟수와 같다는 것은
                    answer++;                       //모든 시험에서 멘토의 등수가 멘티의 등수보다 높다는 것이기 때문에 answer 증가
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int std = sc.nextInt();                     //학생 수
        int test = sc.nextInt();                    //시험 횟수
        int[][] arr = new int[test][std];           //학생별 등수
        for (int i = 0; i < test; i++) {
            for (int j = 0; j < std; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Array12 a = new Array12();
        System.out.println(a.solution(std, test, arr));
    }


}
