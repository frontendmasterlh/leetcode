package array.strings;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */
public class FlipGameII {

    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return helper(s.toCharArray());
    }

    private boolean helper(char[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';

                boolean win = helper(arr);

                arr[i] = '+';
                arr[i + 1] = '+';

                if (!win) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FlipGameII f = new FlipGameII();
        System.out.println(f.canWin("++++"));
    }
}
