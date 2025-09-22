class Solution {
    public int solution(String name) {
        int answer = 0;
        int cnt = 0;
        
        // 상하이동
        for(int i = 0; i < name.length(); i++){
            char x = name.charAt(i);
            cnt += Math.min(x - 'A', 'Z' - x + 1);
        }
        int n = name.length();
        
        int move = n - 1;
        // 좌우이동
        for(int i = 0; i < name.length(); i++){
            int next = i + 1;
            // 다음 이동 위치 파악하기
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }
            int goback = i + i + (n - next);
            int backgo = (n - next) + (n - next) + i;
            move = Math.min(move, Math.min(goback, backgo));
        }
        
        cnt += move;
        
        return cnt;
    }
}