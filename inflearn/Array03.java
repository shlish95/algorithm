package inflearn.array;

import java.util.Scanner;

/*
A와 B 두 사람의 가위바위보 승자 출력, 비길 경우 D출력
입력 첫 줄은 게임 횟수, 두번째 줄은 A, 세번째 줄은 B
1은 가위, 2는 바위, 3은 보

입력 예시
5
2 3 3 1 3
1 1 2 2 3

출력 예시
A
B
A
B
D
 */
public class Array03 {
    public String[] solution(int num, int[] A, int[] B) {
        String[] answer = new String[num]; //게임 횟수 크기로 초기화

        for (int i = 0; i < num; i++) { //내 임의로 A가 이기는 것 기준으로 코드를 만듬
            if (A[i] == B[i]) { //A와 B가 같은 것을 내면 "D"출력
                answer[i] = "D";
            } else if (A[i] == 1 && B[i] == 3) { //A가 가위면 B는 보
                answer[i] = "A";
            } else if (A[i] == 2 && B[i] == 1) { //A가 바위면 B는 가위
                answer[i] = "A";
            } else if (A[i] == 3 && B[i] == 2) { //A가 보면 B는 바위
                answer[i] = "A";
            } else {                             //나머지의 경우 B입력
                answer[i] = "B";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); //게임 횟수
        int[] A = new int[num]; //A가 낸 것
        int[] B = new int[num]; //B가 낸 것

        for (int i = 0; i < num; i++) { //A가 낸 것을 배열로 담기
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) { //B가 낸 것을 배열로 담기
            B[i] = scanner.nextInt();
        }

        Array03 a = new Array03();
        for (String x : a.solution(num, A, B)) { //리턴 타입이 배열이기 때문에 반복문으로 출력
            System.out.println(x);
        }
    }
}
