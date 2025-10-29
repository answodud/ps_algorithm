import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder ans = new StringBuilder();
        String[] str = s.split(" ", -1); // 공백 유지
        
        for (String splitS : str) {
            StringBuilder sb = new StringBuilder();
            int i = 0;

            for (char c : splitS.toCharArray()) {
                if (i % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                i++;
            }
            ans.append(sb).append(" ");
        }

        return ans.substring(0, ans.length() - 1);
    }
}
