import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> genreSong = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(genreSong.getOrDefault(genres[i], 0) != 0){
                genreSong.replace(genres[i], genreSong.get(genres[i]) + plays[i]);
            } else {
                genreSong.put(genres[i], plays[i]);
            }
        }
        
        List<String> mostGenres = new ArrayList(genreSong.keySet());
        Collections.sort(mostGenres, (v1, v2) -> genreSong.get(v2) - genreSong.get(v1));
        
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
                if(map.containsKey(genres[i])){
                    map.get(genres[i]).put(i, plays[i]);
                } else {
                    HashMap<Integer, Integer> sMap = new HashMap<>();
                    sMap.put(i, plays[i]);
                    map.put(genres[i], sMap);
                }
            }
        
        List<Integer> answerList = new ArrayList<>();
        
        for(String g : mostGenres){
            HashMap<Integer, Integer> sMap = map.get(g);
            List<Integer> music = new ArrayList(sMap.keySet());
            Collections.sort(music, (v1, v2) -> sMap.get(v2) - sMap.get(v1));
            answerList.add(music.get(0)); // 제일 많이 재생된 곡 넣기
                if(music.size() > 1){
                    answerList.add(music.get(1));
                }
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
        
    }
}