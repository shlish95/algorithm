package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/* 3. 크레인 인형뽑기(카카오)
N*N 크기의 화면에서 인형을 뽑아 바구니에 담는 게임을 만드려고 한다.
인형은 1*1에 하나씩 차곡차곡 쌓여 있다.
크레인을 좌우로 움직여 멈춘 위치 가장 위에 있는 인형을 집어올려 바구니에 담는데, 바구니에는 인형이 순서대로 쌓이게 된다.
이때 같은 모양의 인형 이 연속해서 쌓이게 되면 두 인형은 터지면서 바구니에서 사라진다. 이때 터져 사라진 인형의 수를 출력하여라

첫 줄에는 자연수 N, 두 번째 줄부터 N*N 크기의 board 배열이 주어짐
0은 빈칸을 나타내며 1~100 사이의 숫자는 각기 다른 인형의 모양을 나타냄
board 배열이 끝난 후, moves 배열의 길이 M이 주어지고 마지막 줄에는 moves의 배열이 주어짐

입력 예시
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4

출력 예시
4
 */
public class Stack_Queue03 {
    private int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> sta = new Stack<>();             //크레인으로 옮겨진 인형을 담을 크레인을 스택으로 생성
        int tmp = 0;                                    //집어올린 인형을 임시로 담을 tmp 선언 및 초기화

        for (int x : moves) {                           //멈추는 위치(열)를 반복해 줌
            for (int i = 0; i < n; i++) {               //멈추는 열에 인형이 존재하는 행 값을 반복문으로 찾아줌
                if (board[i][x - 1] != 0) {             //0이 아니라면 인형이 있다는 것이므로
                    tmp = board[i][x - 1];              //인형의 값을 tmp에 담아주고
                    board[i][x - 1] = 0;                //집어 올려진 인형 대신 0 대입

                    if (!sta.isEmpty() &&               //바구니가 비어있지 않고,
                            tmp == sta.peek()) {        //바구니 맨 위에 인형이 집어 올려진 인형과 같다면
                        sta.pop();                      //두 인형이 터지므로 맨 위의 인형을 제거하고
                        answer += 2;                    //answer는 2 증가
                    } else {
                        sta.push(tmp);                  //바구니가 비어있거나 인형이 다르다면, 인형만 바구니에 담는다.
                    }
                    break;                              //맨 위에 인형만 집어 올리므로 break로 반복문 중단
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                   //board의 행과 열의 크기 N
        int[][] board = new int[N][N];          //2차원 배열 board 생성
        for (int i = 0; i < N; i++) {           //board에 원소 대입
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int M = sc.nextInt();                   //크래인이 움직이는 위치 횟수 M
        int[] moves = new int[M];               //멈추는 위치를 나타내는 배열 moves 선언
        for (int i = 0; i < M; i++) {           //moves의 원소 대입
            moves[i] = sc.nextInt();
        }

        Stack_Queue03 s = new Stack_Queue03();
        System.out.println(s.solution(N, board, M, moves));

    }
}
