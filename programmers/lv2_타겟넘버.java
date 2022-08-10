package programmers.lv2;

/* lv2_타겟넘버
numbers에 들어있는 음이 아닌 정수를 가지고 적절히 더하거나 빼서 target 넘버를 만들 수 있는 방법의 수를 구하여라

입출력 예
numbers	            target	return
[1, 1, 1, 1, 1]	    3	    5
[4, 1, 2, 1]	    4	    2
 */
public class lv2_타겟넘버 {
    static int answer, len;     //변수 answer와 len을 static으로 선언

    public void DFS(int[] numbers, int target, int L, int hap) {
        if(L == len) {              //현재 레벨 L이 len과 같으면, 즉 모든 숫자를 다 사용했다면
            if(target == hap) {     //target과 숫자들을 계산한 값과 비교하여
                answer++;           //같다면 answer 증가
                return;             //void형에서 return은 메서드가 재귀호출 하는 것을 중단해줌
            }
        } else {                    //L과 len이 같지 않다면
            DFS(numbers, target, L + 1, hap + numbers[L]);  //각각 L을 증가시켜주고
                                                                    //하나는 L번째 원소를 더해 DFS 호출
            DFS(numbers, target, L + 1, hap - numbers[L]);  //하나는 L번째 원소를 빼 DFS 호출
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        answer = 0;
        len = numbers.length;                   //배열 numbers의 길이를 변수 len(length)에 대입

        lv2_타겟넘버 s = new lv2_타겟넘버();
        s.DFS(numbers, target, 0, 0);   //DFS 메서드 호출

        System.out.println(answer);             //answer 출력
    }
}
