import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int flatlandSpaceStations(int n, int[] c) {
        /* Start of my code */
        // Creating an array to store the distance from each city to the nearest space station
        int[] currMax = new int[n];
        // Setting the default value for each distance to be the maximal int
        for(int i = 0; i < n; i++){
            currMax[i] = Integer.MAX_VALUE;
        }
        // Going over each city
        for(int i = 0; i < n; i++){
            // Going over each space station
            for(int j=0; j<c.length; j++){
                // City has a space station, so the nearest station is in 0 distance and we can break the inner loop
                if(i == c[j]){
                    currMax[i] = 0;
                    break;
                }
                // Checking if the current space station is nearer to the current city we're checking than the previous sapce stations we checked
                currMax[i] = Math.min(currMax[i], Math.abs(i - c[j]));
            }
        }
        // Determining the maximal distance found from all the cities to their nearest respective space station
        int max = 0;
        for(int i = 0; i < n; i++){
            if(max < currMax[i]) 
                max = currMax[i];
        }
        return max;
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
