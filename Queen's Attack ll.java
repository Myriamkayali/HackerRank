import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.*;
public class Solution {

    // Complete the queensAttack function below.

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int top = c_q-1; 
        int bottom = n-c_q;
        int left = r_q-1;
        int right = n-r_q ;
        
        int topright = Math.min(top, right);
        int topleft = Math.min(top, left);
        int bottomright = Math.min(bottom, right);
        int bottomleft = Math.min(bottom, left);

        for(int[] obs: obstacles){
            //top 
            
            if(obs[0]==r_q &&  obs[1]<c_q){
                top = Math.min(top,c_q- obs[1]-1); 
            }
            //right
            if(obs[1]==c_q &&  obs[0]>r_q){
                right = Math.min(right, obs[0]-r_q-1); 
            }
           //bottom
            if(obs[0]==r_q &&  obs[1]>c_q){
                bottom = Math.min(bottom, obs[1]-c_q-1); 
            }
            //left
            if(obs[1]==c_q &&  r_q>obs[0]){
                left = Math.min(left, r_q-obs[0]-1); 
            } 
            //topleft
            if(obs[0]<r_q && obs[1]<c_q && Math.abs(r_q-obs[0])==Math.abs(c_q-obs[1])) {
                topleft = Math.min(topleft,Math.abs(r_q-obs[0])-1);
                
            }  
            //topright 
            if(obs[0]>r_q && obs[1]<c_q && Math.abs(obs[0]-r_q)==Math.abs(c_q-obs[1])) {
                topright = Math.min(topright, Math.abs(obs[0]-r_q)-1);
                
            }   
            //bottomright
            if(obs[0]>r_q && obs[1]>c_q && Math.abs(obs[0]-r_q)==Math.abs(obs[1]-c_q)) {
                bottomright = Math.min(bottomright,  Math.abs(obs[1]-c_q)); 
            }  
            
            //bottomleft
            if(obs[0]<r_q && obs[1]>c_q && Math.abs(obs[1]-c_q)==Math.abs(r_q-obs[0]) ){
                bottomleft = Math.min(bottomleft, Math.abs(obs[1]-c_q)-1);
                
            }  
              
                        
     }
        return  bottomleft+bottomright+topright+topleft+left+top+bottom+right;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
