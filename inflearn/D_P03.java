package inflearn.d_p;

import java.util.Scanner;

/* 3. 최대 부분 증가수열(LIS)
N개의 자연수로 이루어진 수열에서 오름차순으로 가장 길게 증가하는 원소들의 집합 길이를 구하여라
첫 줄은 입력되는 자연수의 개수 N, 둘째 줄은 N개의 자연수가 주어짐

입력 예시
8
5 3 7 8 6 2 9 4

출력 예시
4
 */
public class D_P03 {
    static int[] dy;

    private int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];               //각 인덱스의 증가수열 길이를 대입해줄 배열 dy(dynamic table) 선언
        dy[0] = 1;                              //0번 인덱스까지 집합의 길이는 무조건 1이므로 1대입

        for (int i = 1; i < arr.length; i++) {  //0번 인덱스의 길이는 구했으므로 i는 1부터 시작
            int max = 0;                        //i번 전에 인덱스 번호 중 가장 큰 증가수열의 길이를 대입해 줄 변수 max 선언 및 초기화

            for (int j = i - 1; j >= 0; j--) {  //i번 전부터 0번 인덱스까지 비교하기 위한 반복
                if (arr[i] > arr[j]             //arr의 i번째 원소가 j번째 원소보다 크고,
                        && dy[j] > max) {       //dy의 j번째 원소가 max보다 크다면
                    max = dy[j];                //max에 dy의 j번째 원소 값 대입
                }
            }
            dy[i] = max + 1;                    //dy의 i번에 max+1 대입
                                                //if문이 참일 경우 i번째 원소가 추가되었고, 거짓일 경우 max는 0 이므로 자기 자신의 길이 1
            answer = Math.max(answer, dy[i]);   //answer와 비교후 더 큰 값 대입
        }
        return answer;                          //answer 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        D_P03 d = new D_P03();
        System.out.println(d.solution(arr));
    }
}
