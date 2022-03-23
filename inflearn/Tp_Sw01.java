package inflearn.tp_sw;

import java.util.ArrayList;
import java.util.Scanner;

/*
오름차순으로 정렬된 두 배열을 오름차순으로 합쳐 출력
첫 줄에는 첫 번째 배열의 크기 N, 두 번째 줄에는 N개의 자연수가 주어짐
세 번째 줄에는 두 번째 배열의 크기 M, 네 번째 줄에는 M개의 자연수가 주어짐

입력 예시
3
1 3 5
5
2 3 6 7 9

출력 예시
1 2 3 3 5 6 7 9
 */
public class Tp_Sw01 {
    public ArrayList<Integer> solution(int N, int[] arrN, int M, int[] arrM) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pN = 0, pM = 0;             //각 배열의 포인터를 선언 후 초기화

        while (pN < N && pM < M) {      //포인터는 인덱스 번호이므로 각 배열의 크기보다 작아야함
            if (arrN[pN] < arrM[pM]) {  //arrN의 pN번째 원소가 arrM의 pM번째 원소보다 작다면
                answer.add(arrN[pN]);   //answer에 arrN의 pN번째 원소 추가
                pN++;                   //포인터를 증가시켜 다음 인덱스 번호를 지정
            //위 두 문장은 answer.add(arrN[pN++]); 한줄로 대체할 수 있음

            } else {                    //arrN의 pN번째 원소가 크거나 같다면
                answer.add(arrM[pM]);   //answer에 arrM의 pM번째 원소 추가
                pM++;                   //포인터 증가
            }
        }                               //둘 중 하나의 포인터가 배열의 크기보다 커지면 while 종료

        while (pN < N) {                //어느 포인터가 배열의 크기만큼 커졌는지 모르기 때문에
            answer.add(arrN[pN]);       //각각 while문을 통해 answer에 추가해줘야함
            pN++;
        }
        while (pM < M) {
            answer.add(arrM[pM]);
            pM++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();               //첫 번째 배열의 크기 N
        int[] arrN = new int[N];            //첫 번째 배열 arrN 선언
        for (int i = 0; i < N; i++) {       //배열의 원소를 대입
            arrN[i] = sc.nextInt();
        }

        int M = sc.nextInt();               //두 번째 배열의 크기 M
        int[] arrM = new int[M];            //두 번째 배열 arrM 선언
        for (int i = 0; i < M; i++) {       //배열의 원소를 대입
            arrM[i] = sc.nextInt();
        }

        Tp_Sw01 t = new Tp_Sw01();
        for (int x : t.solution(N, arrN, M, arrM)) {
            System.out.print(x + " ");
        }
    }
}