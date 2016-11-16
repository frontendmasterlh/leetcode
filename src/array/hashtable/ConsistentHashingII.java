package array.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * create(int n, int k)
 addMachine(int machine_id) // add a new machine, return a list of shard ids.
 getMachineIdByHashCode(int hashcode) // return machine id

 There's another thought: http://blog.csdn.net/jmspan/article/details/51749521
 */
public class ConsistentHashingII {
    int n;
    int k;
    Set<Integer> ids;
    Map<Integer, List<Integer>> machines;

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static ConsistentHashingII create(int n, int k) {
        // Write your code here
        ConsistentHashingII consistentHashingII = new ConsistentHashingII();
        consistentHashingII.n = n;
        consistentHashingII.k = k;
        consistentHashingII.ids = new HashSet<>();
        consistentHashingII.machines = new HashMap<>();

        return consistentHashingII;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        Random random = new Random();
        List<Integer> randomNum = new ArrayList<>();
        for (int i = 0; i < k ; i++) {
            int shardId = random.nextInt(n);
            while (ids.contains(shardId)) {
                shardId = random.nextInt(n);
            }
            randomNum.add(shardId);
        }
        Collections.sort(randomNum);
        machines.put(machine_id, randomNum);
        return randomNum;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int distance = n + 1;
        int machine_id = 0;
        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
            int key = entry.getKey();
            List<Integer> randomNum = entry.getValue();
            for (Integer num : randomNum) {
                int d = num - hashcode;
                if (d < 0) {
                    d += n;
                }
                if (d < distance) {
                    distance = d;
                    machine_id = key;
                }
            }
        }
        return machine_id;
    }
}
