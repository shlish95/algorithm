package programmers.lv1;

import java.util.HashSet;

/* 폰켓몬
연구실에 있는 N마리의 폰켓몬 N/2마리를 가져갈 수 있을 때, 가져갈 수 있는 폰켓몬 종류 수의 최댓값을 구하여라
폰켓몬의 종류 번호가 담긴 배열 nums가 주어짐

입출력 예시
nums	        result
[3,1,2,3]	    2
[3,3,3,2,2,4]	3
[3,3,3,2,2,2]	2
 */
public class lv1_폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {     //헤쉬셋 set에 폰켓몬 종류 번호를 담아 중복을 제거
            set.add(i);
        }

        if (nums.length / 2 >= set.size()) {    //N/2가 set의 크기보다 크거나 같다면
            answer = set.size();                //set의 크기만큼의 종류 수를 가져갈 수 있음
        } else {                                //N/2가 set의 크기보다 작다면
            answer = nums.length / 2;           //N/2만큼의 종류 수를 가져갈 수 있음
        }
        System.out.println(answer);
    }
}
