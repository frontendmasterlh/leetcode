package leetcode_G;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length==0 || cost.length==0)
            return -1;
        int sum=0, total=0, idx = 0;
        for (int i=0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum <0) {
                idx = (i+1) % gas.length;
                sum = 0;
            }
        }
        if (total <0)
            return -1;
        else 
            return idx;
    }
	
	static public void main (String[] argv) {
		;
	}
}
