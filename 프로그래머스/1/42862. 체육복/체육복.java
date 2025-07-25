import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        ArrayList<Integer> reserveList = new ArrayList<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        
        for(int re : reserve){
            reserveList.add(re);
            reserveSet.add(re);
        }
        
        for(int lo : lost){
            if(reserveSet.contains(lo)){
                reserveSet.remove(lo);
                continue;
            }
            lostSet.add(lo);
        }
        
        Collections.sort(reserveList);
        System.out.println(reserveList);
        for(int i = 0; i < reserveList.size(); i++){
            
            int reserve_person = reserveList.get(i);
            
            if(!reserveSet.contains(reserve_person)){
                continue;
            }
            
            if(lostSet.contains(reserve_person - 1)){
                reserveSet.remove(reserve_person);
                lostSet.remove(reserve_person - 1);
            } else if(lostSet.contains(reserve_person + 1)){
                reserveSet.remove(reserve_person);
                lostSet.remove(reserve_person + 1);
            }
        }
        System.out.println(lostSet.size());
        answer = n - lostSet.size();
        
        return answer;
    }
}