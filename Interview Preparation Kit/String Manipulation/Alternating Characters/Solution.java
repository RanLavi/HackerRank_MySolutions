import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int alternatingCharacters(String s) {
        /* Start of my code */
        // Breaking the string into chars
        char[] c = s.toCharArray();
        // Initializing the number of deletions required
        int deletions = 0;
        // Starting from the second char, since we always check the char behind us
        for(int i=1; i < c.length; i++) {
            // Every time the char left to the current char is identical, we add one to deletions
            if(c[i]==c[i-1])
                deletions++;
        }
        return deletions;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
