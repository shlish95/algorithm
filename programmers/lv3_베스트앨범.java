package programmers.lv3;

import java.util.*;

/* 베스트앨범
장르 별 가장 많이 재생된 노래를 두 곡씩 모아 베스트 앨범을 출시하려 한다.
1. 속한 노래가 많이 재생된 장르 먼저 수록
2. 장르 내에서 많이 재생된 노래를 먼저 수록
3. 장르 내에서 재생 횟수가 같은 노래 중 고유 번호가 낮은 노래를 먼저 수록

입출력 예
genres	                                        plays	                    return
["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 */
public class lv3_베스트앨범 {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();                         //정답을 담을 ArrayList ans
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};  //각 노래의 장르를 나타낸 배열 genres
        int[] plays = {500, 600, 150, 800, 2500};                           //각 노래의 재생 횟수를 나타낸 배열 plays
        HashMap<String, Integer> map = new HashMap<>();                     //각 장르별 노래의 총 횟수를 나타낼 해쉬 맵 map

        for(int i = 0; i < genres.length; i++) {        //장르를 키 값으로 각 장르 별 재생 횟수를 밸류로 map에 저장
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //entryList를 생성하여 map을 밸류 값을 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {

                return obj2.getValue() - obj1.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {        //오름차순으로 정렬된 entryList 각 객체를 반복
            ArrayList<Integer> arr = new ArrayList<>();             //장르 별로 각 곡의 재생 횟수를 입력할 arr 생성

            for (int i = 0; i < genres.length; i++) {               //entryList의 객체와 배열 genres의 각 원소를 비교
                if (entry.getKey().equals(genres[i])) {             //장르가 같다면 arr에 추가
                    arr.add(plays[i]);
                }
            }

            Collections.sort(arr, Collections.reverseOrder());      //장르 별 각 곡의 재생 횟수를 내림차순으로 정렬

            if (arr.size() >= 2) {                                  //장르 별로 두 곡씩만 넣을 수 있으므로
                for (int i = 0; i < 2; i++) {                       //해당 장르의 총 노래가 두 곡이 넘는다면

                    for (int j = 0; j < plays.length; j++) {        //ans에 arr의 두 번째 값까지 입력
                        if(arr.get(i).equals(plays[j])){
                            ans.add(j);
                            plays[j] = - 1;
                            break;
                        }
                    }
                }
            } else {                                                //해당 장르의 총 노래가 한 곡이라면
                for (int i = 0; i < plays.length; i++) {            //그 노래의 재생 횟수 ans에 입력
                    if (arr.get(0).equals(plays[i])) {
                        ans.add(i);
                        plays[i] = -1;
                        break;
                    }
                }
            }
        }

        for (int i : ans) {                                         //ans 출력
            System.out.println(i);
        }
    }
}
