public class leecode_3494_酿造药水需要的最少总时间 {
    public static void main(String[] args) {

    }
    public long minTime(int[] skill, int[] mana) {
        // 本质上是计算巫师 0 的 最小开始时间
        long minStartTime = 0;
        long[] waitSkill = new long[skill.length];
        for(int i=1; i<skill.length; i++){
            waitSkill[i] = skill[i-1] + waitSkill[i-1];
        }
        long[] finishTime = new long[skill.length];
        for(int i=0; i<mana.length-1; i++) {
            finishTime[0] = minStartTime + (long)skill[0] * mana[i];
            minStartTime = Math.max(finishTime[0], minStartTime);
            for(int j=1; j<skill.length; j++){
                finishTime[j] = finishTime[j-1] + (long)skill[j] * mana[i];
                minStartTime = Math.max(finishTime[j] - (mana[i+1] * waitSkill[j]), minStartTime);
            }
        }
        for(int i=0; i<skill.length; i++){
            minStartTime += (long)skill[i] * mana[mana.length-1];
        }
        return minStartTime;
    }

}
