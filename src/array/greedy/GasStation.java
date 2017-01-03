package array.greedy;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        int total = 0;
        int sum = 0;
        int j = -1; // Initialize the j to -1;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                j = i;
            }
        }
        if (total < 0) {
            return -1;
        }
        return j + 1;
    }
}
