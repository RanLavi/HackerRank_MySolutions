import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static String caesarCipher(String s, int k) {
        /* Start of my code */
        // Using a StringBuilder since strings are immutable, so the original string can't be cahnged
        StringBuilder altered = new StringBuilder(s);
        // Going over the original string
        for(int i = 0; i < s.length(); i++){
            // Save ASCII value of the current character
            int asc = (int)s.charAt(i);
            // ASCII value represents a capital letter
            if(asc >= 65 && asc <=90){
                // Current ASCII value plus required shifts still results in a value which represents a capital letter, which we will change to
                if(asc+k<=90){
                    altered.setCharAt(i, (char)(asc + k));
                   }
                // Current ASCII value plus required shifts results in a value which is outside of the ASCII values that represent a capital letter. So we substract 26 from this value, until it represents a capital letter in ASCII value. The 26 that we substract is the range of ASCII values which represent capital letters 
                else{
                    int tempasc = asc + k;
                    while(tempasc>90)
                        tempasc -= 26;
                    altered.setCharAt(i, (char)tempasc);
                }
            }
            // ASCII value represents a small letter
            if(asc >= 97 && asc <=122){
                // Current ASCII value plus required shifts still results in a value which represents a small letter, which we will change to
                if (asc + k <= 122){
                    altered.setCharAt(i, (char)(asc + k));
                    }
                // Current ASCII value plus required shifts results in a value which is outside of the ASCII values that represent a small letter. So we substrat 26 from this value, until it represents a small letter in ASCII value. The 26 that we substract is the range of ASCII values which represent small letters
                else {
                    int tempasc = asc + k;
                    while (tempasc > 122)
                        tempasc -= 26;
                    altered.setCharAt(i, (char) tempasc);
                }
            }
        }
        // Alter StringBuilder to string and return it
        return altered.toString();
        /* End of my code */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
