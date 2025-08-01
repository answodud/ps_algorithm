class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        
        answer = sb.substring(0, sb.length() - k);
        return answer;
    }
}