import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int designerPdfViewer(int[] h, String word) {
        /* Start of my code */
        // Initializing max height of a letter
        int max = 0;
        // Breaking the string into chars
        for(char c: word.toCharArray()){
            // Convert char to ascii
            int num = (int)c;
            // Lowercase English letters start from 97 at the ascii table, so we check if the height of current letter is higher than the current max height, if so, change current max accordingly
            if(h[num-97]>max)
                max=h[num-97];
        }
        // Return max height multiplied with the word's length
        return max*word.length();
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
