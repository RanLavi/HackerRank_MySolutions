import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            /* Start of my code */
            // Max is set to 0, which is the minimum outcome number for a bitwise AND operator
            int max = 0;
            // Going over all the number from 1 to n-1
            for(int i = 1; i < n; i++){
                // Going over all the numbers from i+1 to n
                for(int j = i+1; j <= n; j++){
                    // Checking common bits with the bitwise AND(&) operator
                    int temp = i&j;
                    // Checking if the current AND operator produced a number higher than the current max and lower than k
                    if(temp > max && temp < k)
                        max = temp;
                }
            }
            System.out.println(max);
            /* End of my code */
        }
        scanner.close();
    }
}
