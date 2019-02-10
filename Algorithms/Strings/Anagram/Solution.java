import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int anagram(String s) {
        /* Start of my code */
        int sSize = s.length();
        // An empty string is like having two empty substrings, no changes needed 
        if(sSize == 0)
            return 0;
        // The number of characters isn't even, so we can't have anagrams
        else if(sSize % 2 == 1)
            return -1;
        else{
            // Creating a HashMap to contain characters and the number of times they appear on the first half(rounded down) of the string 
            HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
            for(int i=0; i < sSize/2; i++)
            {
                char c = s.charAt(i);
                // A character will already encountered, add 1 to value
                if (myMap.containsKey(c)){
                    myMap.put(c, myMap.get(c) + 1);
                }
                // A character we didn't encounter yet, add it as a key and set value to 1
                else{
                    myMap.put(c, 1);
                }
            }
            int changes = 0;
            // Going over the second half of the string
            for(int i=sSize/2; i < sSize; i++){
                char c = s.charAt(i);
                // A character we encountered in the first half of the sring at least the amount of times we've encountered it on the second half so far, substract 1 from value
                if (myMap.containsKey(c)) {
                    myMap.put(c, myMap.get(c) - 1);
                    // After substracting the value by 1, the character that represents the key doesn't have more appearances in the first half of the string than the second, so we remove the key
                    if(myMap.get(c)==0){
                        myMap.remove(c);
                    }
                }
                // A chracter we didn't encounter in the first half of the string as much times as in the second string, add 1 to changes   
                else {
                        changes++;
                }
            }
            return changes;
        }
    }
    /*End Of My Code */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
