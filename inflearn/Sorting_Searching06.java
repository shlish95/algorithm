package inflearn.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 6. 장난꾸러기
철수네 반 N명의 학생을 키 순으로 세워 1번부터 번호를 부여했는데,
철수와 친구가 서로 자리를 바꿔 번호를 부여 받았다. 이때 철수와 친구의 번호를 차례로 출력하여라

첫 줄에는 자연수 N, 두 번째 줄에는 일렬로 서 있는 학생들의 키가 주어짐

입력 예시
9
120 125 152 130 135 135 143 127 160

출력 예시
3 8
 */
public class Sorting_Searching06 {
    private ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();  //결과 출력을 간단하게 하기 위해 ArrayList 사용
        int[] tmp = arr.clone();                        //arr을 복사하기 위한 tmp 생성
                                                        //그냥 복사를 하면 객체 주소값이 복사되기 때문에 깊은 복사를 해야함

        Arrays.sort(tmp);                               //tmp를 오른차순 정렬

        for (int i = 0; i < n; i++) {                   //arr과 tmp를 하나씩 비교
            if (arr[i] != tmp[i]) {                     //틀린 인덱스 번호 ArrayList에 입력
               answer.add(i + 1);                       //1번부터 시작이기 때문에 인덱스 번호 + 1
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Searching06 s = new Sorting_Searching06();
        for (int x : s.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
