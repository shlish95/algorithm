package programmers.kakao_blind_recruitment2021;

/* 신규 아이디 추천
회원 가입시 규칙에 맞지 않는 아이디를 입력하면 규칙에 맞는 아이디를 출력하여라
7단계의 규칙은 다음과 같음
    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

입출력 예시
new_id	                        result
"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
"z-+.^."	                    "z--"
"=.="	                        "aaa"
"123_.def"	                    "123_.def"
"abcdefghijklmn.p"	            "abcdefghijklmn"
 */
public class lv1_신규_아이디_추천 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String answer = new_id.toLowerCase();       //new_id를 소문자로 바꾸어 answer에 대입(1단계)

        answer = answer.replaceAll("[^a-z0-9-_.]", "");
                                    //a-z, 0-9, -, _, . 이외의 것은 제거(2단계)

        answer = answer.replaceAll("[.]{2,}", ".");
                                    //"."이 2개 이상 연속되어 있으면 "." 하나로 바꿔줌(3단계)

        answer = answer.replaceAll("^[.]|[.]$", "");
                                    //맨 앞 또는 맨 뒤가 "."이라면 제거(4단계)

        if(answer.equals("")) {     //아이디가 빈 문자열이라면 "a"를 대입(5단계)
            answer = "a";
        }

        if(answer.length() > 15) {  //아이디가 16자 이상이면 15자까지만 잘라줌
            answer = answer.substring(0, 15);

            answer = answer.replaceAll("[.]$", "");
        }                               //15번째 문자가 "."라면 제거(6단계)

        if(answer.length() < 3) {   //문자 길이가 2자 이하라면 마지막 문자를 3자가 될 때까지 더해줌
            String tmp = answer.substring(answer.length() - 1);

            while(answer.length() < 3) {
                answer = answer + tmp;
            }
        }

        System.out.println(answer);     //answer 출력
    }
}
