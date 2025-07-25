import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++){
            int cur = 0;
            for(int k = 0; k < i; k++){
                cur = cur * 10 + N;
            }
            dp.get(i).add(cur);
            
            for(int j = 0; j < i; j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i - j)){
                        dp.get(i).add(a + b);
                         dp.get(i).add(a - b);
                         dp.get(i).add(a * b);
                         if(b != 0){
                             dp.get(i).add(a / b);
                         }
                    }
                }
            }
            
            if(dp.get(i).contains(number)){
                return i;
            }
            
        }
        
        return -1;
    }
}