package leetcode_M;
import java.util.*;


public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1==null || num2==null || num1.length()==0 || num2.length()==0)
            return "0";//Normal corner case
        num1 = new StringBuilder (num1).reverse().toString();//Reverse 2 strings.
        num2 = new StringBuilder (num2).reverse().toString();
        int[] d = new int[num1.length() + num2.length() +1];//Create an array that stores the result.
        for (int i=0; i<num1.length(); i++) {
            for (int j=0; j<num2.length(); j++) {
                d[i+j] = d[i+j] + (num1.charAt(i)-'0')*(num2.charAt(j)-'0');//Calculate the result.
            }
        }
        
        StringBuilder sb = new StringBuilder ();//Transform the result into stringbuilder type.
        for (int i=0; i<d.length; i++) {
            int digit = d[i]%10;
            int carry = d[i]/10;
            if (i+1 < d.length)
                d[i+1] += carry;
            sb.insert(0, digit);//Insert to the front of the string.
        }
        int start = 0;
        while (sb.charAt(start)=='0' && sb.length() > 1){//Allow the length of the 0 to be 1.
            // start++;
            sb.deleteCharAt(0);//Delete the first element.
        }
        return sb.toString();//Change the type.
    }
    
    public static void main (String argv[]){
    	System.out.println(new MultiplyStrings().multiply("123", "10"));
    	System.out.println(new MultiplyStrings().multiply("1232536354357634", "45"));
    	System.out.println(new MultiplyStrings().multiply("123", "0"));
    }
}
