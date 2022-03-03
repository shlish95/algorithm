package inflearn;

import java.util.Scanner;
/*
영어 알파벳과 특수문자가 섞인 문자열에서 영어만 앞뒤로 뒤집는 프로그램 작성

입력 예시
a#b!GE*T@S

출력 예시
S#T!EG*b@a
 */
public class String05 {
    public String solution(String str) {
        String answer = "";
        char[] ch = str.toCharArray(); //받은 문자열을 문자 배열로 변환
        int lt = 0, rt = ch.length - 1; //문자 배열의 양 끝 인덱스 번호를 변수에 저장

        while (lt < rt) { //반복을 통해 양 끝에서부터 안쪽으로 모여들며 비교
            if (Character.isAlphabetic(ch[lt])) { //문자의 앞쪽 문자가 알파벳이면
                while (lt < rt) {
                    if (Character.isAlphabetic(ch[rt])) { //문자 뒷쪽 문자가 알파벳이면
                        char tmp = ch[lt]; //문자 뒤집어줌
                        ch[lt] = ch[rt];
                        ch[rt] = tmp;
                        lt++;
                        rt--;

                        break; //while문을 한번 더 적용했기 때문에 멈춰줘야함
                    } else {
                        rt--;
                    }
                }
            } else {
                lt++;
            }
        }
        /*
        if문 조건이 앞 문자가 문자가 아니라면(!)으로 설정하면 더 깔끔함
        if(!(Character.isAlphabetic(ch[lt])) {
            lt++;
        } else if(!(Character.isAlphabetic(ch[rt])) {
            rt--;
        } else {
            문자 뒤집기
        }
         */

    //또한 if문의 조건으로 아스키 코드를 사용할 수 있음

        answer = String.valueOf(ch); //문자 배열을 문자열로 변환

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String05 s = new String05();

        System.out.println(s.solution(str));
    }
}
