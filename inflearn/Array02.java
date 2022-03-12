package inflearn.array;

import java.util.Scanner;

/*
일렬로 서 있는 학생들 중 맨 앞에 서 있는 선생님이 볼 수 있는 학생(앞사람들 보다 키가 큰) 수를 출력
첫 줄에 정수 N(5<=N<=100,000), 그 다음줄에는 N명의 학생 키가 주어 짐

입력 예시
8
130 135 148 140 145 150 150 153

출력 예시
5
 */
public class Array02 { //정수 값이 최대 100,000이므로 for문을 두번 쓰면 100,000의 제곱만큼 계산해야 하므로 시간 제한에 걸림
    public int solution(int num, int[] arr) {
        int answer = 1; //맨 앞 사람은 무조건 보이므로 1로 초기화
        int max = arr[0]; //가장 큰 값보다 i번째 사람이 크면 보이므로 max를 생성해 비교

        for (int i = 1; i < num; i++) { //맨 앞사람은 무조건 보이므로 1부터 시작
            if (arr[i] > max) { //i번째 사람이 max보다 크면
                answer++; //1증가
                max = arr[i]; //max값 변경
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) { //정수 배열 만들기
            arr[i] = scanner.nextInt();
        }

        Array02 a = new Array02();
        System.out.println(a.solution(num, arr));

    }
}
