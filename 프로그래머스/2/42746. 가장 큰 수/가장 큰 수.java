import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        boolean ok = false;
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0){
                ok = true;
            }
        }
        Arrays.sort(str, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        for(int i = 0; i < str.length; i++){
            answer += str[i];
        }
        
        if(ok == false){
            return "0";
        }
        return answer;
    }
}