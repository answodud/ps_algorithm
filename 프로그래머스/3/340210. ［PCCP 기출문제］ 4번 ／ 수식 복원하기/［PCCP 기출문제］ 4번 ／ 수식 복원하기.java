import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        
        int max_n = 0;
        ArrayList<String> list = new ArrayList<>();
        
        for(String ex : expressions){
            for(char c : ex.toCharArray()){
                if(!Character.isDigit(c)){
                    continue;
                }
                int num = c - '0';
                max_n = Math.max(num, max_n);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = max_n + 1; i <= 9; i++){
            set.add(i);
        }
        
    
        for(String ex : expressions){
            String[] str = ex.split(" ");
            // str[0] = x1, str[1] = op, str[2] = x2, str[4] = ans
            if(!ex.contains("X")){
                for(int i = max_n + 1; i <= 9; i++){
                    int v1 = Integer.parseInt(str[0], i);
                    int v2 = Integer.parseInt(str[2], i);
                    int ans = Integer.parseInt(str[4], i);
                    if(str[1].equals("+")){
                        if(v1 + v2 != ans){
                            set.remove(i);
                        }
                    } else {
                        if(v1 - v2 != ans){
                            set.remove(i);
                        }
                    } 
                }
            } else {
                list.add(ex);
            }
        }
        
         String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            String ex = list.get(i);
            String[] str = ex.split(" ");
            HashSet<String> ansSet = new HashSet<>();
            for(int base : set){
                int v1 = Integer.parseInt(str[0], base);
                int v2 = Integer.parseInt(str[2], base);
                if(str[1].equals("+")){
                    ansSet.add(Integer.toString(v1 + v2, base));
                } else {
                    ansSet.add(Integer.toString(v1 - v2, base));
                }
                
            }
            String[] equalSplit = ex.split("=");
            String real = equalSplit[0] + "= ";
            if(ansSet.size() > 1){
                real += "?";
            } else {
                real += ansSet.iterator().next();
            }
            answer[i] = real;
        }
        
        return answer;
    }

    
}