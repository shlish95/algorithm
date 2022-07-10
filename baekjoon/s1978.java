package baekjoon.yet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 소수 찾기
주어진 수 N개 중 소수가 몇개인지 출력하시오

입력 예시
4
1 3 5 7

출력 예시
3

처음에 주어진 N개의 수를 배열에 담고 가장 뒤에 수를 기준으로 에라토스테네스의 체를 사용할 배열 che의 크기를 정하였다.
주어진 입력 예시로는 답이 나왔자만 채점 받으니 런타임 에러가 났고, 주어진 N개의 수가 오름차순으로 주지 않을 수 있다는 것을 깨달았다.
그래서 N개의 수를 ArrayList로 받아 정렬해 주었더니 해결 되었다.
 */
public class s1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                       //주어진 정수의 개수
        ArrayList<Integer> arr = new ArrayList<>(); //정수들을 담을 어래이리스트 arr
        int ans = 0;                                //정답 ans 초기화

        for (int i = 0; i < N; i++) {               //arr에 주어진 정수들을 넣어줌
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);                      //arr을 오름차순으로 정렬
        int max = arr.get(arr.size() - 1) + 1;      //가장 큰 정수 + 1을 변수 max에 대입

        int[] che = new int[max];                   //에스토스테네스의 체 크기를 max로 지정
        che[1] = 1;                                 //1은 소수가 아니므로 1번 인덱스의 값에 소수가 아니라는 표시로 1대입

        for (int i = 2; i < max; i++) {             //2부터 max까지 반복하여 i의 배수는 소수가 아니므로 1대입
            int tmp = i + i;                        //tmp는 i의 배수

            while (tmp < max) {                     //tmp가 max보다 커지기 전까지 반복
                che[tmp] = 1;                       //i의 배수에 1대입
                tmp += i;                           //tmp를 i만큼 증가시켜 i의 배수를 찾아줌
            }
        }

        for (int i = 0; i < N; i++) {               //che배열에서 주어진 정수번의 값이 0이면 소수이므로 ans을 증가시켜줌
            if (che[arr.get(i)] == 0)
                ans++;
        }

        System.out.println(ans);                    //ans 출력
    }
}

