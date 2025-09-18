import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 노래 횟수 저장 용도
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(map.containsKey(genres[i])){
                map.replace(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }
        
        // 인기 장르 순으로 정렬(내림차순)
        List<String> topGenres = new ArrayList(map.keySet());
        Collections.sort(topGenres, (v1, v2) -> map.get(v2) - map.get(v1));
        
        List<Integer> answer = new ArrayList<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            music.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }
        
        for(String gen : topGenres){
            if(music.containsKey(gen)){
                HashMap<Integer, Integer> sMap = music.get(gen);
                List<Integer> cnt = new ArrayList(sMap.keySet());
                Collections.sort(cnt, (v1, v2) -> sMap.get(v2) - sMap.get(v1));
                answer.add(cnt.get(0));
                if(sMap.size() > 1){
                    answer.add(cnt.get(1));
                }
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}