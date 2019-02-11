import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        /* Start of my code */
        // The returned array will have the size of Alice's array
        int[] result = new int[alice.length];
        // We don't know how many ranks are there, so it's necessary to start from the top
        int rank = 1;
        // Since we start fom the top rank, we'll start with Alice's highest scores, which are at the end of the array since it's descending
        int i = alice.length-1;
        // The scores array will be checked from the start of the array, since it's ascending
        // We stop the loop once we reach the bounds of either array, and in each iteration we move either the i or j, but not both, so those are not defind in the increment/decrement statement part of the loop
        for(int j = 0;i >= 0 && j < scores.length;){
            // Alice's i score rank is found, since it's higher or equal to current j score, and smaller than the previous j(unless rank is currently still 1)
            if(alice[i] >= scores[j]){
                result[i] = rank;
                // We decrement i. j remains unchanged since Alice's next score we check can still be higher or equal to the current j score 
                i--;
            }
            // If Alice's i score is lower than the current j score
            else{
                // First, rank is incremented
                rank++;
                // Then, if we've reached the bounds of the scores array, break the loop
                if(j + 1 >= scores.length)
                    break;
                else{
                    // If we didn't reach the bounds of the scores array, increment j
                    j++;
                    // Making sure the next j score we check will be lower than the current j score we just checked. Since otherwise, we might change the rank even though the next j score is squal to the current j score, meaning they have the same rank. We also need to check every time that the next j is still in bounds of the score array
                while(j + 1 < scores.length && scores[j]==scores[j-1]){
                    j++;
                    }
                }
            }
        }
        // If after finishing going over all the scores array, we didn't find any score which is lower or equal to the current Alice's score, then Alice's current and remaining scores are equal to the current rank 
        if(i >= 0){
            for(;i >= 0; i--){
                result[i] = rank;
            }
        }
        return result;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
