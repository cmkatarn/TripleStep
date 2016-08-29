import java.util.Scanner;

/**
 * @author malloneec
 * @since 8/29/16
 */
public class TripleStep {

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the number of stairs on the staircase: ");
        computeCombinations(scnr.nextInt());
    }

    private static void computeCombinations(int stairs){
        int total = takeOne(stairs) + takeTwo(stairs) + takeThree(stairs);
        System.out.println("Total number of combinations = " + total);
    }


     private static int takeOne(int supplied){
         int remaining = supplied - 1;
         if(remaining > 0) {
             return takeOne(remaining) + takeTwo(remaining) + takeThree(remaining);
         }else if(remaining == 0){
             return 1;
         }else{
             return 0;
         }
     }

     private static int takeTwo(int supplied){
         int remaining = supplied - 2;
         if(remaining > 0) {
             return takeOne(remaining) + takeTwo(remaining) + takeThree(remaining);
         }else if(remaining == 0){
             return 1;
         }
         else{
             return 0;
         }
     }

     private static int takeThree(int supplied){
         int remaining = supplied - 3;
         if(remaining > 0) {
             return takeOne(remaining) + takeTwo(remaining) + takeThree(remaining);
         }else if(remaining == 0){
             return 1;
         }
         else{
             return 0;
         }
     }
}
