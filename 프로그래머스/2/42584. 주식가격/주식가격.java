import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length - 1; i++){
            int price = prices[i];
            int time = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(price <= prices[j]){
                    time++;
                } else {
                    time++;
                    break;
                }
            }
            answer[i] = time;
        }
        
        return answer;
    }
}