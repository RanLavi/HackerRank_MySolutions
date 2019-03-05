import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int palindromeIndex(String s) {
        /* Start of my code */
        // Boolean variable to show if the original string is a palindrome
        boolean pali = true;
        // Left(starting) index
        int i = 0;
        // Right(ending) index 
        int j = s.length() - 1;
        // Run until getting to the middle of the string
        for(;i < j;i++, j--){
            // If left character isn't the same as the right character
            if(s.charAt(i) != s.charAt(j)){
                // Save left character's index
                int indexi = i;
                // Save right character's index
                int indexj = j;
                // Check if the substring from i+1 to j is a palindrome
                for(i = i+1; i < j;i++, j--){
                    // Substring isn't a palindorme
                    if(s.charAt(i) != s.charAt(j)){
                        // Flag as not palindrome
                        pali = false;
                        // Surely the substring from i+1 to j isn't  palindrome, so we break the loop
                        break;
                    }
                }
                // Substring from i+1 to j is a palindrome, so original string can be a palindrome if we delete one character
                if(pali == true)
                    // Return indexi, which is i's value before the last loop
                    return indexi;
                // Set pali to true before testing next substrinh
                pali = true;
                // Check if the substring from i to j-1 is a palindrome
                for(j = indexj-1; indexi < j;indexi++, j--){
                    // Substring isn't a palindorme
                    if(s.charAt(indexi) != s.charAt(j)){
                        // Flag as not palindrome
                        pali = false;
                        // Surely the substring from i to j-1 isn't  palindrome, so we break the loop
                        break;
                    }
                }
                // Substring from i to j-1 is a palindrome, so original string can be a palindrome if we delete one character
                if(pali == true)
                    // Return indexj, which is j's value before the last two loops
                    return indexj;
                // Pali isn't true, no substring that we've checked resulted in a palindrome, break out of the outer loop to return -1
                break;
            }
        }
        // Either original string is a plindrome, or more than one deletion is required to make it a palindorme
        return -1;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
