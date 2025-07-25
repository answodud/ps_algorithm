import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        ArrayList<Integer> reserveList = new ArrayList<>();
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        
        for(int x : reserve){
            reserveSet.add(x);
            reserveList.add(x);
        }
        
        for(int x : lost){
            lostSet.add(x);
        }
        
        Collections.sort(reserveList);
        
        for(int i = 0; i < lost.length; i++){
            if(reserveSet.contains(lost[i])){
                reserveSet.remove(lost[i]);
                lostSet.remove(lost[i]);
            }
        }
        
        for(int i = 0; i < reserveList.size(); i++){
            int reserve_person = reserveList.get(i);
            
            if(!reserveSet.contains(reserve_person)){
                continue;
            }
            
            else if(lostSet.contains(reserve_person - 1)){
                lostSet.remove(reserve_person - 1);
                reserveSet.remove(reserve_person - 1);
            }
            
            else if(lostSet.contains(reserve_person + 1)){
                lostSet.remove(reserve_person + 1);
                reserveSet.remove(reserve_person + 1);
            }
            
        }
        
        answer = n - lostSet.size();
        
        return answer;
    }
}