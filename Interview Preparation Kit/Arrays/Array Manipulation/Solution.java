import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* Improved code in O(n) */
public class Solution {
    static long arrayManipulation(int n, int[][] queries) {
        /* Start of my code */
        // Creating a new array to store n elements 0
        long arr[] = new long[n];
        // Going over all the queries and instead of going over all the indexes in our new array according to the bounds which are in the specific query, we will use our array as a prefix sum array. Which means that every element is equal to the sum of the previous elements with itself. So we add queries[i][2] to arr[queries[i][0]-1], which is the left index in the range, and substract queries[i][2] from arr[queries[i][1]], which is the next index after the right index(we should make sure it's in range)
        for(int i=0; i < queries.length; i++){
                // The addition command of the left index in the current range
                arr[queries[i][0] - 1] += queries[i][2];
                // The substraction command of the next index after the right index in the current range(first making sure that it's in range, otherwise no reason to substract from it and it will of course lead to an array index out of bounds exception)
                if(queries[i][1] < n)
                    arr[queries[i][1]] -= queries[i][2];
        }
        // Setting max, which is of type long according to the function's return value
        long max = arr[0];
        long temp = arr[0];
        // Verifying which element is the maximal value from the array we've created 
        for(int i=1; i < n; i++){
            temp += arr[i];
            if(max<temp)
                max = temp;
        }
        return max;
        /* End of my code */
    }

/* Old code which is working fine, but in O(n^2)
public class Solution {
    static long arrayManipulation(int n, int[][] queries) {
        /* Start of my code /*
        // Creating a new array to store n elements 0
        long arr[] = new long[n];
        // Going over all the queries
        for(int i=0; i < queries.length; i++){
            // Going over the indexes in our new array according to the bounds which are in the specific query, strating and finishing one index before(since queries are considering the index numbers start from 1, but in fact arrays index numbers start from 0)
            for(int j = queries[i][0] - 1; j < queries[i][1]; j++){
                // The addition command of the desired element to the current index
                arr[j] += queries[i][2];
            }
        }
        // Setting max, which is of type long according to the function's return value
        long max = arr[0];
        // Verifying which element is the maximal value from the array we created and added to  
        for(int i=1; i < arr.length; i++){
            if(max<arr[i])
                max = arr[i];
        }
        return max;
        /* End of my code /*
    }
*/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
