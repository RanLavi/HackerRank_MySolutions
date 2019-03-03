import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int viralAdvertising(int n) {
        /* Start of my code */
        // Initializing likes of the first day, since the intial calcualtion with 5 people wouldn't work smoothly in a loop
        int likeTotal=2;
        int likeYesterday=2;
        // Going over the rest of the n-1 days
        for(int i=1; i<n; i++){
            // Each day adding likes according to the formula
            likeTotal += likeYesterday*3/2;
            // Saving the amounts of likes added in order to be able to calculate the amount of people that this will be shared with tomorrow and the amount of likes that will be added
            likeYesterday = likeYesterday*3/2;
        }
        // Return total number of likes
        return likeTotal;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
