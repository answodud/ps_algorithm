import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int x : reserve){
            reserveSet.add(x);
            list.add(x);
        }
        
        for(int x : lost){
            lostSet.add(x);
        }
        
        for(int i = 0; i < lost.length; i++){
            if(reserveSet.contains(lost[i])){
                reserveSet.remove(lost[i]);
                lostSet.remove(lost[i]);
            }
        }
        
        Collections.sort(list);
        
        System.out.println(lostSet);
            System.out.println(reserveSet);
            System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i);
            if(!reserveSet.contains(x)){
                continue;
            }
            
            if(lostSet.contains(x - 1)){
                lostSet.remove(x - 1);
                reserveSet.remove(x);
            }
            
            else if(lostSet.contains(x + 1)){
                lostSet.remove(x + 1);
                reserveSet.remove(x);
            }
        }
        
        answer = n - lostSet.size();
        
        return answer;
    }
}