package leetcode_L;

public class LongestCommonPrefix {
	private String getPrefix (String temp, String old) {
        int i=0;
        for (i =0 ; i< temp.length() && i< old.length(); i++){
            if (temp.charAt(i)!= old.charAt(i)) {
                break;
            }
        }
        return temp.substring (0,i);
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0)
            return "";
        String temp = strs[0];
        for (int i=1; i < strs.length; i++) {
            if (temp.equals("") || strs[i].length()==0){
                return "";
            }
            temp = getPrefix (temp, strs[i]);
        }
        return temp;
    }
	
	static public void main (String argv[]){
		String[] strs = {"Hello","Hell","Hers"};
		String result = new LongestCommonPrefix().longestCommonPrefix(strs);
		System.out.println(result);
	}
}
