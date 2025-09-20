import java.util.*;

class Solution {
    
    String numbers;
    boolean[] visited;
    int answer = 0;
    ArrayList<Integer> list = new ArrayList<>();
    
    public int solution(String numbers) {
        
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        dfs("", 0);
        
        return answer;
    }
    
    public void dfs(String cur, int depth){
        if(cur.length() > 0){
            int x = Integer.valueOf(cur);
            if(isPrime(x)){
                if(!list.contains(x)){
                    answer++;
                    list.add(x);
                }
            }
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }   
    }
    
    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}