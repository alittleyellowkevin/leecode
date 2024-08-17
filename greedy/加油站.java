package greedy;

public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int start = 0;
        int i = 0;
        for (; i < gas.length; i++) {
            sum +=  gas[i] - cost[i];
            total += gas[i] -cost[i];
            if(sum < 0){
                start = i+1;
                sum = 0;
            }
        }
        if(total < 0){
            return -1;
        }
        return start;
    }
}
