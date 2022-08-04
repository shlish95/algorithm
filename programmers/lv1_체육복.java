package programmers.lv1;

import java.util.Arrays;

/* 체육복

 */
public class lv1_체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int answer = 0;

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = answer; i < lost.length; i++) {
            for(int j = answer; j < reserve.length; j++) {
                if(lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        System.out.println(answer += (n - lost.length));
    }
}
