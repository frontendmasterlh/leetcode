package array.hashtable;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 word1 and word2 may be the same and they represent two individual words in the list.

 For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes", word2 = "makes", return 3.

 Note: You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            int pre = idx1;
            if (word1.equals(words[i])) {
                idx1 = i;
            }
            if (word2.equals(words[i])) {
                idx2 = i;
            }
            if (word1.equals(word2) && pre != -1 && pre != idx1) {
                distance = Math.min(distance, Math.abs(pre - idx1));
            } else if (idx1 != idx2) {
                distance = Math.min(distance, Math.abs(idx1 - idx2));
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceIII shortestWordDistanceIII = new ShortestWordDistanceIII();
        System.out.println(shortestWordDistanceIII.shortestWordDistance(words, "coding", "practice"));
        System.out.println(shortestWordDistanceIII.shortestWordDistance(words, "makes", "makes"));
    }
}
