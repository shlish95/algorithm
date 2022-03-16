package inflearn.array;

import java.util.ArrayList;
import java.util.Scanner;

/*
입력된 자연수들을 각각 뒤집은 뒤, 소수만 출력
첫 줄에는 자연수의 개수를 나타내는 정수가, 두 번째 줄부터 자연수가 주어짐

입력 예시
9
32 55 62 20 250 370 200 30 100

출력 예시
23 2 73 2 3
 */
public class Array06 {
    public boolean function(int I) { //뒤집은 수가 소수인지 판별하는 메서드
        if (I < 2) { //입력된 정수가 2보다 작으면 false 반환
            return false;
        }

        for (int i = 2; i < I; i++) { //0으로 나눌 수 없고, 1은 모든 수가 나눠지기 때문에 i는 2부터 시작
            if (I % i == 0) {         //i로 나눠서 0이 남는다면 약수가 있는 것이므로 false 반환
                return false;
            }
        }
        return true; //모든 조건을 통과하면 true 반환
    }

    public ArrayList<Integer> solution(int num, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>(); //배열의 개수가 정해지지 않았으므로 ArrayList 사용

        for (int i = 0; i < num; i++) {
            int t = arr[i];
            int n = 0; //뒤집은 값을 저장할 변수

            while (t > 0) { //t를 반복해서 10으로 나누면 결국 0이 되기 때문에 0이 될 때까지 반복
                int tmp = t % 10; //1의 자리수 추출
                n = n * 10 + tmp; //앞서 추출한 1의 자리수에 10을 곱하고, 새로 추출한 1의 자리수를 더해 숫자를 뒤집음
                t = t / 10; //1의 자리수를 추출 후 10으로 나눠줌
            }

            if (function(n)) { //소수 판별 메서드의 결과 true이면 answer에 추가
                answer.add(n);
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

        Array06 a = new Array06();
        for (int x : a.solution(num, arr)) {
            System.out.print(x + " ");
        }
    }
}
