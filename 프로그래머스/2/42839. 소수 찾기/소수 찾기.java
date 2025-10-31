import java.util.*;

class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;
    String numbers;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        this.numbers = numbers;
        
        dfs("", 0);
        
        return set.size();
    }
    
    public void dfs(String x, int depth){
        
        if(!x.equals("") && isPrime(Integer.valueOf(x))){
            set.add(Integer.valueOf(x));
        }
        
        if(depth >= numbers.length()){
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(x + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean isPrime(int x){
        if(x == 0 || x == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
    
}