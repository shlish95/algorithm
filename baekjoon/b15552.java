package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 빠른 A+B
정수 T와 T줄에 걸쳐 두 정수 A와 B가 주어질 때, A+B를 출력하여라
T는 최대 1,000,000이기 때문에 Scanner로 입력을 받으면 시간 초과가 되기 때문에
BufferdReader로 입력받고 BufferdWriter로 출력해야 함

입력 예시
5
1 1
12 34
5 500
40 60
1000 1000

출력 예시
2
46
505
100
2000
 */
public class b15552 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
        }
        br.close();

        bw.flush();         //버퍼를 비우고
        bw.close();         //버퍼를 닫기

    }
}

//참고한 사이트 https://st-lab.tistory.com/30