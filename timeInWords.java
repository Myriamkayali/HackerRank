import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  
       

       static String timeInWords(int h, int m) {
 String hours[] = {"one", "two", "three", "four", "five", "six", "seven", 
                    "eight", "nine", "ten", "eleven", "twelve"};

        String minutes[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
                       "eleven", "twelve", "thirteen", "fourteen", "quarter", 
                       "sixteen", "seventeen", "eighteen", "ninteen", "twenty",
                       "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", 
                       "twenty six", "twenty seven", "twenty eight", "twenty nine", "half"};
                       
                       
        if(m == 0){
           return (hours[h-1]+" o' clock");
       }   

     
          else if (m <= 30){
        
           if(m==1){
               return (minutes[m-1]+" minute past " + hours[h-1]);
           }
           else if(m==30 || m==15){
               return (minutes[m-1]+" past " + hours[h-1]);
           }
           else {
               return (minutes[m-1]+" minutes past " + hours[h-1]);
           }
       }
       else  {
           int m1 = 60-m;
           if(m1==15){
               
               return (minutes[m1-1]+" to " + hours[h]);
           }
           else{
           return (minutes[m1-1]+" minutes to " + hours[h]);
           }
       }
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
