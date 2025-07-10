import java.util.*;
class Solution {
    
    boolean[] visited;
    HashSet<Integer> hashSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        dfs(numbers, "", 0);
        
        for(int n : hashSet){
            if(isPrime(n)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String numbers, String cur, int depth){
        if(depth > numbers.length()){
            return;
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                hashSet.add(Integer.valueOf(cur + numbers.charAt(i)));
                dfs(numbers, cur + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}