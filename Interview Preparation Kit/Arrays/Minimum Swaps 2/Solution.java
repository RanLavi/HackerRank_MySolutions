import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int minimumSwaps(int[] arr) {
        /* Start of my code */
        int count = 0;
        // Searching the minimal number starting from 1 until n-1(since the n element will already be swapped with one of the previous elements)
        for (int min = 1; min < arr.length; min++) {
            // If the minimal number is at it's corresponding index, then no swap is needed and we can move to the next iteration
            if(min == arr[min-1])
                continue;
            // Checking the rest of the indexes to verify with which to we need to swap
            for (int i = min; i < arr.length; i++) {
                // Swapping, adding 1 to count and breaking the inner loop
                if (arr[i] == min) {
                    arr[i] = arr[min-1];
                    arr[min-1] = min;
                    count++;
                    break;
                }
            }
        }
        return count;
        /* End of my code */
    }

/* Old code which works, but doesn't use the fact that the numbers are between 1 to n. In every iteration we search the minimal number in the entire array, placing it at the leftest index that we haven't changed yet, and starting the next iteration from the index to it's right
 static int minimumSwaps(int[] arr) {
        int count = 0;
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    k = j;
                }
            }
            if (min != arr[i]) {
                arr[k] = arr[i];
                arr[i] = min;
                count++;
            }
        }

        return count;
    }
*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
