package inflearn.greedy;

import java.util.Scanner;

/* 6. 친구인가? (Disjoint-Set : Union&Find)
모든 학생은 1부터 N까지 번호가 부여되고, 각 두 명의 친구 관계가 숫자 쌍으로 주어질 때 특정 두 학생이 친구인지 판별하여라
(1, 2), (2, 3), (3, 4)의 숫자 쌍이 주어지면 1번부터 4번까지 모두 친구관계

첫 줄에는 학생수 N과 숫자 쌍의 개수 M, 다음 M개의 숫자 쌍이 각 줄에 주어지고
마지막 줄에는 두 학생이 친구인지 확인하는 숫자 쌍이 주어짐

* 서로소 집합을 통해 해결

입력 예시
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8

출력 예시
NO
 */
public class Greedy06 {
    static int[] unf;                   //해당 번호(인덱스) 학생의 집합을 표현해줄 배열 unf

    static int Find(int v) {     //v번 학생의 집합 번호를 반환해줄 메서드 Find
        if (v == unf[v]) {              //인덱스 번호와 unf의 해당 값이 같다면
            return v;                   //그대로 v 반환
        } else {                        //다르다면
            return unf[v] = Find(unf[v]);   //unf v번의 값을 넣어 Find 실행 후 결과를 v번에 대입
        }
    }

    private static void Union(int a, int b) {   //a, b 두 학생이 친구 관계임을 표시해줄 메서드 Union
                                                //unf 값을 같게 해주어 같은 집합에 속하도록 해줌
        int fa = Find(a);               //a를 매개변수로 Find 메서드를 실행한 결과를 대입할 변수 fa
        int fb = Find(b);               //b를 매개변수로 Find 메서드를 실행한 결과를 대입할 변수 fb

        if (fa != fb) {                 //fa와 fb가 다를 경우
            unf[fa] = fb;               //fb의 값을 fa번 학생의 값에 대입
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        unf = new int[N + 1];               //인덱스 번호와 학생 번호를 같게 하기 위해 크기는 N+1
        for (int i = 1; i <= N; i++) {      //unf 각 인덱스에 해당 인덱스 번호를 넣어줌
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {       //숫자 쌍을 입력 받아 Union 메서드에 실행
            int a = sc.nextInt();
            int b = sc.nextInt();

            Union(a, b);
        }

        int a = sc.nextInt();               //친구 관계를 확인 할 두 친구를 변수 a, b에 대입
        int b = sc.nextInt();

        int fa = Find(a);                   //Find 메서드에 각각 친구 번호를 넣은 결과를 fa, fb에 대입
        int fb = Find(b);

        if (fa == fb) {                     //fa와 fb가 같다면, 즉 같은 집합에 속하면
            System.out.println("YES");      //YES 출력
        } else {                            //fa와 fb가 다르다면, 즉 다른 집합에 속하면
            System.out.println("NO");       //NO 출력
        }
    }
}
