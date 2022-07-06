package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 달팽이는 올라가고 싶다
땅 위에달팽이가 낮에 A미터 올라가고 밤에 자는 동안 B미터 미끄러질 때, V미터인 나무 막대에 올라가는데 며칠이 걸리는지 구하여라
 * 시간제한이 0.15초이기 때문에 Java 11에서는 scanner로 입력을 받으면 시간 제한에 걸린다.

입력 예시
5 1 6

출력 예시
2
 */
public class s2869 {
    public static void main(String[] args) throws IOException {     //형변환을 하기 위해 필요한 예외처리
        //중간에 버퍼를 두어 한 번에 보내는 방법으로 시간이 단축된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //버퍼는 String으로 받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");         //공백 단위로 구분하여 순서대로 호출

        int A = Integer.parseInt(st.nextToken());           //String으로 받기 때문에 int형으로 변환
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = ((V - A) / (A - B)) + 1;                  //(day - 1일 동안 가는 거리) / (하루동안 가는 거리) + 1

        if ((V - A) % (A - B) != 0) {                       //마지막날 남은 거리가 하루동안 갈 수 있는 거리보다 적으면
            day++;                                          //day가 실수가 되어야 하는데 int형이므로 소수점 이하를 버린다.
        }                                                   //그렇기 때문에 소수점 이하가 존재한다면 day를 증가시킨다.

        System.out.println(day);
    }
}
