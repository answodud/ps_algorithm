import java.util.*;

class Solution {
    String numbers;
    boolean[] visited;
    HashSet<Integer> hashSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        
        int[] num = new int[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            num[i] = Integer.valueOf(numbers.charAt(i));
        }
        
        dfs("");
        
        
        return hashSet.size();
    }
    
    public void dfs(String cur){
        if(cur.length() > 0){
            int x = Integer.parseInt(cur);
        if(isPrime(x)){
            hashSet.add(x);
        }
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur + numbers.charAt(i));
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