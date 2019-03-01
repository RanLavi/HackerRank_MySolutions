import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static String twoStrings(String s1, String s2) {
        /* Start of my code */
        // Creating a hashset for characters since number of appearances doesn't matter
        HashSet<Character> mySet = new HashSet<Character>(); 
        // Dividing the string s1 into chars and adding them to the set
        for(char c: s1.toCharArray())
            mySet.add(c);
        // Dividing the s2 string into chars and checking if any char from s2 appear in set, return yes if so
        for(char c: s2.toCharArray()) {
            if (mySet.contains(c))
                return "YES";
        }
        // No characters from s2 were found in set(s1), return no
        return "NO";
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
