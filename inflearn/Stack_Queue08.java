package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 8.응급실
응급실에 도착한 N명의 환자 중 위험도에 따라 진료 순서를 정하여 M번째로 도착한 환자의 진료 순서를 출력

도착한 순서대로 환자 목록에 입력 되지만, 대기 환자 중 응급도가 더 높은 환자가 존재하면 대기목록 제일 뒤로 들어감
대기목록의 제일 처음 환자를 0번째로 간주
첫 줄에는 N과 M이, 두 번째 줄에는 도착한 순서대로 환자의 위험도가 주어짐

입력 예시
6 3
70 60 90 60 60 60

출력 예시
4
 */
class Person {                                      //큐에 넣어줄 객체 생성
    int id;                                         //도착 순서를 나타낼 변수 생성
    int priority;                                   //위험도를 나타낼 변수 생성

    public Person(int id, int priority) {           //id와 priority를 매개변수로 받아 생성자 선언
        this.id = id;
        this.priority = priority;
    }
}
public class Stack_Queue08 {
    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> que = new LinkedList<>();     //도착 순서와 위험도를 넣어 줄 큐 생성

        for (int i = 0; i < n; i++) {               //큐에 객체를 선언하고 순서와 위험도 입력
            que.offer(new Person(i, arr[i]));
        }

        while (!que.isEmpty()) {                    //반복문을 통해 위험도 비교
            Person tmp = que.poll();                //맨 처음 도착한 환자를 꺼내 tmp에 대입

            for (Person x : que) {                  //강화된 for문을 통해 tmp와 나머지 비교
                if (tmp.priority < x.priority) {    //tmp에 위험도가 더 작으면
                    que.offer(tmp);                 //tmp를 다시 큐에 맨 뒤로 넣어주고
                    tmp = null;                     //tmp 비워준 후
                    break;                          //강화된 for문 중단
                }
            }
            if (tmp != null) {                      //tmp가 비어있지 않다면 tmp환자의 위험도가
                answer++;                           //나머지 환자의 위험도보다 크다는 것이므로 answer 증가
                if (tmp.id == m) {                  //tmp환자가 K번째 도착한 환자이면
                    return answer;                  //answer를 반환
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack_Queue08 s = new Stack_Queue08();
        System.out.println(s.solution(N, M, arr));
    }
}
