import java.util.*;

/**
 * @author malloneec
 * @since 8/29/16
 */
public class TripleStep {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the number of stairs on the staircase: ");
        computeCombinations(scnr.nextInt());
    }

    private static void computeCombinations(int stairs){
        long startTime = System.currentTimeMillis();
        System.out.println("[RECURSION] Beginning time: " + startTime);
        System.out.println("[RECURSION] Total number of combinations (recursive) = " + takeSteps(stairs));
        long endTime = System.currentTimeMillis();
        System.out.println("[RECURSION] Completion time: "+ endTime);
        System.out.println("[RECURSION] Time difference = " + (endTime-startTime) + "ms");
        startTime = System.currentTimeMillis();
        System.out.println("[MEMOIZATION] Beginning time: " + startTime);
        System.out.println("[MEMOIZATION] Total number of combinations (recursive) = " + steps_with_memo(stairs));
        endTime = System.currentTimeMillis();
        System.out.println("[MEMOIZATION] Completion time: "+ endTime);
        System.out.println("[MEMOIZATION] Time difference = " + (endTime-startTime) + "ms");
    }

     private static int takeSteps(int supplied){
         if(supplied > 0) {
             return takeSteps(supplied - 1) + takeSteps(supplied - 2) + takeSteps(supplied - 3);
         }else if(supplied == 0){
             return 1;
         }
         else{
             return 0;
         }
     }

     private static int steps_with_memo(int supplied){
         if(supplied < 0){
             return 0;
         }else if(supplied == 0){
             return 1;
         }else{
             if(!memo.containsKey(supplied)){
                 memo.put(supplied, steps_with_memo(supplied - 1) + steps_with_memo(supplied - 2) + steps_with_memo(supplied - 3));
             }
             return memo.get(supplied);
         }
     }
}
