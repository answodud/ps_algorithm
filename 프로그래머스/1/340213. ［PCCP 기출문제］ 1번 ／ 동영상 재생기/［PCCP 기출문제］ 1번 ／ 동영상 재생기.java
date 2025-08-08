import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int V = toSec(video_len);
        int cur = toSec(pos);
        int ops = toSec(op_start);
        int ope = toSec(op_end);
        
        for(String command : commands){
            if(cur >= ops && cur <= ope){
                cur = ope;
            }
            if(command.equals("prev")){
                if(cur < 10){
                    cur = 0;
                } else {
                    cur -= 10;
                }
                if(cur >= ops && cur <= ope){
                    cur = ope;
                }
            } else {
                if(cur + 10 > V){
                    cur = V;
                } else {
                    cur += 10;
                }
                if(cur >= ops && cur <= ope){
                    cur = ope;
                }
            }
        }
        
        return mmss(cur);
    }
    
    public int toSec(String s){
        String mmss[] = s.split(":");
        return Integer.valueOf(mmss[0]) * 60 + Integer.valueOf(mmss[1]);
    }
    
    public String mmss(int x){
        int mm = x / 60;
        int ss = x % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}