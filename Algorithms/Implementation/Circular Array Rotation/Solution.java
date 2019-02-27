import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        /* Start of my code */
        // Creating an aray at the length of the queries array
        int[] b = new int[queries.length];
        //  If k is bigger than the length of array a, then we need to shrink it to the array's proportions, so that we can later find the original index by calculating the difference between array's a length and k
        if(k>a.length)
            k = k % a.length;
        // Going over the queries array, no real reason to rotate all the elements from array a, only the ones that appear in the queries array
        for(int i=0; i < queries.length; i++){
            // If rotating back left k steps doesn't give a negative number, then this is the index we're looking for
            if(queries[i] - k >= 0)
                b[i] = a[queries[i]-k];
            // If rotating back left k steps gives a negative number, then instead add the difference between the size of array a and k. The modulo is for some of these scenarios in which k is bigger than the size of array a, thus resulting in an index which may be out of bounds unless we use the modulo to shrink k to the necessary propotions 
            else
                b[i] = a[queries[i]+(a.length-k)];
        }
        return b;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

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
