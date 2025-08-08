import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int cnt = friends.length;
        int[][] gift_list = new int[cnt][cnt + 1]; // 주고받은 선물 횟수 저장용도
        HashMap<String, Integer> friends_list = new HashMap<>(); // 이름, 순서 저장 용도
        
        for(int i = 0; i < cnt; i++){
            friends_list.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String gift = gifts[i];
            String[] str = gift.split(" ");
            int x = friends_list.get(str[0]);
            int y = friends_list.get(str[1]);
            gift_list[x][y]++;
            gift_list[x][cnt] += 1;
            gift_list[y][cnt] -= 1;
        }
        
        int[] gift_num = new int[cnt];
        
        for(int i = 0; i < cnt; i++){
            for(int j = 0; j < cnt; j++){
                if(gift_list[i][j] > gift_list[j][i]){
                    gift_num[i]++;
                } else if(gift_list[i][j] < gift_list[j][i]){
                    gift_num[j]++;
                } else{
                    if(gift_list[i][cnt] > gift_list[j][cnt]){
                        gift_num[i]++;
                    } else if(gift_list[i][cnt] < gift_list[j][cnt]){
                        gift_num[j]++;
                    }
                }
            }
        }
        
        for(int x : gift_num){
            answer = Math.max(answer, x);    
        }
        
        return answer / 2;
    }
}