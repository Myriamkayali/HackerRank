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

class Result {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        
        List<Integer> rank = new ArrayList<Integer>();
       
        ArrayList<Integer> ranked2 = new ArrayList<Integer>(); 

        for (int element : ranked) { 

            if (!ranked2.contains(element)) { 
  
                ranked2.add(element); 
            } 
        } 
            
        int count = 1;
        
        for (int p : player) {
             for(int i=0;i<ranked2.size();i++){
                 if(i==ranked2.size()-1){
                     if(p>=ranked2.get(i)){
                                          rank.add(ranked2.size());
                        count=1;

                     }
                     else{
                                          rank.add(ranked2.size()+1);

                          
                            count=1;
                             break;
                     }
                     
                     
                 }
                 
             else if(p>=ranked2.get(i)){
                 rank.add(count);
                 count=1;
                 break;
             }
             else if(p<ranked2.get(i)){   
                 count = count + 1;

             }
            }
        }
    return rank;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

--------------------------------------------------------------------------------------------
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

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ///rank array
        List<Integer> rank = new ArrayList<Integer>();
        int rank1=1;
        rank.add(1);
        for(int i=0; i<ranked.size();i++){
            if(i+1==ranked.size()){
                break;
            }
            else if(ranked.get(i)==ranked.get(i+1)){
                rank.add(rank1);
                
            }
            else if(ranked.get(i)>ranked.get(i+1)){
                rank1 += 1;
                rank.add(rank1);
                
            }
            
        }
        // do binary search 
        List<Integer> results = new ArrayList<Integer>();
        for(int i=0;i<player.size();i++){
            int playerScore = player.get(i);
            if(playerScore > ranked.get(0)){
                results.add(1);
            }
            else if(playerScore < ranked.get(ranked.size()-1)){
                results.add(rank.get(rank.size()-1)+1);
            }
            else {
                int index = binarySearch(ranked, playerScore);
                results.add(rank.get(index));
            }
        }
        return results;
    }
   private static int binarySearch(List<Integer> ranked, int score){
       
          
        int low = 0;
        int high = ranked.size() - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ranked.get(mid) == score){
                return mid;
            }
            else if( ranked.get(mid) < score && score < ranked.get(mid-1)){
                return mid;
            }
            
            else if( ranked.get(mid) > score && score >= ranked.get(mid+1)){
                return mid + 1;
            }
            else if( ranked.get(mid) < score){
                high = mid - 1;
            }
            else if( ranked.get(mid) > score){
                low = mid + 1;
            }
       }
       return -1;
    //     int low = 0;
    //     int high = ranked.size() - 1;
    //     while(low <= high){
    //         int mid = low + (high - low)/2;
    //         if(ranked.get(mid) == score){
    //             return mid;
    //         }
    //         else if( ranked.get(mid) < score && score < ranked.get(mid-1)){
    //             return mid;
    //         }
            
    //         else if( ranked.get(mid) > score && score >= ranked.get(mid+1)){
    //             return mid + 1;
    //         }
    //         else if( ranked.get(mid) < score){
    //             high = mid - 1;
    //         }
    //         else if( ranked.get(mid) > score){
    //             low = mid + 1;
    //         }
    //    }
    //    return 1;
   }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}









C