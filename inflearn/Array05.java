package inflearn.array;

import java.util.Scanner;

/*
1부터 입력된 자연수까지의 소수의 개수를 출력 (에라토스테네스 체 사용)
만약 20이 입력되면 2, 3, 5, 7, 11, 13, 17, 19 총 8개

입력 예시
20

출력 예시
8
 */
public class Array05 {
    public int solution(int num) {
        int answer = 0;
        int[] arr = new int[num + 1]; //인덱스 번호를 통해 소수를 구하기 위해 인덱스 번호가 num 크기의 배열을 생성

        for (int i = 2; i < arr.length; i++) { //0과 1은 소수가 아니므로 2부터 시작
            if (arr[i] == 0) { //배열의 i인덱스 값이 0이라면 answer++
                answer++;

                for (int j = i; j < arr.length; j = j + i) { //i값의 배수번째 값에 1을 넣어줌
                    arr[j] = 1;                              //i값의 배수이면 소수가 아니기 때문
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Array05 a = new Array05();
        System.out.println(a.solution(num));
        }
}
