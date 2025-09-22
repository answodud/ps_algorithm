import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for(int l : lost){
            lostList.add(l);
        }
        
        for(int r : reserve){
            if(lostList.contains(r)){
                lostList.remove(Integer.valueOf(r));
                continue;
            }
            reserveList.add(r);
        }
        
        Arrays.sort(reserve);
        
        
        for(int i = 0; i < reserve.length; i++){
            if(reserveList.contains(reserve[i])){
                if(lostList.contains(reserve[i] - 1)){
                    reserveList.remove(Integer.valueOf(reserve[i]));
                    lostList.remove(Integer.valueOf(reserve[i] - 1));
                } else if(lostList.contains(reserve[i] + 1)){
                    reserveList.remove(Integer.valueOf(reserve[i]));
                    lostList.remove(Integer.valueOf(reserve[i] + 1));
                }
            }
        }
        
        return n - lostList.size();

    }
}