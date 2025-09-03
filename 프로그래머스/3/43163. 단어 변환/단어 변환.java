import java.util.*;

class Solution {
    class Word {
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
        boolean x = false;
        
        for(String word : words){
            if(word.equals(target)){
                x = true;
                break;
            }
        }
        
        if(!x){
            return 0;
        }
        
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(0, begin));
        while(!q.isEmpty()){
            Word cur = q.poll();
            System.out.println(cur.step + "번째 단어 " + cur.word);
            if(cur.word.equals(target)){
                return cur.step;
            }
            for(int i = 0; i < words.length; i++){
                if(oneDiff(cur.word, words[i]) && !visited[i]){
                    q.offer(new Word(cur.step + 1, words[i]));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public boolean oneDiff(String cur, String next){
        int cnt = 0;
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) != next.charAt(i)){
                cnt++;
            }
        }
        if(cnt == 1){
            return true;
        } else {
            return false;
        }
    }
    
}