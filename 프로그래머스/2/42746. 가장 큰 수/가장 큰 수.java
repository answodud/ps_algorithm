import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        
        int zero_true = 1;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != 0){
                zero_true = 0;
            }
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        for(String s : num){
            answer += s;
        }
        
        if(zero_true == 1){
            answer = "0";
        }
        
        return answer;
    }
}