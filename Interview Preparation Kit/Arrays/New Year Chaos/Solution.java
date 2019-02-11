import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static void minimumBribes(int[] q) {
        /* Start of my code */
        int bribes = 0;
        // Going over the array(line) starting from the end
        for(int i = q.length-1; i >= 0; i--){
            // If the original position of a person(q[i]) was farther than two steps back from his current position(i+1), then the line is too chaotic
            if(q[i] - (i + 1) > 2){
                System.out.println("Too chaotic");
                // This return is in order to stop the function before the next for loop and the printing statement of bribes
                return;
            }
            // Going over the two persons in front of the current person's position(q[i]-2 or 0 if there aren't currently two persons upfront of him), checking if those persons were initially behind him, and if so adding 1 to bribes
            for(int j = Math.max(0, q[i]-2); j < i; j++){
                if(q[j] > q[i])
                    bribes+=1;
            }
        }
    System.out.println(bribes);
    /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
