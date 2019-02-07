import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static String isValid(String s) {
        /* Start of my code */
        // Creating a hashmap for charcters and number of appearances
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>(); 
        for(char c: s.toCharArray()) {
            // Charcter already exists, plus appearances
            if (myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c) + 1);
            }
            // Character didn't appear before, add to keys and set value to 1
            else{
                myMap.put(c,1);
            }
        }
        // Default number of appeaarances
        int num1 = -1;
        int num2 = -1;
        // Number of characters with the same number of appearances
        int count1 = 0;
        int count2 = 0;
        for (Integer value : myMap.values()) {
            // No value for appearances was set yet for num1
            if(num1==-1){
                num1 = value;
                count1 = 1;
            }
            // Number of appearances is different from num1 and no value for appearances was set yet for num2
            else if(num1!=value && num2==-1){
                num2 = value;
                count2 = 1;
            }
            // Number of appearances is the same as num1 and only one character (or none) appears a different number of times
            else if(num1==value && count2 <=1)
                count1++;
            // Number of appearances is the same as num2 and only one character (or none) appears a different number of times
            else if(num2==value && count1 <=1)
                count2++;
            // Different number of appearances from what was set for num1 and num2, or same number of appearances as num1 with count2>1 or same number of appearances as num2 with count1>1
            else
                return "NO";
        }
        // Number of appearacnes on both num1 and num2 is greatr than 1 and the difference between the number of appearances is greater than 1
        if(num1>1 && num2>1 && Math.abs(num1-num2) > 1)
            return "NO";
        // More than one character(count1>1) appeared once(num1==1) and at least one character appeared more than once
        else if(num1==1 && count1>1 && num2>1 && count2!=-1)
            return "NO";
        // More than one character(count2>1) appeared once(num2==1) and at least one character appeared more than once
        else if(num2==1 && count2>1 && num1>1 && count1!=-1)
            return "NO";
        // Otherwise, if we haven't returned NO yet, the string is valid
        else
            return "YES";
    }
    /* End of my code */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
