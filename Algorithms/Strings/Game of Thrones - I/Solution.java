import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static String gameOfThrones(String s) {
         /* Start of my code */
        // Creating a hashmap for charcters and number of appearances
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>(); 
        // Breaking the string into chracters
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
        // Count how many characters have an odd number of appearances
        int count = 0;
        for (Integer value : myMap.values()) {
            if(value % 2 == 1)
                count++;
        }
        // We can have one character appear in an odd number, since if the string has an odd number of characters, then one extra character should be in the middle. If the string has an even number of characters, then count can't be 1 anyway, it will have to be even
        if(count > 1)
            return "NO";
        return "YES";
    }
    /* End of my code */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
