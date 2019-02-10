import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int pairs(int k, int[] arr) {
        /* Start of my code */
        Arrays.sort(arr);
        int count = 0;
        // After sorting the array, we start substracting from the highest number and going down
        for(int i=arr.length - 1; i > 0; i--){
            // From the highest number, we substract the highest number available before him, going down
            for(int j=i-1; j>=0; j--){
                // The substraction equals k, add 1 to count. Assuming no duplicates, we can break the inner loop and go to the next i since the substraction with the next j will create a number higher than k
                if(arr[i]-arr[j]==k){
                    count++;
                    break;
                }
                // The substraction is higher than k, so the substraction with the next j will create an even higher number, meaning we can break the loop and go to the next i
                if(arr[i]-arr[j]>k)
                    break;
            }
        }
    return count;
    /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
