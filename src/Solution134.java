public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            if(gas[i] < cost[i]) continue;
            int j = i + 1 >= gas.length ? 0 : i + 1;
            int box = gas[i] - cost[i];
            for(; j != i; j = j + 1 >= gas.length ? 0 : j + 1){
                box += gas[j] - cost[j];
                if(box < 0) break;
            }
            if(j == i) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution134 solu = new Solution134();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(solu.canCompleteCircuit(gas, cost));
    }

}
