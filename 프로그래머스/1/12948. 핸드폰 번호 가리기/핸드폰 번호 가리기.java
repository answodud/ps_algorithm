class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int x = phone_number.length();
        String s = phone_number.substring(x - 4, x);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < x - 4; i++){
            sb.append("*");
        }
        
        return sb + s;
    }
}