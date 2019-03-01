import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int makeAnagram(String a, String b) {
        /* Start of my code */
        int bigSize = a.length();
        int smallSize = b.length();
        // Checking which string is longer
        if(bigSize < smallSize){
            int temp = bigSize;
            bigSize = smallSize;
            smallSize = temp;
            // If the shorter string is empty, number of deletions will be the length of the longer string
            if(smallSize == 0)
                return bigSize;
            // Creating a HashMap to contain characters and the number of times they appear on the longer string 
            HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
            for(int i=0; i < bigSize; i++)
            {
                char c = b.charAt(i);
                // A character will already encountered, add 1 to value
                if (charCount.containsKey(c)){
                    charCount.put(c, charCount.get(c) + 1);
                }
                // A character we didn't encounter yet, add it as a key and set value to 1
                else{
                    charCount.put(c, 1);
                }
            }
            int deletions = 0;
            // Going over the shorter string
            for(int i=0; i < smallSize; i++){
                char c = a.charAt(i);
                // A character we encountered in the longer string at least the amount of times we've encountered it on the shorter string so far, substract 1 from value
                if (charCount.containsKey(c)) {
                    charCount.put(c, charCount.get(c) - 1);
                    // After substracting the value by 1, the character that represents the key doesn't have more appearances in the longer string than the shorter, so we remove the key
                    if(charCount.get(c)==0){
                        charCount.remove(c);
                    }
                }
                // A chracter we didn't encounter in the longer string as much times as in the shorter string, add 2 to deletions   
                else {
                        deletions += 2;
                }
            }
            // Adding to deletions the difference in length betweeen the strings
            deletions += Math.abs(bigSize - smallSize);
            return deletions;
        }
        else{
            if(smallSize == 0)
                return bigSize;
            HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
            for(int i=0; i < bigSize; i++)
            {
                char c = a.charAt(i);
                if (charCount.containsKey(c)){
                    charCount.put(c, charCount.get(c) + 1);
                }
                else{
                    charCount.put(c, 1);
                }
            }
            int deletions = 0;
            for(int i=0; i < smallSize; i++){
                char c = b.charAt(i);
                if (charCount.containsKey(c)) {
                    charCount.put(c, charCount.get(c) - 1);
                    if(charCount.get(c)==0){
                        charCount.remove(c);
                    }
                } 
                else {
                        deletions += 2;
                }
            }
            deletions += Math.abs(bigSize - smallSize);
            return deletions;
        }
    }
    /*End Of My Code */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
