class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int minX = n - 1;
        for(int i = 0; i < n; i++){
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }
            int goback = i * 2 + n - next;
            int backgo = (n - next) * 2 + i;
            minX = Math.min(minX, Math.min(goback, backgo));
        }
        
        answer += minX;
        
        return answer;
    }
}