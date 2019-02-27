import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    static String balancedSums(List<Integer> arr) {
        /* Start of my code */
        // Initializing left and right sums and indexes
        int leftSum = 0;
        int rightSum = 0;
        int leftIndex = 0;
        int rightIndex = arr.size()-1;
        // Stop condition for when we finish summing all the elements into the two sums, leaving one elemnt in the middle, which both indexes should point to. This of course means it cathces lists of size 1, leaving our sums at zero and returning "YES"
        while(leftIndex!=rightIndex)
        {
            // If the sums are currently equal(like when we begin)
            if(leftSum==rightSum){
                // Check if the element in the leftIndex is smaller than the one in the rightIndex
                if(arr.get(leftIndex) < arr.get(rightIndex)){
                    // Add the element to the corresponding sum
                    leftSum += arr.get(leftIndex);
                    // Move index one step forward
                    leftIndex++;
                }
                // If the element in the leftIndex isn't smaller than the one in the rightIndex
                else{
                    // Add the element to the corresponding sum
                    rightSum += arr.get(rightIndex);
                    // Move index one step back
                    rightIndex--;
                }
            }
            // If the sums aren't currently equal
            else{
                // If leftSum is smaller than rightSum
                if(leftSum < rightSum){
                    // Add the element in the leftIndex
                    leftSum += arr.get(leftIndex);
                    // Move index one step forward
                    leftIndex++;
                }
                // If leftSum isn't smaller than rightSum
                else{
                    // Add the element in the rightIndex
                    rightSum += arr.get(rightIndex);
                    // Move index one step back
                    rightIndex--;
                }
            }
        }
        // Checking sums
        if(leftSum==rightSum)
            return "YES";
        return "NO";
        /* End of my code */
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
