class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초 동안 붕대 감으면서 1초에 x만큼 회복
        // t초 연속으로 붕대를 감는데 성공하면 +y
        
        int castingTime = bandage[0];
        int recoverlyPerSec = bandage[1];
        int AdditionalRecoverly = bandage[2];
        
        // 공격 시점의 전후 체력 구하기
        int[] preHealth = new int[attacks.length];
        int[] postHealth = new int[attacks.length];
        
        // 체력 초기화
        postHealth[0] = (health - attacks[0][1] > 0) ? health - attacks[0][1] : 0;
        
        if (postHealth[0] == 0) return -1;
        
        for (int i = 1; i < attacks.length; i++) {
            int time = attacks[i][0] - attacks[i - 1][0] - 1;
            int curHealth = Math.min(postHealth[i - 1] + ((int) time / castingTime) * AdditionalRecoverly + time * recoverlyPerSec, health);
            postHealth[i] = (curHealth - attacks[i][1] > 0) ? curHealth - attacks[i][1] : 0;
            if (postHealth[i] == 0) return -1;
        }
        
        return postHealth[attacks.length - 1];
    }
}