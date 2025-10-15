class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int t = 0; // 시간
        int success = 0; // 연속 성공 시간
        int i = 0; // attacks 인덱스
        int max_health = health; // 최대 체력
        
        while(i < attacks.length){
            t++;
            // 공격받았을 경우
            if(attacks[i][0] == t){
                // System.out.println("공격받음 " + attacks[i][0] + "초에 " + attacks[i][1] + "만큼");
                success = 0; // 연속성공시간 초기화
                health -= attacks[i][1]; // 피해량만큼 체력 깎임
                
                i++;
                if(health <= 0){
                    return -1;
                }
            } else {
                success++;
                health += bandage[1];
                if(success == bandage[0]){
                    health += bandage[2];
                    success = 0;
                }
                if(health >= max_health){
                    health = max_health;
                }
                // System.out.println("붕대 감은지 " + success + "초 됨");
            }
            // System.out.println("현재 체력 " + health);
        }
        
        // System.out.println(health);
        
        return health;
    }
}