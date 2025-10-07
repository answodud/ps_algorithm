class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int cur = toSec(pos);
        int start = toSec(op_start);
        int end = toSec(op_end);
        int len = toSec(video_len);
        
        if(cur >= start && cur <= end){
            cur = end;
        }
        
        for(String command : commands){
            if(command.equals("prev")){
                if(cur - 10 < 0){
                    cur = 0;
                } else {
                    cur = cur - 10;
                }
            } else if(command.equals("next")){
                if(cur + 10 > len){
                    cur = len;
                } else {
                    cur = cur + 10;
                }
            }
             if(cur >= start && cur <= end){
                    cur = end;}
        }
        
        return toStr(cur);
    }
    
    public int toSec(String time){
        String[] str = time.split(":");
        int sec = 0;
        sec += Integer.valueOf(str[0]) * 60;
        sec += Integer.valueOf(str[1]);
        return sec;
    }
    
    public String toStr(int time){
        int min = time / 60;
        int sec = time % 60;
        return String.format("%02d:%02d", min, sec);
    }
}