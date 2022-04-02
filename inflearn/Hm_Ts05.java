package inflearn.hm_ts;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/*
1부터 100사이의 자연수가 적힌 N장의 카드 중 3장을 뽑아 합한 값을 기록한 후, 기록한 값 중 K번째로 큰 수를 출력
합한 값이 같으면 같은 순위로 여김
첫 줄에는 N과 K가, 두 번째 줄에는 N개의 자연수가 입력

입력 예시
10 3
13 15 34 23 45 65 33 11 26 42

출력 예시
143
 */
public class Hm_Ts05 {
    private int solution(int n, int k, int[] arr) {
        int answer = -1;                                //K번째 수가 없으면 -1 출력
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        //합한 수가 같은 경우에는 순위가 같다고 했으므로 중복값을 입력받지 않는 TreeSet 사용
        //Collections.reverseOrder()을 입력하면 내림차순으로 정렬, 기본은 오름차순

        int cnt = 0;                                    //TreeSet은 인덱스가 없으므로 K번째를 찾아줄 변수 선언

        for (int i = 0; i < n; i++) {                   //3장의 카드를 뽑아야 하므로 3중 for문 사용
            for (int j = i + 1; j < n; j++) {           //중복된 카드를 뽑지 않기 위해 시작값이 i+1
                for (int l = j + 1; l < n; l++) {       //중복된 카드를 뽑지 않기 위해 시작값이 j+1
                    tSet.add(arr[i] + arr[j] + arr[l]); //3장의 카드의 수를 합하여 tSet에 대입
                }
            }
        }
        for (int x : tSet) {                            //tSet에 원소들을 차례로 x에 대입
            cnt++;                                      //x에 대입된 tSet의 원소의 차례를 알려줌

            if (cnt == k) {                             //cnt가 K와 같으면 tSet의 원소가 K번째 원소이므로
                return x;                               //x에 대입된 tSet원소를 출력
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Hm_Ts05 h = new Hm_Ts05();
        System.out.println(h.solution(N, K, arr));
    }
}
