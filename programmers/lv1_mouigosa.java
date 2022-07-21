package programmers.lv1;

import java.util.ArrayList;
import java.util.Scanner;

/* 모의고사
1번 학생이 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 학생이 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 학생이 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

정답이 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 출력하여라

입력 예시
[1, 3, 2, 4, 5]

출력 예시
[1, 2, 3]

 - 프로그래머스 특성상 answer배열에 대입해주어야 하므로 학생 수를 모르기 때문에 ArrayList에 답을 구한 뒤
   answer에 대입
 */
public class mouigosa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] answers = {1, 3, 2, 4, 2};            //정답 배열

        int[] answer, a = new int[3];               //결과를 출력할 배열 answer와
                                                    //각 학생이 맞춘 개수를 입력할 배열 a
        ArrayList<Integer> arr = new ArrayList<>(); //가장 많이 맞춘 학생 번호를 입력할 arr
                                                    //몇명인지 모르기 때문에 ArrayList로 선언
        int[] s1 = {1, 2, 3, 4, 5};                 //학생 1번이 찍는 방식
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};        //학생 2번이 찍는 방식
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  //학생 3번이 찍는 방식
        int max, maxCnt = 0;                        //가장 많이 맞춘 점수 max와 max 점수를 받은 학생 수

        for(int i = 0; i < answers.length; i++) {   //정답과 각 학생의 답 비교
            if(answers[i] == s1[i % 5]) {           //학생 1번의 답 패턴이 5개마다 반복
                a[0]++;
            }

            if(answers[i] == s2[i % 8]) {           //학생 2번의 답 패턴이 8개마다 반복
                a[1]++;
            }

            if(answers[i] == s3[i % 10]) {          //학생 3번의 답 패턴이 10개마다 반복
                a[2]++;
            }
        }

        max = Math.max(a[0], Math.max(a[1], a[2])); //가장 많이 맞춘 학생의 점수를 max에 대입

        if(max == a[0]) {                           //max와 각 학생 점수를 비교하여
            maxCnt++;                               //max 점수를 받은 학생수 maxCnt를 구함
            arr.add(1);                             //max 점수를 받은 학생 번호를 arr에 넣어 줌
        }
        if(max == a[1]) {
            maxCnt++;
            arr.add(2);
        }
        if(max == a[2]) {
            maxCnt++;
            arr.add(3);
        }

        answer = new int[maxCnt];                   //answer의 크기를 지정해 줌

        for(int i = 0; i < maxCnt; i++) {           //arr에서 꺼내서 answer에 대입
            answer[i] = arr.get(i);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }
}
