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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    int[] multiplesOf5 = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100};
    List<Integer> m5 = IntStream.of(multiplesOf5).boxed().collect(Collectors.toList());
    Arrays.asList(multiplesOf5);
     List<Integer> updatedMarks = new ArrayList<>();
     for(Integer mark: grades) {
         if(mark < 38) {
                 updatedMarks.add(mark);
                 continue;
             }  
         for(Integer n: m5) {       
             if(mark > n){     
                continue;
              } else {
                  if((n - mark ) < 3){
                      updatedMarks.add(n);          
                  } else {
                      updatedMarks.add(mark);
                  }
                  break;
              }
         }
     }
     return updatedMarks;
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

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
