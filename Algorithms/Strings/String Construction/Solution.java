import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int stringConstruction(String s) {
        /* Start of my code */
        // Initialzing cost
        int cost=0;
        // Creating a hashmap for charcters and number of appearances
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>(); 
        // Dividing the string to chars
        for(char c: s.toCharArray()) {
            // Charcter doesn't exist in p
            if (!(myMap.containsKey(c))) {
                // Now that we add it, it means that next time we'll be able to use it for no cost
                myMap.put(c,1);
                // Add 1 to cost since character didn't appear in p
                cost++;
            }
        }
        return cost;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = stringConstruction(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
