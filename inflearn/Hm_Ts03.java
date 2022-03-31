package inflearn.hm_ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
N일 동안의 매출 기록 중 K일 동안의 매출액 종류를 각 구간별로 구하여 출력
첫 줄에는 N과 K가, 두 번째 줄에는 N개의 숫자열 입력

입력 예시
7 4
20 12 20 10 23 17 10

출력 예시
3 4 4 3
 */
public class Hm_Ts03 {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();                      //수열의 크기 변동할 수 있고, 원소를 추가할 수 있는
                                                                            //ArrayList 생성

        HashMap<Integer, Integer> map = new HashMap<>();                    //매출액 종류와 각각의 개수를 키, 밸류에 넣을
                                                                            //HashMap 생성

        for (int i = 0; i < k; i++) {                                       //첫 SW(Sliding Window)를 생성
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);   //매출액의 종류와 각각의 개수를 키와 밸류에 대입
        }
        answer.add(map.size());                                             //map의 size를 구해 종류의 개수를 answer에 추가

        for (int i = k; i < n; i++) {                                       //SW를 한 칸씩 옮겨 줌
            if (map.get(arr[i - k]) > 1) {                                  //SW의 첫 키의 밸류값이 1보다 클 때는 밸류 - 1
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            } else {                                                        //SW의 첫 키의 밸류값이 1보다 작을 때는 제거해줌
                map.remove(arr[i - k]);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);   //SW이 한 칸씩 옮기며 새로운 키와 밸류 입력

            answer.add(map.size());                                         //SW가 이동할 때마다 종류의 개수를 answer에 입력
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

        Hm_Ts03 h = new Hm_Ts03();
        for (int x : h.solution(N, K, arr)) {
            System.out.print(x + " ");
        }
    }
}
