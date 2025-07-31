import java.util.*;

class Solution {
    
    class Word {
        
        String word;
        int step;
        
        Word(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        int answerIndex = -1;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                answerIndex = i;
            }
        }
        
        answer = bfs(begin, target, words, answerIndex);

        return answer;
    }
    
    public int bfs(String begin, String target, String[] words, int answerIndex){
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            Word cur = q.poll();
            
            if(cur.word.equals(target)){
                return cur.step;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isOneDiff(words[i], cur.word)){
                    visited[i] = true;
                    q.offer(new Word(words[i], cur.step + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isOneDiff(String word, String target){
        int cnt = 0;
        for(int i = 0; i < word.length();  i++){
            if(word.charAt(i) != target.charAt(i)){
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
        }
        
        return true;
        
    }
}