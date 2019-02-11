import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] rotLeft(int[] a, int d) {
        /* Start of my code */
        int n = a.length;
        // Creating a new array in the size of the original array, which will contain the elements after rotation
        int[] b = new int[n];
        // Going over all the elements
        for (int i=0; i<n; i++)
        {
            // If after rotating left d times, i is still in bounds, then the i element new position is simply i-d
            if(i-d>=0)
                b[i-d] = a[i];
            // If after rotating left d times i is out of bounds, then the i element new position will be i+(n-d) since we know that d<n and because it basically means that we need to rotate right instead of left
            else
                b[i+(n-d)] = a[i];
        }
        for (int i=0; i<n; i++)
            System.out.print(b[i] + " ");
        return b;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
