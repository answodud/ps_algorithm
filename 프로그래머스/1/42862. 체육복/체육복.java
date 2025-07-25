import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int re : reserve){
            reserveSet.add(re);
            list.add(re);
        }
        
        for(int lo : lost){
            lostSet.add(lo);
        }
        
        
        for(int i = 0; i < lost.length; i++){
            if(reserveSet.contains(lost[i])){
                reserveSet.remove(lost[i]);
                lostSet.remove(lost[i]);
            }
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++){
            int p = list.get(i);
            if(!reserveSet.contains(p)){
                continue;
            }
            if(lostSet.contains(p - 1)){
                lostSet.remove(p - 1);
                reserveSet.remove(p);
            } else if(lostSet.contains(p + 1)){
                lostSet.remove(p + 1);
                reserveSet.remove(p);
            }
        }
        
        answer = n - lostSet.size();
        
        return answer;
    }
}