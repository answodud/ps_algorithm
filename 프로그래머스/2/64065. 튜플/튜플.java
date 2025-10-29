import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        
        s = s.substring(1, s.length() - 1);
        String[] str = s.split("},");
        
        str[str.length - 1] = str[str.length - 1].replaceAll("\\}$", "");
        for(int i = 0; i < str.length; i++){
            str[i] = str[i].substring(1, str[i].length());
        }
        
        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());
        
        int x = str.length;
        int[] answer = new int[x];
        answer[0] = Integer.valueOf(str[0]);
        HashSet<Integer> set = new HashSet<>();
        set.add(answer[0]);
        for(int i = 1; i < str.length; i++){
            String[] arr = str[i].split(",");
            for(String a : arr){
                int y = Integer.valueOf(a);
                if(set.contains(y)){
                    continue;
                } else {
                    set.add(y);
                    answer[i] = y;
                }
            }
        }
        
        
        
        
        return answer;
    }
}