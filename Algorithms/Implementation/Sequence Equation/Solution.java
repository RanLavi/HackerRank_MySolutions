import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] arr = new int[p.length];
        // HashMap to contain the array's values and indexes
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < p.length; i++)
            myMap.put(p[i],i+1);
        // Getting the value(index) of key x, and then the value(index) from the key which is actually the previous value(index) 
        for(int x = 1; x <= p.length; x++){
            int num = myMap.get(x);
            arr[x-1] = myMap.get(num);
        }
        return arr;
    }   


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

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
