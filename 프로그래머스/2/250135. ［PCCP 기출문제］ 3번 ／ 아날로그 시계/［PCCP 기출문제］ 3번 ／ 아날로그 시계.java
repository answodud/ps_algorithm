class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        // 각속도 이용
        
        // 시간은 초단위로 변경해주기
        double start = h1 * 60 * 60 + m1 * 60 + s1;
        double end = h2 * 60 * 60 + m2 * 60 + s2;
        
        if(hour(start) == sec(start) || min(start) == sec(start)){
            answer++;
        }
        
        for(double t = start + 1; t <= end; t++){
            double prevH = hour(t - 1);
            double prevM = min(t - 1);
            double prevS = sec(t - 1);
            
            double nowH = hour(t);
            double nowM = min(t);
            double nowS = sec(t);
    
            if(nowH == 0){
                nowH = 360.0;
            }
            if(nowM == 0){
                nowM = 360.0;
            }
            if(nowS == 0){
                nowS = 360.0;
            }
        
            if(prevH > prevS && nowS >= nowH){
                answer++;
            }
            if(prevM > prevS && nowS >= nowM){
                answer++;
            }
            if(nowS == nowM && nowM == nowH){
                answer--;
            }
            

        }

        
        return answer;
    }
    
    // 초침은 초당 6도
    public double sec(double t){
        return (t * 6.0) % 360.0;
    }
    
    // 분침은 0.1도
    public double min(double t){
        return (t * 0.1) % 360.0;
    }
    
    // 시침은 1/120도
    public double hour(double t){
        return (t / 120.0) % 360.0;
    }
}