import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int count =0;
        // Initializng i(to the third char) in here to check it's value after the loop
        int i = 2;
        for(; i < b.length(); i++){
            // Detected 010 substring, jump 3 chars forward(i+=2 and i++)
            if(b.charAt(i-2)=='0' && b.charAt(i-1)=='1' && b.charAt(i)=='0'){
                count++;
                i += 2;
            }
        }
        // In case we didn't stop at the last char, here we check the last 3 chars
        if(i != b.length()-1 && i != b.length()+2){
            i = b.length()-1;
            if(b.charAt(i-2)=='0' && b.charAt(i-1)=='1' && b.charAt(i)=='0')
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
