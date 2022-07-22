package etc;

import java.util.Scanner;

/* 베스킨라빈스31 게임
컴퓨터가 먼저 시작하고, 컴퓨터가 무조건 이기는 프로그램 작성하여라
힌트1) 4n+2라는 공식 사용
힌트2) 31을 부르면 지기 때문에 30을 부르면 이김

 - answer를 어떻게 증가시킬까 고민하다가 띄어쓰기의 개수를 세어 입력한 숫자의 개수를 세어 answer를 증가시킴
 */
public class BR31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;                                 //1부터 31까지 숫자를 셀 변수 answer

        System.out.println("베스킨라빈스31 게임 시작");
        System.out.println();

        while (answer < 31) {                           //answer가 31보다 작을 때까지 반복

            System.out.print("컴퓨터: " + answer++);      //하나 이상 말해야 하므로 일단 answer 출력
            System.out.print(" ");

            for (int i = 1; i < 3; i++) {               //최대 3개까지 말할 수 있으므로 i는 3까지
                if (answer % 4 <= 2) {                  //주어진 힌트인 4n+2까지 말하면 무조건 이기므로
                    System.out.print(answer++);         //answer가 4n+2보다 작다면 answer를 말하고
                    System.out.print(" ");
                } else if (answer % 4 == 2){            //아니라면 멈춤
                    System.out.print(answer++);
                    break;
                }
            }
            System.out.println();

            System.out.print("나: ");                    //플레이어의 차례

            String str = sc.nextLine();                 //입력한 줄 전체를 String으로 받아줌
            int strCnt = 1;                             //입력된 숫자의 개수를 셀 변수 strCnt

            for (int i = 0; i < str.length(); i++) {    //입력된 문자열에서
                if (str.charAt(i) == ' ') {             //공백, 즉 띄어쓰기 개수를 세어 몇을 말했는지 확인
                    strCnt++;
                }
            }
            answer += strCnt;                           //말한 숫자 개수만큼 answer를 증가
        }
    }
}
