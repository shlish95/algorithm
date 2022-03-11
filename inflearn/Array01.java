package inflearn.array;

import java.util.ArrayList;
import java.util.Scanner;

/*
자신의 바로 앞 수보다 큰 수만 출력
첫 줄에는 정수의 개수이며, 첫 번째 수는 무조건 출력

입력 예시
7
8 4 9 3 4 12 8 9

출력 예시
8 9 4 12 9
*/
public class Array01 {
    public ArrayList<Integer> solution(int num,  int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < num; i++) {
            if (arr[i] > arr[i - 1]) {
               answer.add(arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); //첫 줄 정수 개수를 받아 옴
        int[] arr = new int[num]; //정수 개수 크기의 배열 생성

        for (int i = 0; i < num; i++) { //반복문을 통해 띄어쓰기 된 정수들을 배열에 입력
            arr[i] = scanner.nextInt();
        }

        Array01 a = new Array01();

        for (int x : a.solution(num, arr)) {
            System.out.print(x + " ");
        }

    }
}
