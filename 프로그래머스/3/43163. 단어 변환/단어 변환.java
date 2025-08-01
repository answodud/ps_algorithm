import java.util.*;

class Solution {
    
    class Word{
        int step;
        String word;
        
        Word(int step, String word){
            this.step = step;
            this.word = word;
        }
    }
    
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();

        q.offer(new Word(0, begin));
        
        while(!q.isEmpty()){
            Word cur = q.poll();
            if(cur.word.equals(target)){
                return cur.step;
            }
            
            for(int i = 0; i < words.length; i++){
                if(oneDiff(words[i], cur.word) && !visited[i]){
                    visited[i] = true;
                    q.offer(new Word(cur.step + 1, words[i]));
                }
            }
        }
        
        
        return answer;
    }
    
    
    public boolean oneDiff(String target, String word){
        int cnt = 0;
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != word.charAt(i)){
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
        }
        return true;
    }
}